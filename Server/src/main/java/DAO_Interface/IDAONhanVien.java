package DAO_Interface;

import java.util.List;
import java.rmi.Remote;
import ptud.Entity.NhanVien;
import java.rmi.RemoteException;
public interface IDAONhanVien extends Remote {
public boolean themNhanVien(NhanVien nhanVien) throws RemoteException;
public boolean suaNhanVien(NhanVien nhanVien)throws RemoteException;
public boolean xoaNhanVien(String maNV)throws RemoteException;
public NhanVien timKiemNhanVien(String maNV)throws RemoteException;
public List<NhanVien> layDanhSachNhanVien()throws RemoteException;

}
