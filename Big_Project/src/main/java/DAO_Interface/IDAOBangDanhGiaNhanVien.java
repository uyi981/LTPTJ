package DAO_Interface;

import ptud.Entity.BangDanhGiaNhanVien;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDAOBangDanhGiaNhanVien extends Remote {
    public BangDanhGiaNhanVien get(String id) throws RemoteException;

    public ArrayList<BangDanhGiaNhanVien> getAll() throws RemoteException;
    public boolean insert(BangDanhGiaNhanVien bangDanhGia) throws RemoteException;
    public boolean update(BangDanhGiaNhanVien bangDanhGia) throws RemoteException;
    public boolean deleteById(String maBDG) throws RemoteException;
    public BangDanhGiaNhanVien getBangDanhGiaCuaNhanVien(String maNV, int year) throws RemoteException;
    public void addOrUpdate(BangDanhGiaNhanVien bangDanhGiaNhanVien) throws RemoteException;
}
