package DAO_Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IDAOKhachHang extends Remote{
 public void ThemKhachHang() throws	RemoteException;
 public void SuaKhachHang() throws RemoteException;
 public void XoaKhachHang() throws RemoteException;
 public void TimKiemKhachHang() throws RemoteException;
 public void LayDanhSachKhachHang() throws RemoteException;
}
