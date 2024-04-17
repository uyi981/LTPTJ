package DAO_Implement;

import DAO_Interface.IDAOChiTietPhanCong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import ptud.Entity.ChiTietPhanCong;

import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DAOChiTietPhanCong extends UnicastRemoteObject implements IDAOChiTietPhanCong {

    private EntityManager em;

    public DAOChiTietPhanCong() throws Exception {
        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
    }

    @Override
    public ChiTietPhanCong get(String id) throws Exception {
        return em.find(ChiTietPhanCong.class, id);
    }

    @Override
    public ArrayList<ChiTietPhanCong> getAll() throws Exception {
        // Use NativeQuery
        ArrayList<ChiTietPhanCong> resultList = (ArrayList<ChiTietPhanCong>) em.createNativeQuery("SELECT * FROM ChiTietPhanCong",
                ChiTietPhanCong.class).getResultList();
        return resultList;
    }

    @Override
    public ArrayList<ChiTietPhanCong> getAllByNgay(LocalDate ngay) throws Exception {
        // Use NativeQuery
        ArrayList<ChiTietPhanCong> resultList = (ArrayList<ChiTietPhanCong>) em.createNativeQuery(
                "SELECT * FROM ChiTietPhanCong WHERE Ngay = ?ngay",
                ChiTietPhanCong.class).setParameter("ngay", ngay).getResultList();
        return resultList;
    }

    @Override
    public boolean insert(ChiTietPhanCong t) throws Exception {
        // insert new ChiTietPhanCong
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
    public boolean update(ChiTietPhanCong t) throws Exception {
        // update ChiTietPhanCong
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
    public boolean deleteById(String id) throws Exception {
        // delete ChiTietPhanCong by id
        try {
            ChiTietPhanCong t = get(id);
            if (t != null) {
                em.getTransaction().begin();
                em.remove(t);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateChoPhanCong(String maCN, boolean trangThai) throws Exception {
        // "UPDATE CongNhan SET choPhanCong = ? WHERE maCN = ?"
        try {
            em.getTransaction().begin();
            em.createNativeQuery("UPDATE CongNhan SET choPhanCong = ? WHERE maCN = ?")
                    .setParameter(1, trangThai)
                    .setParameter(2, maCN)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSoLuongCongDoanDuocGiaoHomNay(String maCD) throws Exception {
        // "SELECT SUM(soLuongCDGiao) FROM ChiTietPhanCong WHERE maCD = ? AND ngay = ?"
        try {
            return (int) em.createNativeQuery("SELECT SUM(soLuongCDGiao) FROM ChiTietPhanCong " +
                            "WHERE maCD = ? AND ngay = ?")
                    .setParameter(1, maCD)
                    .setParameter(2, LocalDate.now())
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void updateSoLuongGiaoHomNayByMaCN(String maCN, int soLuong) throws Exception {
//        String chuoiNgayHomNay = ngayHomNay.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
//        String query = "select soLuongCDGiao\n"
//                + "from ChiTietPhanCong\n"
//                + "where maCN = ? and maCTPC = ?";
        try {
            em.getTransaction().begin();
            em.createNativeQuery("UPDATE ChiTietPhanCong SET soLuongCDGiao = ? WHERE maCN = ? AND ngay = ?")
                    .setParameter(1, soLuong)
                    .setParameter(2, maCN)
                    .setParameter(3, LocalDate.now())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHomNayByMaCN(String maCN) throws Exception {
        // "DELETE FROM ChiTietPhanCong WHERE maCN = ? AND ngay = ?"
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE FROM ChiTietPhanCong WHERE maCN = ? AND ngay = ?")
                    .setParameter(1, maCN)
                    .setParameter(2, LocalDate.now())
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSoLuongCongDoanHoanThanhByMaCongNhan(String maCN, LocalDate date) throws Exception {
//        String fotmatNgay = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String query = "select sum(p.soLuongCD + p.soLuongCDTangCa) as soLuong\n" +
//                "from [dbo].[PhieuChamCongCongNhan] p\n" +
//                "join [dbo].[ChiTietPhanCong] c on p.maCTPC = c.maCTPC\n" +
//                "where c.maCN = ? and p.ngayChamCong = ?";
        try {
            return (int) em.createNativeQuery("SELECT SUM(p.soLuongCD + p.soLuongCDTangCa) as soLuong\n" +
                            "FROM PhieuChamCongCongNhan p\n" +
                            "JOIN ChiTietPhanCong c ON p.maCTPC = c.maCTPC\n" +
                            "WHERE c.maCN = ? AND p.ngayChamCong = ?")
                    .setParameter(1, maCN)
                    .setParameter(2, date)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
