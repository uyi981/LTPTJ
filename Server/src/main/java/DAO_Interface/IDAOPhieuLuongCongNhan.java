package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ptud.Entity.PhieuLuongCongNhan;

public interface IDAOPhieuLuongCongNhan extends Remote{
	public PhieuLuongCongNhan get(String id) throws RemoteException;
	public ArrayList<PhieuLuongCongNhan> getAll() throws RemoteException;
	public boolean insert(PhieuLuongCongNhan t)	throws RemoteException;
	public boolean update(PhieuLuongCongNhan t)	throws RemoteException;
	public boolean deleteById(String id) throws RemoteException;
	public ArrayList<PhieuLuongCongNhan> getAllByThangNam(int thang, int nam) throws RemoteException;
	public ArrayList<PhieuLuongCongNhan> getAllByMaPBThangNam(String maBP, int thang, int nam) throws RemoteException;
}
