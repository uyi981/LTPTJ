package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import DAO_Implement.*;
import DAO_Interface.*;
import javax.naming.Context;
import javax.naming.InitialContext;
public class Server {
	private static final String URL = "rmi://192.168.1.75:9981/";
	
	public static void main(String[] args) {
		try 
		{
//			IDAOCongNhan daoCongNhan = new DAOCongNhan();
			IDAOHopDong daoHopDong = new DAOHopDong();
//			IDAOKhachHang daoKhachHang = new DAOKhachHang();
//			IDAOSanPham daoSanPham = new DAOSanPham();
//			IDAONhanVien daoNhanVien = new DAONhanVien();			
			javax.naming.Context context = new InitialContext();
			LocateRegistry.createRegistry(9981);
//			context.bind(URL + "DAOCongNhan", daoCongNhan);
			context.bind(URL + "DAOHopDong", daoHopDong);
//			context.bind(URL + "DAOKhachHang", daoKhachHang);
//			context.bind(URL + "DAOSanPham", daoSanPham);
			//int a = 69;
			//context.bind(URL+"concac", a);
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
