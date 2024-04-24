package TestDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAO_ChiTietPhanCong;
import DAO_Interface.IDAOChiTietPhanCong;
import ptud.Entity.ChiTietPhanCong;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOChiTietPhanCong {
	private IDAOChiTietPhanCong daoChiTietPhanCong;
	
	@BeforeAll
	public void init() {
			try {
				daoChiTietPhanCong = new DAO_ChiTietPhanCong();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Test
	public void testGet() {
		try {
			ChiTietPhanCong result = daoChiTietPhanCong.get("B");
			System.out.println(result);
			assertNotNull(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAll() {
		try {
			List<ChiTietPhanCong> result = daoChiTietPhanCong.getAll();
			result.forEach(System.out::println);
			assertNotNull(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllByNgay() {
		try {
			// ngay=2023-10-30
			List<ChiTietPhanCong> result = daoChiTietPhanCong.getAllByNgay(LocalDate.of(2023, 10, 30));
			result.forEach(System.out::println);
			assertNotNull(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		try {
			ChiTietPhanCong ctpc = new ChiTietPhanCong("D", "05112023010102", "SX0322008", LocalDate.now(), 100);
			boolean result = daoChiTietPhanCong.insert(ctpc);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdate() {
		try {
			ChiTietPhanCong ctpc = daoChiTietPhanCong.get("D");
			ctpc.setSoLuongCDGiao(200);
			boolean result = daoChiTietPhanCong.update(ctpc);
			System.out.println(result);
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteById() {
		try {
			boolean result = daoChiTietPhanCong.deleteById("D");
			System.out.println(result);
			assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUpdateChoPhanCong() {
		try {
			daoChiTietPhanCong.updateChoPhanCong("SX0521015", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetSoLuongCongDoanDuocGiaoHomNay() {
		try {
			int result = daoChiTietPhanCong.getSoLuongCongDoanDuocGiaoHomNay("05112023010102");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetSoLuongCongDoanGiaoByMaCongNHan() {
		try {
			int result = daoChiTietPhanCong.getSoLuongCongDoanGiaoByMaCongNHan("SX0322008");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateSoLuongGiaoHomNayByMaCN() {
		try {
			daoChiTietPhanCong.updateSoLuongGiaoHomNayByMaCN("SX0322008", 120);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteHomNayByMaCN() {
		try {
			daoChiTietPhanCong.deleteHomNayByMaCN("SX0322008");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMaChiTietPhanCongBymaCN() {
		try {
			String result = daoChiTietPhanCong.getMaChiTietPhanCongBymaCN("SX0322008");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMaCongDoanBymaCTPC() {
		try {
			String result = daoChiTietPhanCong.getMaCongDoanBymaCTPC("D");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetSoLuongCongDoanHoanThanhByMaCongNhan() {
		try {
			int result = daoChiTietPhanCong.getSoLuongCongDoanHoanThanhByMaCongNhan("SX01051001", LocalDate.of(2023, 10, 30));
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public void afterAll() {
		daoChiTietPhanCong = null;
	}
}
