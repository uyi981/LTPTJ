package DAO_Interface;

import ptud.Entity.ChiTietPhanCong;

import java.rmi.Remote;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IDAOChiTietPhanCong extends Remote {
    public ChiTietPhanCong get(String id) throws Exception;
    public ArrayList<ChiTietPhanCong> getAll() throws Exception;
    public ArrayList<ChiTietPhanCong> getAllByNgay(LocalDate ngay) throws Exception;
    public boolean insert(ChiTietPhanCong t) throws Exception;
    public boolean update(ChiTietPhanCong t) throws Exception;
    public boolean deleteById(String id) throws Exception;
    public void updateChoPhanCong(String maCN, boolean trangThai) throws Exception;
    public int getSoLuongCongDoanDuocGiaoHomNay(String maCD) throws Exception;
    public static int getSoLuongCongDoanGiaoByMaCongNHan(String maCN) throws Exception {
        return 0;
    }
    public void updateSoLuongGiaoHomNayByMaCN(String maCN, int soLuong) throws Exception;
    public void deleteHomNayByMaCN(String maCN) throws Exception;
    public static String getMaChiTietPhanCongBymaCN(String maCN) throws Exception {
        return null;
    }
    public static String getMaCongDoanBymaCTPC(String maCTPC) throws Exception {
        return null;
    }
    public int getSoLuongCongDoanHoanThanhByMaCongNhan(String maCN, LocalDate date) throws Exception;
}
