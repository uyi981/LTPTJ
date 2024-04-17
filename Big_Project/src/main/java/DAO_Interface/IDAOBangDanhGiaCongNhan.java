package DAO_Interface;

import ptud.Entity.BangDanhGiaCongNhan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDAOBangDanhGiaCongNhan extends Remote {
    public BangDanhGiaCongNhan get(String id) throws RemoteException;
    public ArrayList<BangDanhGiaCongNhan> getAll() throws RemoteException;
    public boolean insert(BangDanhGiaCongNhan bangDanhGia) throws RemoteException;
    public boolean update(BangDanhGiaCongNhan bangDanhGia) throws RemoteException;
    public boolean deleteById(String id) throws RemoteException;
    public BangDanhGiaCongNhan getBangDanhGiaCuaCongNhan(String maCN, int year) throws RemoteException;
    public void addOrUpdate(BangDanhGiaCongNhan bangDanhGiaCongNhan) throws RemoteException;

}
