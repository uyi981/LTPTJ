package DAO_Implement;
import java.rmi.RemoteException;
import java.util.List;
import ptud.Entity.SanPham;
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
	public boolean themSanPham() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tuaSanPham() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean taoSanPham() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SanPham timKiemSanPham(String maSanPham) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPham> layDanhSachSanPham() throws RemoteException {
		// TODO Auto-generated method stub
		
	}





}
