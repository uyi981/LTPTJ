package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ptud.Entity.ChamCongDTO;
import ptud.Entity.PhieuChamCongCongNhan;

public interface IDAOPhieuChamCongCongNhan extends Remote{
	public boolean themPhieuChamCongCongNhan(PhieuChamCongCongNhan PCCCN) throws RemoteException;
	public int getSoNgayLam (String idCN, int thang, int nam) throws RemoteException;
	public float getTongTienPhatTrongThang (String idCN, int thang, int nam) throws RemoteException;
	public float getTongTienThuongTrongThang (String idCN, int thang, int nam) throws RemoteException;
    public float getTongTienCongKhongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException ;
    public float getTongTienCongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException ;
    public float getTongTienCongTrongThang(String idCN, int thang, int nam) throws RemoteException;
    public float getTienLuongTrongThang(String idCN, int thang, int nam) throws RemoteException;
    public String getCurrentDateYYYYMMDD() throws RemoteException;
    public ArrayList<Object[]> getDanhSachThongTinChamCongByIDBoPhan(String maBoPhan) throws RemoteException;
    public Object[] getThongTinChamCongByMaCongNhan(String maCN) throws RemoteException;
    public ArrayList<ChamCongDTO> getDsCongDoanLamDuocCuaCongNhanTrongThang( String maCN, int thang, int nam ) throws RemoteException;

}
