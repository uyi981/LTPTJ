package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import ptud.Entity.CongNhan;
public class DAOCongNhan extends UnicastRemoteObject implements DAO_Interface.IDAOCongNhan
{
	EntityManager em;
	public DAOCongNhan() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("MSSQL")
				.createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7286228071263536928L;

	@Override
	public boolean ThemCongNhan(CongNhan congNhan) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean XoaCongNhan(String maCongNhan) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void SuaCongNhan(String maCongNhan) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CongNhan TimKiemCongNhan(String maCongNhan) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CongNhan> layDanhSachCongNhan() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


  
}
