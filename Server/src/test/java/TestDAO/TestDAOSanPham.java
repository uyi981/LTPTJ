package TestDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAOHopDong;
import DAO_Implement.DAOSanPham;
import ptud.Entity.HopDong;
import ptud.Entity.SanPham;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOSanPham {

	DAOSanPham daoSanPham;
	SanPham sanPham = new SanPham("aaaaaa", "Chén sứ dát vàng", 10, 150, "AAAA");
	
	@Test
	void test() throws Exception{
		daoSanPham = new DAOSanPham();
		daoSanPham.themSanPham(sanPham);
		if (daoSanPham.timKiemSanPham(sanPham.getMaSanPham()) == null)
		{
			fail("Chưa thêm được hợp đồng");
		}		
	}
    @AfterAll
    void shutup() throws Exception
    {
    	//daoSanPham.xoaSanPham(sanPham.getMaSanPham());
    }
}
