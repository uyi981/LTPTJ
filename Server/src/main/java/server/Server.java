package server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import DAO_Implement.*;
import DAO_Interface.*;
import javax.naming.Context;
import javax.naming.InitialContext;
public class Server {
	private static final String URL = "rmi://192.168.137.151:9981/";
	
	public static void main(String[] args) {
		try 
		{
			IDAOCongNhan daoCongNhan = new DAO_CongNhan();
			IDAOHopDong daoHopDong = new DAO_HopDong();
			IDAOKhachHang daoKhachHang = new DAO_KhachHang();
			IDAOSanPham daoSanPham = new DAO_SanPham();
			IDAONhanVien daoNhanVien = new DAO_NhanVien();
			IDAOBangDanhGiaCongNhan daoBangDanhGiaCongNhan = new DAO_BangDanhGiaCongNhan();
			IDAOPhieuLuongCongNhan daoPhieuLuongCongNhan = new DAO_PhieuLuongCongNhan();
			IDAOBangDanhGiaNhanVien ddaoBangDanhGiaNhanVien = new DAO_BangDanhGiaNhanVien();
			IDAOPhieuLuongNhanVien daoPhieuLuongNhanVien = new DAO_PhieuLuongNhanVien();
			IDAOBoPhan daoBoPhan = new DAO_BoPhan();
			IDAOChiTietPhanCong daoChiTietPhanCong = new DAO_ChiTietPhanCong();
			IDAOCongDoan daoCongDoan = new DAO_CongDoan();
			IDAOTaiKhoan daoTaiKhoan = new DAO_TaiKhoan();
			IDAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAO_PhieuChamCongCongNhan();
			IDAOPhieuChamCongNhanVien daoChamCongNhanVien = new DAO_PhieuChamCongNhanVien();
			
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
