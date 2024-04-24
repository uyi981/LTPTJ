package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ptud.Entity.PhieuChamCongHanhChinh;

public interface IDAOPhieuChamCongNhanVien extends Remote{
	
	
	public boolean themPhieuChamCongNhanVien(PhieuChamCongHanhChinh PCCNV) throws RemoteException;

	public int getSoNgayLam(String idNV, int thang, int nam) throws RemoteException;

	public int getTongGioTangCaTrongThang(String idNV, int thang, int nam) throws RemoteException;

	public ArrayList<Object[]> getDanhSachThongTinChamCongByIDBoPhan(String maBoPhan) throws RemoteException;
	
    public Object[] gethongTinChamCongByMaNV(String maNV) throws RemoteException;
    
    public double getTongTienPhatTrongThang(String idNV, int thang, int nam) throws RemoteException;
    
    public String getCurrentDateYYYYMMDD() throws RemoteException;

    
    


	

}
