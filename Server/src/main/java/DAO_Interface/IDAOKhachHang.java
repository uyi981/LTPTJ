package DAO_Interface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import ptud.Entity.KhachHang;
// VoPhuocHau
public interface IDAOKhachHang extends Remote{
 public void themKhachHang(KhachHang khachHang) throws	RemoteException;
 public void SuaKhachHang(KhachHang khachHang) throws RemoteException;
 public void xoaKhachHang(String maKH) throws RemoteException;
 public KhachHang timKiemKhachHang(String maKH) throws RemoteException;
 public List<KhachHang> LayDanhSachKhachHang() throws RemoteException;
}
