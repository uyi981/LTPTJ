package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import jakarta.persistence.Persistence;
import ptud.Entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_NhanVien extends UnicastRemoteObject implements DAO_Interface.IDAONhanVien
{
  EntityManager em;
	public DAO_NhanVien() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272268639921122950L;
	@Override
	public int countAll() throws RemoteException
	{
		return em.createQuery("select a from NhanVien a", NhanVien.class).getResultList().size();
	}
	 public static DAO_NhanVien getInstance() throws RemoteException {
	        return new DAO_NhanVien();
	    }

	@Override
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nhanVien);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public boolean suaNhanVien(NhanVien nhanVien) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(nhanVien);
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
	public boolean xoaNhanVien(String maNV) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			NhanVien nhanVien = em.find(NhanVien.class, maNV);
			em.remove(nhanVien);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public NhanVien timKiemNhanVien(String maNV) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(NhanVien.class, maNV);		
	}




	@Override
	public List<NhanVien> layDanhSachNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("select a from NhanVien a", NhanVien.class).getResultList();
	}
	@Override
	public String getMaBoPhan(String nhanVien) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select maBP from NhanVien where maNV = :maNV").setParameter("maNV", nhanVien).getSingleResult().toString();
	}
}
