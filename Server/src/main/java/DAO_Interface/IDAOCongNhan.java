package DAO_Interface;

import java.rmi.Remote;
import java.util.List;
import java.rmi.RemoteException;
import ptud.Entity.CongNhan;

public interface IDAOCongNhan extends Remote{
	public boolean ThemCongNhan(CongNhan congNhan) throws RemoteException;
	public boolean XoaCongNhan(String maCongNhan) throws RemoteException;
	public void SuaCongNhan(String maCongNhan) throws RemoteException;
	public CongNhan TimKiemCongNhan(String maCongNhan) throws RemoteException;
	public List<CongNhan> layDanhSachCongNhan() throws RemoteException;
}
