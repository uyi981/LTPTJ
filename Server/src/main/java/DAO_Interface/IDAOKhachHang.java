package DAO_Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ptud.Entity.KhachHang;
// VoPhuocHau
public interface IDAOKhachHang extends Remote{
 public boolean themKhachHang(KhachHang khachHang) throws	RemoteException;
 public boolean SuaKhachHang(KhachHang khachHang) throws RemoteException;
 public boolean xoaKhachHang(String maKH) throws RemoteException;
 public KhachHang timKiemKhachHang(String maKH) throws RemoteException;
 public List<KhachHang> LayDanhSachKhachHang() throws RemoteException;
}
