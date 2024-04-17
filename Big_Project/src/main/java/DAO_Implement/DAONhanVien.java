package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
public class DAONhanVien extends UnicastRemoteObject implements DAO_Interface.IDAONhanVien
{
  EntityManager em;
	public DAONhanVien() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272268639921122950L;

	@Override
	public void themNhanVien() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suaNhanVien() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoaNhanVien() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timKiemNhanVien() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void layDanhSachNhanVien() {
		// TODO Auto-generated method stub
		
	}

	
}
