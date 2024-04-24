package DAO_Implement;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import ptud.Entity.TaiKhoan;

public class DAO_TaiKhoan extends UnicastRemoteObject implements DAO_Interface.IDAOTaiKhoan{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127304083126447988L;
	private EntityManager em;
	 
	public DAO_TaiKhoan() throws RemoteException {
	        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
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
		        String query = "SELECT nv.ten FROM NhanVien nv WHERE nv.maNV = :maNV";
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TaiKhoan> getAll() throws RemoteException {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
	    try {
	        String query = "Select tk from TaiKhoan tk";
	        return (ArrayList<TaiKhoan>) em.createQuery(query).getResultList();
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
	public boolean deleteTaiKhoanByID(String userName) throws RemoteException {
		  try {
		        TaiKhoan taiKhoan = getAll().get(7);
		        if (taiKhoan != null) {
		            em.getTransaction().begin();
		            em.remove(taiKhoan);
		            em.getTransaction().commit();
		            return true;
		        } else {
		            System.out.println("Không tìm thấy tài khoản có ID: " + userName);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return false;
	}

}