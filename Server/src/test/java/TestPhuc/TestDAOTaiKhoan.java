package TestPhuc;

import static org.mockito.ArgumentMatchers.intThat;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAO_TaiKhoan;
import DAO_Interface.IDAOTaiKhoan;
import ptud.Entity.TaiKhoan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDAOTaiKhoan {
	private IDAOTaiKhoan daoTaiKhoan;

	@BeforeAll
	public void init() {
		try {
			daoTaiKhoan = new DAO_TaiKhoan();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void testGetUserRole() {
//		try {
//			daoTaiKhoan  = new DAOTaiKhoan();
//			int role = daoTaiKhoan.getUserRole("tk008", "8d969eef6ecad3c2");
//			System.out.println(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

//	@Test
//	public void testGetUserRoleByUserName() {
//		try {
//			daoTaiKhoan  = new DAOTaiKhoan();
//			int role = daoTaiKhoan.getUserRoleByUserName("tk008");
//			System.out.println(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

//	@Test
//	public void testGetTenNhanVienTaiKhoanByIDNV() {
//		try {
//			daoTaiKhoan  = new DAOTaiKhoan();
//			String role = daoTaiKhoan.getTenNhanVienTaiKhoanByIDNV("HC02201008");
//			System.out.println(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	@Test
	public void testGetAll() {
	    try {
	        ArrayList<TaiKhoan> dsTaiKhoan = daoTaiKhoan.getAll();
	        for (TaiKhoan tk : dsTaiKhoan) {
	            System.out.println(tk);
	        }
	        System.out.println("211");
	    } catch (RemoteException e) {
	        e.printStackTrace();
	    }
	}
//	@Test
//	public void testUpdateTaiKhoan() {
//		try {
//			TaiKhoan tk = new TaiKhoan();
//			tk = daoTaiKhoan.getAll().get(7);
//			System.out.println(tk);
//			tk.setVaiTro(2222);
//			daoTaiKhoan.updateTaiKhoan(tk);  
//			System.out.println(tk);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	@Test
//	public void testCreateTaiKhoan () {
//		
//		try {
//			System.out.println("123");
//			TaiKhoan tk = new TaiKhoan("tk008", "HC02201008", "8d969eef6ecad3c2", 1, true);
//			daoTaiKhoan.createTaiKhoan(tk);
//			daoTaiKhoan.getAll().forEach(System.out::println);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testDeleteTaiKhoanByID () {
//		try {
//			daoTaiKhoan.deleteTaiKhoanByID("tk008");
//			daoTaiKhoan.getAll().forEach(System.out::println);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
	
	@AfterAll
	public void end() {
		try {
			daoTaiKhoan = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
