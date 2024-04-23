package TestPhuc;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Implement.DAOBangDanhGiaNhanVien;
import DAO_Implement.DAOCongNhan;
import DAO_Implement.DAONhanVien;
import DAO_Implement.DAOPhieuChamCongCongNhan;
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
//			PhieuChamCongCongNhan pcccn = new PhieuChamCongCongNhan("edd", "CN1", LocalDate.of(2024, 04, 23), false, 100, "CTP", "Noi dung phat", 1000, 2000, 3000, 50);
//			daoPhieuChamCongCongNhan.themPhieuChamCongCongNhan(pcccn);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetTongTienPhatTrongThang() {
//		try {
//			daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			float tongTienPhat = daoPhieuChamCongCongNhan.getTongTienPhatTrongThang("SX01051001", 10, 2023);
//			System.out.println(tongTienPhat);
//			//báo lỗi vì giá trị của nhân viên là null
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
//			float tongTienKTC = daoPhieuChamCongCongNhan.getTongTienCongKhongTangCaTrongThang("SX01051001", 10, 2023);
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
//			int soNgayLamViec = daoPhieuChamCongCongNhan.getSoNgayLam("A", 10, 2023);
//			System.out.println(soNgayLamViec);
//			System.out.println("12322");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testGetDanhSachThongTinChamCongByIDBoPhan() {
//		try {
//			DAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
//			System.out.print("tétcc");
//		    Object[] aObjects = daoPhieuChamCongCongNhan.getThongTinChamCongByMaCongNhan("SX01051001");
//		    System.out.print("cc"+aObjects[0]);
//		} catch (Exception e) {
//			System.out.print("cc"+e);
//			// TODO: handle exception
//		}
//	}
	
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
