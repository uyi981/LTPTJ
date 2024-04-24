package DAO_Implement;

import DAO_Interface.IDAOBangDanhGiaNhanVien;
import jakarta.persistence.EntityManager;
import ptud.Entity.BangDanhGiaNhanVien;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DAO_BangDanhGiaNhanVien extends UnicastRemoteObject implements IDAOBangDanhGiaNhanVien {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8257448735008595364L;
	private EntityManager em;

    public DAO_BangDanhGiaNhanVien() throws RemoteException {
        em = jakarta.persistence.Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
    }

    @Override
    public BangDanhGiaNhanVien get(String id) throws RemoteException {
        return em.find(BangDanhGiaNhanVien.class, id);
    }

    @Override
    public ArrayList<BangDanhGiaNhanVien> getAll() throws RemoteException {
        // Use NativeQuery to get all BangDanhGiaNhanVien
        try {
            return (ArrayList<BangDanhGiaNhanVien>) em.createNativeQuery("SELECT * FROM BangDanhGiaNhanVien",
                    BangDanhGiaNhanVien.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(BangDanhGiaNhanVien bangDanhGia) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.persist(bangDanhGia);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(BangDanhGiaNhanVien bangDanhGia) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.merge(bangDanhGia);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(String maBDG) throws RemoteException {
        try {
            BangDanhGiaNhanVien bangDanhGia = get(maBDG);
            if (bangDanhGia == null) {
                return false;
            }
            em.getTransaction().begin();
            em.remove(bangDanhGia);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BangDanhGiaNhanVien getBangDanhGiaCuaNhanVien(String maNV, int year) throws RemoteException {
        try {
            return (BangDanhGiaNhanVien) em.createNativeQuery("SELECT * FROM BangDanhGiaNhanVien WHERE maNV = ? AND nam = ?",
                    BangDanhGiaNhanVien.class).setParameter(1, maNV).setParameter(2, year).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void addOrUpdate(BangDanhGiaNhanVien bangDanhGiaNhanVien) throws RemoteException {
        try {
            if (get(bangDanhGiaNhanVien.getId()) == null) {
                // Thêm mới
                em.getTransaction().begin();
                em.persist(bangDanhGiaNhanVien);
                em.getTransaction().commit();
            } else {
                // Cập nhật
                em.getTransaction().begin();
                em.merge(bangDanhGiaNhanVien);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
