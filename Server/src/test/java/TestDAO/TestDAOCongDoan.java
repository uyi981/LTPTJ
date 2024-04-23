package TestDAO;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import DAO_Implement.DAOCongDoan;
import DAO_Interface.IDAOCongDoan;
import ptud.Entity.CongDoan;

@TestInstance(Lifecycle.PER_CLASS)
public class TestDAOCongDoan {
	
	private IDAOCongDoan daoCongDoan;
	
	@BeforeAll
	public void init() {
		try {
			daoCongDoan = new DAOCongDoan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//    public void updateSoLuong( String maCD, int delta, boolean giam ) throws Exception;
	
//	@Test
//	public void testGet() {
//		try {
//			CongDoan cd = daoCongDoan.get("05112023010302");
//			System.out.println(cd);
//			assertNotNull(cd);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetAll() {
//		try {
//			List<CongDoan> list = daoCongDoan.getAll();
//			list.forEach(System.out::println);
//			assertNotNull(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testGetAllByMaSP() {
//		try {
//			List<CongDoan> list = daoCongDoan.getAllByMaSP("051120230102");
//			list.forEach(System.out::println);
//			assertNotNull(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetAllByMaBP() {
//		try {
//			List<CongDoan> list = daoCongDoan.getAllByMaBP("SX01");
//			list.forEach(System.out::println);
//			assertNotNull(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetAllByTrangThai() {
//		try {
//			List<CongDoan> list = daoCongDoan.getAllByTrangThai(false);
//			list.forEach(System.out::println);
//			assertNotNull(list);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testInsert() {
//		try {
//			CongDoan cd = new CongDoan("051120230103044", "051120230103", "SX01", "CD1", 1000, false, 10, null);
//			boolean result = daoCongDoan.insert(cd);
//			System.out.println(result);
//			assertNotNull(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testUpdate() {
//		try {
//			CongDoan cd = new CongDoan("051120230103044", "051120230103", "SX01", "CD1", 1000, false, 10, null);
//			boolean result = daoCongDoan.update(cd);
//			System.out.println(result);
//			assertNotNull(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testDeleteById() {
//		try {
//			boolean result = daoCongDoan.deleteById("05112023020103");
//			System.out.println(result);
//			assertNotNull(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetLastMaCD() {
//        try {
//            String result = daoCongDoan.getLastMaCD("051120230103");
//            System.out.println(result);
//            assertNotNull(result);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//	
//	@Test
//	public void testGetDsCDHQ() {
//        try {
//            List<String> result = daoCongDoan.getDsCDHQ("05112023010301");
//            result.forEach(System.out::println);
//            assertNotNull(result);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            }
//        }
	
//	@Test
//	public void testGetSoLuongHoanThanh() {
//        try {
//            int result = daoCongDoan.getSoLuongHoanThanh("05112023010102");
//            System.out.println(result);
//            assertNotNull(result);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            }
//        }
//	
//	@Test
//	public void testGetDsCDTQ() {
//		try {
//			List<String> result = daoCongDoan.getDsCDTQ("05112023010202");
//			result.forEach(System.out::println);
//			assertNotNull(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testGetSoLuongChuanBi() {
//		try {
//			int result = daoCongDoan.getSoLuongChuanBi("05112023010201");
//			System.out.println(result);
//			assertNotNull(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testUpdateSoLuong() {
		try {
			daoCongDoan.updateSoLuong("05112023010101", 10, false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterAll
	public void close() {
		try {
			daoCongDoan = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
