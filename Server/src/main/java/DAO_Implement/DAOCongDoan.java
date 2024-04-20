package DAO_Implement;

import DAO_Interface.IDAOCongDoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import ptud.Entity.CongDoan;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DAOCongDoan extends UnicastRemoteObject implements IDAOCongDoan {

    private EntityManager em;
    
    public DAOCongDoan() throws Exception {
        em = Persistence.createEntityManagerFactory("MSSQL")
                .createEntityManager();
    }

    @Override
    public CongDoan get(String id) throws Exception {
        return em.find(CongDoan.class, id);
    }

    @Override
    public ArrayList<CongDoan> getAll() throws Exception {
        // Use Native Query
        return (ArrayList<CongDoan>) em.createNativeQuery(
                "SELECT * FROM CongDoan", CongDoan.class).getResultList();
    }

    @Override
    public ArrayList<CongDoan> getAllByMaSP(String maSP) throws Exception {
        // Use Native Query "SELECT * FROM CongDoan WHERE maSP = ?"
        ArrayList<CongDoan> resultList = (ArrayList<CongDoan>) em.createNativeQuery(
                        "SELECT * FROM CongDoan WHERE maSP = ?", CongDoan.class)
                .setParameter(1, maSP).getResultList();
        return resultList;
    }

    @Override
    public ArrayList<CongDoan> getAllByMaBP(String maBP) throws Exception {
        // Use Native Query
        ArrayList<CongDoan> resultList = (ArrayList<CongDoan>) em.createNativeQuery(
                        "SELECT * FROM CongDoan WHERE maBP = ?", CongDoan.class)
                .setParameter(1, maBP).getResultList();
        return resultList;
    }

    @Override
    public ArrayList<CongDoan> getAllByTrangThai(boolean trangThai) throws Exception {
        // Use Native Query
        ArrayList<CongDoan> resultList = (ArrayList<CongDoan>) em.createNativeQuery(
                        "SELECT * FROM CongDoan WHERE trangThai = ?", CongDoan.class)
                .setParameter(1, trangThai).getResultList();
        return resultList;
    }

    @Override
    public boolean insert(CongDoan t) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(CongDoan t) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean deleteById(String id) throws Exception {
        try {
            em.getTransaction().begin();
            CongDoan t = em.find(CongDoan.class, id);
            em.remove(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public String getLastMaCD(String maSP) throws Exception {
        // "SELECT TOP 1 maCD FROM CongDoan WHERE maSP = ? ORDER BY maCD DESC"
        String result = (String) em.createNativeQuery(
                        "SELECT TOP 1 maCD FROM CongDoan WHERE maSP = ? ORDER BY maCD DESC")
                .setParameter(1, maSP).getSingleResult();
        return result;
    }

    @Override
    public ArrayList<String> getDsCDHQ(String maCDTQ) throws Exception {
        // "SELECT maCD FROM CongDoanTienQuyet WHERE maCDTQ = ?"
        ArrayList<String> resultList = (ArrayList<String>) em.createNativeQuery(
                        "SELECT maCD FROM CongDoanTienQuyet WHERE maCDTQ = ?")
                .setParameter(1, maCDTQ).getResultList();
        return resultList;
    }

    @Override
    public int getSoLuongHoanThanh(String maCD) throws Exception {
//        String query = "SELECT SUM(soLuongCD + soLuongCDTangCa) AS soLuongHoanThanh " +
//                "FROM ChiTietPhanCong " +
//                "JOIN PhieuChamCongCongNhan ON ChiTietPhanCong.maCTPC = PhieuChamCongCongNhan.maCTPC " +
//                "WHERE maCD = ?";
        int result = (int) em.createNativeQuery(
                        "SELECT SUM(soLuongCD + soLuongCDTangCa) AS soLuongHoanThanh " +
                                "FROM ChiTietPhanCong " +
                                "JOIN PhieuChamCongCongNhan ON ChiTietPhanCong.maCTPC = PhieuChamCongCongNhan.maCTPC " +
                                "WHERE maCD = ?")
                .setParameter(1, maCD).getSingleResult();
        return result;
    }

    @Override
    public ArrayList<CongDoan> getDsCDTQ(String maCD) throws Exception {
        // "SELECT maCDTQ FROM CongDoanTienQuyet WHERE maCD = ?";
        ArrayList<CongDoan> resultList = (ArrayList<CongDoan>) em.createNativeQuery(
                        "SELECT maCDTQ FROM CongDoanTienQuyet WHERE maCD = ?", CongDoan.class)
                .setParameter(1, maCD).getResultList();
        return resultList;
    }

    @Override
    public int getSoLuongChuanBi(String maCD) throws Exception {
        // "SELECT soLuongChuanBi FROM CongDoan WHERE maCD = ?";
        int result = (int) em.createNativeQuery(
                        "SELECT soLuongChuanBi FROM CongDoan WHERE maCD = ?")
                .setParameter(1, maCD).getSingleResult();
        return result;
    }

    @Override
    public void updateSoLuong(String maCD, int delta, boolean giam) throws Exception {
        // "UPDATE CongDoan SET soLuongCD = soLuongCD + ? WHERE maCD = ?";
        try {
            em.getTransaction().begin();
            em.createNativeQuery(
                            "UPDATE CongDoan SET soLuongCD = soLuongCD + ? WHERE maCD = ?")
                    .setParameter(1, delta)
                    .setParameter(2, maCD)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}
