package TestPhuc;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Implement.DAO_BangDanhGiaNhanVien;
import DAO_Implement.DAO_CongNhan;
import DAO_Implement.DAO_NhanVien;
import DAO_Implement.DAO_PhieuChamCongCongNhan;
import DAO_Interface.IDAOCongNhan;
import DAO_Interface.IDAOPhieuChamCongCongNhan;
import ptud.Entity.ChamCongDTO;
import ptud.Entity.PhieuChamCongCongNhan;

public class TestDAOPCCCN {
	private IDAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan;
	private IDAOCongNhan daoCongNhan;
	
//	@Test
//	public  void testThemPhieuChamCongCongNhan() {
//		try {
//			System.out.println("2222");
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//		    public PhieuChamCongCongNhan(String maPCCCN, LocalDate ngay, boolean vang, int soLuongSanPham, String maCTPC, String noiDungPhat, double tienCong, double tienThuong, double tienPhat, int soLuongSanPhamTangCa)
//			PhieuChamCongCongNhan pcccn = new PhieuChamCongCongNhan("BB55", LocalDate.of(2024,4, 23), false, 11, "A", "thich", 100, 22, 12, 0);
//			daoPhieuChamCongCongNhan.themPhieuChamCongCongNhan(pcccn);
//			System.out.println("da pass");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetTongTienPhatTrongThang() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			float tongTienPhat = daoPhieuChamCongCongNhan.getTongTienPhatTrongThang("SX01051001", 4, 2024);
//			System.out.println(tongTienPhat);
//			System.out.println("123");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void testGetTongTienThuongTrongThang() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			float tongTienThuong = daoPhieuChamCongCongNhan.getTongTienThuongTrongThang("SX01051001", 10, 2023);
//			System.out.println(tongTienPhat);
//			//báo lỗi vì giá trị của nhân viên là null
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testGetTongTienCongKhongTangCaTrongThang() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			float tongTienKTC = daoPhieuChamCongCongNhan.getTongTienCongKhongTangCaTrongThang("SX01051001", 4, 2024);
//			System.out.println(tongTienKTC);
//			System.out.println("123");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
//	@Test
//	public void testGetTongTienCongTangCaTrongThang() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			float tongTienTC = daoPhieuChamCongCongNhan.getTongTienCongTangCaTrongThang("SX01051001", 10, 2023);
//			System.out.println(tongTienTC);
//			System.out.println("12322");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void testGetSoNgayLam() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			int soNgayLamViec = daoPhieuChamCongCongNhan.getSoNgayLam("SX01051001", 4, 2024);
//			System.out.println(soNgayLamViec);
//			System.out.println("pass");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testGetDanhSachThongTinChamCongByIDBoPhan() {
	    try {
	        DAO_PhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAO_PhieuChamCongCongNhan();
	        System.out.print("tétcc");
	        ArrayList<Object[]> aObjects = daoPhieuChamCongCongNhan.getDanhSachThongTinChamCongByIDBoPhan("SX01");
	        
	        // Lặp qua từng phần tử trong mảng và hiển thị giá trị của từng phần tử
	        for (Object[] row : aObjects) {
	            System.out.println(Arrays.toString(row));
	        }
	    } catch (Exception e) {
	        System.out.print("cc"+e);
	        // TODO: handle exception
	    }
	}
	
//	@Test 
//	public void testGetDsCongDoanLamDuocCuaCongNhanTrongThang()
//	{
//		try {
//			DAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			System.out.println("123123");
//			ArrayList<ChamCongDTO> al = daoPhieuChamCongCongNhan.getDsCongDoanLamDuocCuaCongNhanTrongThang("SX01051001", 04, 2024);
//			System.out.print("cc"+ al);
//
//		} catch (RemoteException e) {
//			System.out.println("qaaaa");
//			e.printStackTrace();
//		}
//	}
}
