package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import DAO_Interface.IDAOPhieuLuongCongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ptud.Entity.PhieuLuongCongNhan;

public class DAO_PhieuLuongCongNhan extends UnicastRemoteObject implements IDAOPhieuLuongCongNhan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8525365560857119801L;
	private EntityManager em;
	 
	public DAO_PhieuLuongCongNhan() throws RemoteException {
	        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	    }
	
	@Override
	public PhieuLuongCongNhan get(String id) throws RemoteException {
		 return em.find(PhieuLuongCongNhan.class, id);
	}
	 public static DAO_PhieuLuongCongNhan getInstance() throws RemoteException {
	        return new DAO_PhieuLuongCongNhan();
	    }

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<PhieuLuongCongNhan> getAll() throws RemoteException {
		 try {
	            
				ArrayList<PhieuLuongCongNhan> resultList = (ArrayList<PhieuLuongCongNhan>) em.createNativeQuery("SELECT * FROM PhieuLuongCongNhan",
	                    PhieuLuongCongNhan.class).getResultList();
	            return resultList;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public boolean insert(PhieuLuongCongNhan t) throws RemoteException {
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
	public boolean update(PhieuLuongCongNhan t) throws RemoteException {
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
            PhieuLuongCongNhan t = get(id);
            if (t != null) {
                em.getTransaction().begin();
                em.remove(t);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public ArrayList<PhieuLuongCongNhan> getAllByThangNam(int thang, int nam) throws RemoteException {
		ArrayList<PhieuLuongCongNhan> phieuLuongCongNhans = new ArrayList<>();
	    try {
	        String query = "SELECT p FROM PhieuLuongCongNhan p WHERE p.thang = :thang AND p.nam = :nam";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("thang", thang);
	        jpqlQuery.setParameter("nam", nam);
	        List<PhieuLuongCongNhan> results = jpqlQuery.getResultList();
	        
	        for (PhieuLuongCongNhan phieuLuongCongNhan : results) {
	            phieuLuongCongNhans.add(phieuLuongCongNhan);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return phieuLuongCongNhans;
	}

	@Override
	public ArrayList<PhieuLuongCongNhan> getAllByMaPBThangNam(String maBP, int thang, int nam) throws RemoteException {
		ArrayList<PhieuLuongCongNhan> phieuLuongCongNhans = new ArrayList<>();
	    try {
	        String query = "SELECT p FROM PhieuLuongCongNhan p WHERE p.maCN IN (SELECT cn.maCN FROM CongNhan cn WHERE cn.maBP = :maBP) AND p.thang = :thang AND p.nam = :nam";
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("maBP", maBP);
	        jpqlQuery.setParameter("thang", thang);
	        jpqlQuery.setParameter("nam", nam);
	        List<PhieuLuongCongNhan> results = jpqlQuery.getResultList();
	        
	        for (PhieuLuongCongNhan phieuLuongCongNhan : results) {
	            phieuLuongCongNhans.add(phieuLuongCongNhan);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return phieuLuongCongNhans;
	}

}
