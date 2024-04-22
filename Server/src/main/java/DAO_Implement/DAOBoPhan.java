package DAO_Implement;

import DAO_Interface.IDAOBoPhan;
import jakarta.persistence.EntityManager;
import ptud.Entity.BoPhan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DAOBoPhan extends UnicastRemoteObject implements IDAOBoPhan {

	private EntityManager em;

	public DAOBoPhan() throws RemoteException {
		em = jakarta.persistence.Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	@Override
	public BoPhan get(String id) throws RemoteException {
		return em.find(BoPhan.class, id);
	}

	@Override
	public ArrayList<BoPhan> getAll() throws RemoteException {
		// Use NativeQuery to get all BoPhan
		try {
			ArrayList<BoPhan> resultList = (ArrayList<BoPhan>) em
					.createNativeQuery("SELECT * FROM BoPhan", BoPhan.class).getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insert(BoPhan boPhan) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(boPhan);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(BoPhan boPhan) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(boPhan);
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
			BoPhan boPhan = get(id);
			if (boPhan != null) {
				em.getTransaction().begin();
				em.remove(boPhan);
				em.getTransaction().commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<BoPhan> filter(String prefix) throws RemoteException {
		// "SELECT * FROM BoPhan WHERE maBP LIKE ? OR maBP LIKE ?"
		try {
			ArrayList<BoPhan> resultList = (ArrayList<BoPhan>) em
					.createNativeQuery("SELECT * FROM BoPhan WHERE maBP LIKE ? OR tenBP LIKE ?", BoPhan.class)
					.setParameter(1, prefix + "%").setParameter(2, prefix + "%").getResultList();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getMaBoPhanByTenBoPhan(String tenBoPhan) throws RemoteException {
		try {
			String query = "select maBP from BoPhan\r\n"
					+ "where tenBP = ? \r\n";
			String result = (String) em.createNativeQuery(query).setParameter(1, tenBoPhan).getSingleResult();
			return result;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return null;
	}
}
