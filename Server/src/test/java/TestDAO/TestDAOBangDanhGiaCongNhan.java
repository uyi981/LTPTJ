package TestDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAO_BangDanhGiaCongNhan;
import DAO_Implement.DAO_CongNhan;
import DAO_Interface.IDAOBangDanhGiaCongNhan;
import DAO_Interface.IDAOCongNhan;
import ptud.Entity.BangDanhGiaCongNhan;
import ptud.Entity.CongNhan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOBangDanhGiaCongNhan {
	
	private IDAOBangDanhGiaCongNhan daoBangDanhGiaCongNhan;
	private IDAOCongNhan daoCongNhan;
	
	@BeforeAll
	public void init() {
		try {
			daoBangDanhGiaCongNhan = new DAO_BangDanhGiaCongNhan();
			daoCongNhan = new DAO_CongNhan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		try {
			BangDanhGiaCongNhan bangDanhGia = daoBangDanhGiaCongNhan.get("BDG003");
			System.out.println(bangDanhGia);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAll() {
		try {
			List<BangDanhGiaCongNhan> list = daoBangDanhGiaCongNhan.getAll();
			System.out.println(list);
			assertNotNull(list);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		try {
			CongNhan congNhan = daoCongNhan.timKiemCongNhan("SX0415014");
			BangDanhGiaCongNhan bangDanhGia = new BangDanhGiaCongNhan("BDG032", congNhan, 2020, 10, 10, 10, 10, 'C');
			boolean result = daoBangDanhGiaCongNhan.insert(bangDanhGia);
			System.out.println(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			BangDanhGiaCongNhan bangDanhGia = daoBangDanhGiaCongNhan.get("BDG032");
			bangDanhGia.setDiemChuyenCan(10);
			bangDanhGia.setThanhVien(daoCongNhan.timKiemCongNhan("SX0415014"));
			boolean result = daoBangDanhGiaCongNhan.update(bangDanhGia);
			System.out.println(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteById() {
		try {
			boolean result = daoBangDanhGiaCongNhan.deleteById("BDG012");
			System.out.println(result);
			assertTrue(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetBangDanhGiaCuaCongNhan() {
		try {
			BangDanhGiaCongNhan bangDanhGia = daoBangDanhGiaCongNhan.getBangDanhGiaCuaCongNhan("SX0415014", 2020);
			System.out.println(bangDanhGia);
			assertNotNull(bangDanhGia);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testAddOrUpdate() {
		try {
			CongNhan congNhan = daoCongNhan.timKiemCongNhan("SX04150142");
			BangDanhGiaCongNhan bangDanhGia = new BangDanhGiaCongNhan("BDG033", congNhan, 2020, 10, 4, 10, 10, 'C');
			System.out.println(bangDanhGia);
			daoBangDanhGiaCongNhan.addOrUpdate(bangDanhGia);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public void afterAll() {
		daoBangDanhGiaCongNhan = null;
		daoCongNhan = null;
	}
}
