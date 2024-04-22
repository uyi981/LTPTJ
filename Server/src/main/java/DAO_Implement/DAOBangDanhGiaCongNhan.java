package DAO_Implement;

import DAO_Interface.IDAOBangDanhGiaCongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import ptud.Entity.BangDanhGiaCongNhan;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DAOBangDanhGiaCongNhan extends UnicastRemoteObject implements IDAOBangDanhGiaCongNhan {

    private EntityManager em;

    public DAOBangDanhGiaCongNhan() throws RemoteException {
        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
    }

    @Override
    public BangDanhGiaCongNhan get(String id) throws RemoteException {
        return em.find(BangDanhGiaCongNhan.class, id);
    }

    @Override
    public ArrayList<BangDanhGiaCongNhan> getAll() throws RemoteException {
        // Use QueryNative to get all BangDanhGiaCongNhan
        try {
            return (ArrayList<BangDanhGiaCongNhan>) em.createNativeQuery("SELECT * FROM BangDanhGiaCongNhan",
                    BangDanhGiaCongNhan.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(BangDanhGiaCongNhan bangDanhGia) throws RemoteException {
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
    public boolean update(BangDanhGiaCongNhan bangDanhGia) throws RemoteException {
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
    public boolean deleteById(String id) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.remove(em.find(BangDanhGiaCongNhan.class, id));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
        	em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BangDanhGiaCongNhan getBangDanhGiaCuaCongNhan(String maCN, int year) throws RemoteException {
        try {
            return (BangDanhGiaCongNhan) em.createNativeQuery("SELECT * FROM BangDanhGiaCongNhan WHERE maCN = ? AND nam = ?",
                    BangDanhGiaCongNhan.class).setParameter(1, maCN).setParameter(2, year).getResultList().get(0);
        } catch (Exception e) {
        	em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addOrUpdate(BangDanhGiaCongNhan bangDanhGiaCongNhan) throws RemoteException {
        try {
            if (get(bangDanhGiaCongNhan.getId()) == null) {
                em.getTransaction().begin();
                em.persist(bangDanhGiaCongNhan);
                em.getTransaction().commit();
            } else {
                em.getTransaction().begin();
                em.merge(bangDanhGiaCongNhan);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
