package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import DAO_Implement.*;
import DAO_Interface.*;
import javax.naming.Context;
import javax.naming.InitialContext;
public class Server {
	private static final String URL = "rmi://192.168.1.105:9981/";
	
	public static void main(String[] args) {
		try 
		{
			IDAOCongNhan daoCongNhan = new DAOCongNhan();
			IDAOHopDong daoHopDong = new DAOHopDong();
			IDAOKhachHang daoKhachHang = new DAOKhachHang();
			IDAOSanPham daoSanPham = new DAOSanPham();
			IDAONhanVien daoNhanVien = new DAONhanVien();
			IDAOBangDanhGiaCongNhan daoBangDanhGiaCongNhan = new DAOBangDanhGiaCongNhan();
			IDAOPhieuLuongCongNhan daoPhieuLuongCongNhan = new DAOPhieuLuongCongNhan();
			IDAOBangDanhGiaNhanVien ddaoBangDanhGiaNhanVien = new DAOBangDanhGiaNhanVien();
			IDAOPhieuLuongNhanVien daoPhieuLuongNhanVien = new DAOPhieuLuongNhanVien();
			IDAOBoPhan daoBoPhan = new DAOBoPhan();
			IDAOChiTietPhanCong daoChiTietPhanCong = new DAOChiTietPhanCong();
			IDAOCongDoan daoCongDoan = new DAOCongDoan();
			IDAOTaiKhoan daoTaiKhoan = new DAOTaiKhoan();
			IDAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
			IDAOPhieuChamCongNhanVien daoChamCongNhanVien = new DAOPhieuChamCongNhanVien();
			
			javax.naming.Context context = new InitialContext();
			LocateRegistry.createRegistry(9981);
			context.bind(URL + "DAOCongNhan", daoCongNhan);
			context.bind(URL + "DAOHopDong", daoHopDong);
			context.bind(URL + "DAOKhachHang", daoKhachHang);
			context.bind(URL + "DAOSanPham", daoSanPham);
			context.bind(URL + "DAONhanVien", daoNhanVien);
			context.bind(URL + "DAOBangDanhGiaCongNhan", daoBangDanhGiaCongNhan);
			context.bind(URL + "DAOPhieuLuongCongNhan", daoPhieuLuongCongNhan);
			context.bind(URL + "DAOBangDanhGiaNhanVien", ddaoBangDanhGiaNhanVien);
			context.bind(URL + "DAOPhieuLuongNhanVien", daoPhieuLuongNhanVien);
			context.bind(URL + "DAOBoPhan", daoBoPhan);
			context.bind(URL + "DAOChiTietPhanCong", daoChiTietPhanCong);
			context.bind(URL + "DAOCongDoan", daoCongDoan);
			context.bind(URL + "DAOTaiKhoan", daoTaiKhoan);
			context.bind(URL + "DAOPhieuChamCongCongNhan", daoPhieuChamCongCongNhan);
			context.bind(URL + "DAOPhieuChamCongNhanVien", daoChamCongNhanVien);
			
			//int a = 69;
			//context.bind(URL+"concac", a);
			
			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
