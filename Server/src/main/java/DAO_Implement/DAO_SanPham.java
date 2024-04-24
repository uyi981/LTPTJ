package DAO_Implement;
import java.rmi.RemoteException;
import java.util.List;

import ptud.Entity.CongDoan;
import ptud.Entity.SanPham;
import java.rmi.server.UnicastRemoteObject;

import DAO_Interface.IDAOSanPham;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
public class DAO_SanPham extends UnicastRemoteObject  implements IDAOSanPham 
{
    EntityManager em;
	public DAO_SanPham() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3804424582259813759L;
	@Override
	public boolean themSanPham(SanPham sanPham) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(sanPham);
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
	public boolean suaSanPham(SanPham sanPham) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
            tx.begin();
            em.merge(sanPham);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
		// TODO Auto-generated method stub
		return false;
	}
	}

	@Override
	public boolean xoaSanPham(String maSanPham) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			SanPham sanPham = em.find(SanPham.class, maSanPham);
			em.remove(sanPham);
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
	public SanPham timKiemSanPham(String maSanPham) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(SanPham.class, maSanPham);
	}

	@Override
	public List<SanPham> layDanhSachSanPham() throws RemoteException {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT sp FROM SanPham sp").getResultList();
	}

	@Override
	public int getTienDo(String maSP) throws RemoteException 
	{
		
		// TODO Auto-generated method stub
		List<?> list = em.createNativeQuery("SELECT * FROM CongDoan WHERE maSP = ?", CongDoan.class)
				.setParameter(1, maSP).getResultList();
		List<CongDoan> congDoans = (List<CongDoan>) list;
		int i =0;
		int min =0;
		for (CongDoan congDoan : congDoans) 
		{
			if(i==0)
			{
				min = congDoan.getSoLuongHoanThanh();
			}
			else
			{
				if(min>congDoan.getSoLuongHoanThanh())
                {
                    min = congDoan.getSoLuongHoanThanh();
                }
			}
		}
		return min;
		
	}
}
	


