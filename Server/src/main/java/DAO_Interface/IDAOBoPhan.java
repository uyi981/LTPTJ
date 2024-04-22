package DAO_Interface;

import ptud.Entity.BoPhan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDAOBoPhan extends Remote {
    public BoPhan get(String id) throws RemoteException;
    public ArrayList<BoPhan> getAll() throws RemoteException;
    public boolean insert(BoPhan boPhan) throws RemoteException;
    public boolean update(BoPhan boPhan) throws RemoteException;
    public boolean deleteById(String id) throws RemoteException;
    // Tim tuyet doi
    public String getMaBoPhanByTenBoPhan(String tenBoPhan) throws RemoteException;
    public ArrayList<BoPhan> filter(String prefix) throws RemoteException;
}
