package DAO_Implement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import DAO_Interface.IDAOHopDong;
import ptud.Entity.HopDong;	
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;
public class DAOHopDong extends UnicastRemoteObject implements DAO_Interface.IDAOHopDong{
     EntityManager em;
	public DAOHopDong() throws RemoteException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MSSQL");
		em = emf.createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3158738830617015803L;

	@Override
	public boolean themHopDong(HopDong hopDong) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(hopDong);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suaHopDong(HopDong hopDong) throws RemoteException
	{
		EntityTransaction tx = em.getTransaction();
		try 
		{
			tx.begin();
			em.merge(hopDong);
			tx.commit();
			return true;
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaHopDong(String maHD) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			HopDong hopDong = em.find(HopDong.class, maHD);
			em.remove(hopDong);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public HopDong timKiemHopDong(String maHD) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(HopDong.class, "maHD");
	}
	
	@Override
	public List<HopDong> layDanhSachHopDong() throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("select hd from HopDong hd").getResultList();
	}



}
