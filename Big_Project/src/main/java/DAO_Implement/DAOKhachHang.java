package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import jakarta.persistence.Persistence;

public class DAOKhachHang extends UnicastRemoteObject implements DAO_Interface.IDAOKhachHang{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2441975338527262012L;

	private jakarta.persistence.EntityManager em;	 
	public DAOKhachHang() throws RemoteException {
		
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ThemKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SuaKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void XoaKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void TimKiemKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LayDanhSachKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
