package DAO_Interface;
import java.rmi.RemoteException;
import java.util.List;

import ptud.Entity.SanPham;

import java.rmi.Remote;
public interface IDAOSanPham extends Remote{
 public boolean themSanPham(SanPham sanPham) throws  RemoteException ;
 public boolean suaSanPham(SanPham sanPham) throws  RemoteException;
 public boolean xoaSanPham(String maSanPham) throws  RemoteException;
 public SanPham timKiemSanPham(String maSanPham) throws  RemoteException;
 public void layDanhSachSanPham() throws  RemoteException;
}
