package DAO_Interface;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import ptud.Entity.CongNhan;

public interface IDAOCongNhan extends Remote{
	public boolean themCongNhan(CongNhan congNhan) throws RemoteException;
	public boolean xoaCongNhan(String maCongNhan) throws RemoteException;
	public void suaCongNhan(CongNhan congNhan) throws RemoteException;
	public CongNhan timKiemCongNhan(String maCongNhan) throws RemoteException;
	public List<CongNhan> layDanhSachCongNhan() throws RemoteException;
	public ArrayList<CongNhan> search(String searchText, String searchCriteria) throws RemoteException ;
	public int countAll() throws RemoteException ;
}
