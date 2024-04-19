package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ptud.Entity.PhieuLuongNhanVien;

public interface IDAOPhieuLuongNhanVien extends Remote{
	public PhieuLuongNhanVien get(String id) throws RemoteException;
	public ArrayList<PhieuLuongNhanVien> getAll() throws RemoteException;
	public boolean insert(PhieuLuongNhanVien t) throws RemoteException;
	public boolean update(PhieuLuongNhanVien t) throws RemoteException;
	public boolean deleteById(String id) throws RemoteException;
    public ArrayList<PhieuLuongNhanVien> getAllByMaPBThangNam(String maBP, int thang, int nam) throws RemoteException;
    public ArrayList<PhieuLuongNhanVien> getAllByThangNam(int thang, int nam) throws RemoteException;

    

}
