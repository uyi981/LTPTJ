package DAO_Interface;

import ptud.Entity.CongDoan;

import java.rmi.Remote;
import java.util.ArrayList;

public interface IDAOCongDoan extends Remote {
    public CongDoan get(String id) throws Exception;
    public ArrayList<CongDoan> getAll() throws Exception;
    public ArrayList<CongDoan> getAllByMaSP(String maSP) throws Exception;
    public ArrayList<CongDoan> getAllByMaBP(String maBP) throws Exception;
    public ArrayList<CongDoan> getAllByTrangThai(boolean trangThai) throws Exception;
    public boolean insert(CongDoan t) throws Exception;
    public boolean update(CongDoan t) throws Exception;
    public boolean deleteById(String id) throws Exception;
    public String getLastMaCD(String maSP) throws Exception;
    public ArrayList<String> getDsCDHQ(String maCDTQ) throws Exception;
    public int getSoLuongHoanThanh(String maCD) throws Exception;
    public ArrayList<CongDoan> getDsCDTQ(String maCD) throws Exception;
    public int getSoLuongChuanBi(String maCD) throws Exception;
    public void updateSoLuong( String maCD, int delta, boolean giam ) throws Exception;
    
    
}
