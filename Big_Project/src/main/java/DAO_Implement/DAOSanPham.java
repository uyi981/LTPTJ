package DAO_Implement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import DAO_Interface.IDAOSanPham;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
public class DAOSanPham extends UnicastRemoteObject  implements IDAOSanPham 
{
    EntityManager em;
	public DAOSanPham() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3804424582259813759L;

	@Override
	public boolean ThemSanPham() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SuaSanPham() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean XoaSanPham() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean TimKiemSanPham() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void layDanhSachSanPham() {
		// TODO Auto-generated method stub
		
	}



}
