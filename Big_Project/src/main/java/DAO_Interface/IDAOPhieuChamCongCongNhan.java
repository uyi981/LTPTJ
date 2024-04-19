package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
	

	

}
