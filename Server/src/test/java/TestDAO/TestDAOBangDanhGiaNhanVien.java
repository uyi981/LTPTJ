package TestDAO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAOBangDanhGiaNhanVien;
import DAO_Implement.DAONhanVien;
import DAO_Interface.IDAOBangDanhGiaNhanVien;
import DAO_Interface.IDAONhanVien;
import ptud.Entity.BangDanhGiaNhanVien;
import ptud.Entity.NhanVien;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOBangDanhGiaNhanVien {
	private IDAOBangDanhGiaNhanVien daoBangDanhGiaNhanVien;
	private IDAONhanVien daoNhanVien;
	
	@BeforeAll
	public void init() {
		try {
			daoBangDanhGiaNhanVien = new DAOBangDanhGiaNhanVien();
			daoNhanVien = new DAONhanVien();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGet() {
		try {
			BangDanhGiaNhanVien bangDanhGiaNhanVien = daoBangDanhGiaNhanVien.get("BDG037");
			System.out.println(bangDanhGiaNhanVien);
			assertNotNull(bangDanhGiaNhanVien);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAll() {
		try {
			List<BangDanhGiaNhanVien> list = daoBangDanhGiaNhanVien.getAll();
			list.forEach(System.out::println);
			assert(list.size() > 0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testInsert() {
		try {
			NhanVien nhanVien = daoNhanVien.timKiemNhanVien("HC02201006");
			BangDanhGiaNhanVien bangDanhGiaNhanVien = new BangDanhGiaNhanVien(nhanVien, 2023, 5, 8, 5,
					8);
			daoBangDanhGiaNhanVien.insert(bangDanhGiaNhanVien);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate() {
        try {
            BangDanhGiaNhanVien bangDanhGiaNhanVien = daoBangDanhGiaNhanVien.get("HC022010062023");
            bangDanhGiaNhanVien.setDiemChuyenCan(10);
            boolean result = daoBangDanhGiaNhanVien.update(bangDanhGiaNhanVien);
            assertTrue(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}
	@Test
	public void testDelete() {
		try {
			boolean result = daoBangDanhGiaNhanVien.deleteById("BDG046");
			assertTrue(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetBangDanhGiaCuaNhanVien() {
		try {
			BangDanhGiaNhanVien bangDanhGiaNhanVien = daoBangDanhGiaNhanVien.getBangDanhGiaCuaNhanVien("HC02201006",
					2023);
			System.out.println(bangDanhGiaNhanVien);
			assertNotNull(bangDanhGiaNhanVien);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void addOrUpdate() {
        try {
            NhanVien nhanVien = daoNhanVien.timKiemNhanVien("HC02201004");
            BangDanhGiaNhanVien bangDanhGiaNhanVien = new BangDanhGiaNhanVien(nhanVien, 2023, 10, 8, 5,
                    8);
            daoBangDanhGiaNhanVien.addOrUpdate(bangDanhGiaNhanVien);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	
	@AfterAll
	public void clean() {
		daoBangDanhGiaNhanVien = null;
		daoNhanVien = null;
	}
}
