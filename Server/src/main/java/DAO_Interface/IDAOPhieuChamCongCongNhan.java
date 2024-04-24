package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ptud.Entity.ChamCongDTO;
import ptud.Entity.PhieuChamCongCongNhan;

public interface IDAOPhieuChamCongCongNhan extends Remote{
	public boolean themPhieuChamCongCongNhan(PhieuChamCongCongNhan PCCCN) throws RemoteException;
	public int getSoNgayLam (String idCN, int thang, int nam) throws RemoteException;
	public double getTongTienPhatTrongThang (String idCN, int thang, int nam) throws RemoteException;
	public double getTongTienThuongTrongThang (String idCN, int thang, int nam) throws RemoteException;
    public double getTongTienCongKhongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException ;
    public double getTongTienCongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException ;
    public double getTongTienCongTrongThang(String idCN, int thang, int nam) throws RemoteException;
    public double getTienLuongTrongThang(String idCN, int thang, int nam) throws RemoteException;
    public String getCurrentDateYYYYMMDD() throws RemoteException;
    public ArrayList<Object[]> getDanhSachThongTinChamCongByIDBoPhan(String maBoPhan) throws RemoteException;
    public Object[] getThongTinChamCongByMaCongNhan(String maCN) throws RemoteException;
    public ArrayList<ChamCongDTO> getDsCongDoanLamDuocCuaCongNhanTrongThang( String maCN, int thang, int nam ) throws RemoteException;

}
