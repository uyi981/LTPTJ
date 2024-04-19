package DAO_Implement;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import DAO_Interface.IDAOPhieuLuongNhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ptud.Entity.PhieuLuongCongNhan;
import ptud.Entity.PhieuLuongNhanVien;

public class DAOPhieuLuongNhanVien implements IDAOPhieuLuongNhanVien	{
	private EntityManager em;
	 
	public DAOPhieuLuongNhanVien() throws RemoteException {
	        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	    }
	public static DAOPhieuLuongNhanVien getInstance() throws RemoteException {
	        return new DAOPhieuLuongNhanVien();
	    }
	@Override
	public PhieuLuongNhanVien get(String id) throws RemoteException {
		return em.find(PhieuLuongNhanVien.class, id);
	}

	@Override
	public ArrayList<PhieuLuongNhanVien> getAll() throws RemoteException {
		try {
            
			ArrayList<PhieuLuongNhanVien> resultList = (ArrayList<PhieuLuongNhanVien>) em.createNativeQuery("SELECT * FROM PhieuLuongNhanVien",
                    PhieuLuongCongNhan.class).getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public boolean insert(PhieuLuongNhanVien t) throws RemoteException {
		 try {
	            em.getTransaction().begin();
	            em.persist(t);
	            em.getTransaction().commit();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public boolean update(PhieuLuongNhanVien t) throws RemoteException {
		try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean deleteById(String id) throws RemoteException {
		try {
            PhieuLuongNhanVien p = get(id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public ArrayList<PhieuLuongNhanVien> getAllByMaPBThangNam(String maBP, int thang, int nam) throws RemoteException {
		ArrayList<PhieuLuongNhanVien> phieuLuongNhanViens = new ArrayList<>();
	    try {
	        String query = "SELECT p FROM PhieuLuongCongNhan p WHERE p.maCN IN (SELECT cn.maCN FROM CongNhan cn WHERE cn.maBP = :maBP) AND p.thang = :thang AND p.nam = :nam";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("maBP", maBP);
	        jpqlQuery.setParameter("thang", thang);
	        jpqlQuery.setParameter("nam", nam);
	        List<PhieuLuongNhanVien> results = jpqlQuery.getResultList();
	        
	        for (PhieuLuongNhanVien phieuLuongNhanVien : results) {
	            phieuLuongNhanViens.add(phieuLuongNhanVien);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return phieuLuongNhanViens;
	}
	

	@Override
	public ArrayList<PhieuLuongNhanVien> getAllByThangNam(int thang, int nam) throws RemoteException {
		ArrayList<PhieuLuongNhanVien> phieuLuongNhanViens = new ArrayList<>();
	    try {
	        String query = "SELECT p FROM PhieuLuongNhanVien p WHERE p.thang = :thang AND p.nam = :nam";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("thang", thang);
	        jpqlQuery.setParameter("nam", nam);
	        List<PhieuLuongNhanVien> results = jpqlQuery.getResultList();
	        
	        for (PhieuLuongNhanVien phieuLuongNhanVien : results) {
	            phieuLuongNhanViens.add(phieuLuongNhanVien);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return phieuLuongNhanViens;
	}

}
