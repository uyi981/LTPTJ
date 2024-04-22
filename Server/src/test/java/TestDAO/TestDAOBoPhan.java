package TestDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAOBoPhan;
import DAO_Interface.IDAOBoPhan;
import ptud.Entity.BoPhan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOBoPhan {
	private IDAOBoPhan daoBoPhan;
	
	@BeforeAll
	public void init() {
		try {
			daoBoPhan = new DAOBoPhan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Test delete method
	@Test
	public void testDelete() {
		try {
			boolean result = daoBoPhan.deleteById("HC111");
			System.out.println(result);
			assertTrue(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test get method
	@Test
	public void testGet() {
		try {
			BoPhan boPhan = daoBoPhan.get("HC02");
			System.out.println("Kỹ thuật");
			assertNotNull(boPhan);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test getAll
	@Test
	public void testGetAll() {
		try {
			List<BoPhan> list = daoBoPhan.getAll();
			list.forEach(System.out::println);
			assertNotNull(list);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test insert BoPhan
	@Test
	public void testInsert() {
		try {
			BoPhan boPhan = new BoPhan("HC111", "Phòng kế toán");
			boolean result = daoBoPhan.insert(boPhan);
			System.out.println(result);
			assertTrue(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test getMaBoPhanByTenBoPhan
	@Test
	public void testGetMaBoPhanByTenBoPhan() {
		try {
			String maBoPhan = daoBoPhan.getMaBoPhanByTenBoPhan("Nhân sự");
			System.out.println(maBoPhan);
			assertNotNull(maBoPhan);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test update BoPhan
	@Test
	public void testUpdate() {
		try {
			BoPhan boPhan = new BoPhan("HC111", "Phòng toán");
			boolean result = daoBoPhan.update(boPhan);
			System.out.println(result);
			assertTrue(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	// Test filter method
	@Test
	public void testFilter() {
		try {
			List<BoPhan> list = daoBoPhan.filter("HC");
			list.forEach(System.out::println);
			assertNotNull(list);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@AfterAll
	public void afterAll() {
		daoBoPhan = null;
		
	}
}
