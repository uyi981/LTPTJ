package TestPhuc;

import java.rmi.RemoteException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import DAO_Implement.DAO_PhieuChamCongNhanVien;
import DAO_Interface.IDAOPhieuChamCongNhanVien;
import ptud.Entity.NhanVien;
import ptud.Entity.PhieuChamCongCongNhan;
import ptud.Entity.PhieuChamCongHanhChinh;

public class TestDAOPCCNV {
	private IDAOPhieuChamCongNhanVien daoPhieuChamCongNhanVien;

//	@Test
//	public  void testThemPhieuChamCongCongNhan() {
//		try {
//			System.out.println("2222");
//			daoPhieuChamCongNhanVien = new DAOPhieuChamCongNhanVien();
//			PhieuChamCongHanhChinh pcccn = new PhieuChamCongHanhChinh("P55655","HC01181001" ,LocalDate.of(2024, 4, 23), false, false, 11, 100,"thich thi phat");
//			daoPhieuChamCongNhanVien.themPhieuChamCongNhanVien(pcccn);
//			System.out.println("312313");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	@Test 
//	public void testGetSoNgayLam() {
//		try {
//			daoPhieuChamCongNhanVien= new DAOPhieuChamCongNhanVien();
//			System.out.println("dfsdf");
//			int soNgayLamViec = daoPhieuChamCongNhanVien.getSoNgayLam("HC01181001", 4, 2024);
//			System.out.println(soNgayLamViec);
//			System.out.println("12322");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test
	void testGetTongGioTangCaTrongThang() {
		try {
			daoPhieuChamCongNhanVien = new DAO_PhieuChamCongNhanVien();
			System.out.println("dfsdf");
			float soGioTangCa = daoPhieuChamCongNhanVien.getTongGioTangCaTrongThang("HC01181001", 4, 2024);
			System.out.println(soGioTangCa);
			System.out.println("12322");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
