package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ptud.Entity.KhachHang;

public class DAOKhachHang extends UnicastRemoteObject implements DAO_Interface.IDAOKhachHang{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2441975338527262012L;

	private jakarta.persistence.EntityManager em;	 
	public DAOKhachHang() throws RemoteException {
		
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean themKhachHang(KhachHang khachHang) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
            tx.begin();
            em.persist(khachHang);
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
	public boolean SuaKhachHang(KhachHang khachHang) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(khachHang);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stubs
		
	}
	@Override
	public boolean xoaKhachHang(String maKH) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			KhachHang khachHang = em.find(KhachHang.class, maKH);
			em.remove(khachHang);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		
	}
	@Override
	public KhachHang timKiemKhachHang(String maKH) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(KhachHang.class, maKH);
	}
	@Override
	public List<KhachHang> LayDanhSachKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT kh FROM KhachHang kh", KhachHang.class).getResultList();
	}

	


}
