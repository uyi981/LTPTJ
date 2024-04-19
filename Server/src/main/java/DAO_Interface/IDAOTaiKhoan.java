package DAO_Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import DAO_Implement.DAOTaiKhoan;
import ptud.Entity.TaiKhoan;

public interface IDAOTaiKhoan extends Remote{
	public DAOTaiKhoan getInstance() throws RemoteException;
	public String hashPassword(String password, int length) throws RemoteException;
	public int getUserRole(String username, String password) throws RemoteException;
	public String getTenNhanVienTaiKhoanByIDNV(String maNV) throws RemoteException;
    public int getUserRoleByUserName(String username) throws RemoteException;
    public ArrayList<TaiKhoan> getAll() throws RemoteException;
    public boolean updateTaiKhoan(TaiKhoan tk) throws RemoteException;
    public boolean createTaiKhoan(TaiKhoan tk) throws RemoteException;
    public boolean deleteTaiKhoanByID(String ID) throws RemoteException;
    
    
    

}
