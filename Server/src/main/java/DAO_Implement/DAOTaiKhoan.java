package DAO_Implement;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import ptud.Entity.TaiKhoan;

public class DAOTaiKhoan extends UnicastRemoteObject implements DAO_Interface.IDAOTaiKhoan{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127304083126447988L;
	private EntityManager em;
	 
	public DAOTaiKhoan() throws RemoteException {
	        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	    }
	
	@Override
	public DAOTaiKhoan getInstance() throws RemoteException {
		return new DAOTaiKhoan();
	}

	@Override
	public String hashPassword(String password, int length) throws RemoteException {
		 try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashedBytes) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString().substring(0, Math.min(length, sb.length()));
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public int getUserRole(String username, String password) throws RemoteException {
		try {
	        String query = "SELECT t.vaiTro FROM TaiKhoan t WHERE t.userName = :username AND t.matKhau = :password";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("username", username);
	        jpqlQuery.setParameter("password", hashPassword(password, 16)); // Hãy chắc chắn rằng hàm hashPassword được định nghĩa đúng cách
	        Object result = jpqlQuery.getSingleResult();
	        if (result != null) {
	            return (int) result;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public String getTenNhanVienTaiKhoanByIDNV(String maNV) throws RemoteException {
		 try {
		        String query = "SELECT nv.tenNV FROM NhanVien nv WHERE nv.maNV = :maNV";
		        Query jpqlQuery = em.createQuery(query);
		        jpqlQuery.setParameter("maNV", maNV);
		        Object result = jpqlQuery.getSingleResult();
		        if (result != null) {
		            return (String) result;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return "";
	}

	@Override
	public int getUserRoleByUserName(String username) throws RemoteException {
		try {
	        String query = "SELECT t.vaiTro FROM TaiKhoan t WHERE t.userName = :username";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("username", username);
	        Object result = jpqlQuery.getSingleResult();
	        if (result != null) {
	            return (int) result;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public ArrayList<TaiKhoan> getAll() throws RemoteException {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
	    try {
	        String query = "SELECT TK.maNV, TK.userName, TK.matKhau, TK.vaiTro, NV.tenNV " +
	                       "FROM TaiKhoan TK " +
	                       "JOIN NhanVien NV ON TK.maNV = NV.maNV " +
	                       "WHERE TK.trangThai = 1";
	        Query jpqlQuery = em.createQuery(query);
	        List<Object[]> results = jpqlQuery.getResultList();

	        for (Object[] result : results) {
	            TaiKhoan tk = new TaiKhoan((String) result[1], (String) result[0], (String) result[2], (int) result[3], true);
	            dsTaiKhoan.add(tk);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dsTaiKhoan;
	}

	@Override
	public boolean updateTaiKhoan(TaiKhoan tk) throws RemoteException {
		try {
            em.getTransaction().begin();
            em.merge(tk);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
		
	}

	@Override
	public boolean createTaiKhoan(TaiKhoan tk) throws RemoteException {
		 try {
	            em.getTransaction().begin();
	            em.persist(tk);
	            em.getTransaction().commit();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public boolean deleteTaiKhoanByID(String id) throws RemoteException {
		  try {
		        TaiKhoan taiKhoan = em.find(TaiKhoan.class, id);
		        if (taiKhoan != null) {
		            em.getTransaction().begin();
		            em.remove(taiKhoan);
		            em.getTransaction().commit();
		            return true;
		        } else {
		            System.out.println("Không tìm thấy tài khoản có ID: " + id);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
	}

}
