package DAO_Interface;
import java.rmi.RemoteException;
import java.util.List;

import ptud.Entity.HopDong;
import java.rmi.Remote;
public interface IDAOHopDong extends Remote
{
 public boolean themHopDong(HopDong hopDong) throws RemoteException;
 public boolean suaHopDong(HopDong hopDong) throws RemoteException;
 public boolean xoaHopDong(String maHD) throws RemoteException;
 public HopDong timKiemHopDong(String maHD) throws RemoteException;
 public List<HopDong> layDanhSachHopDong() throws RemoteException;
}
