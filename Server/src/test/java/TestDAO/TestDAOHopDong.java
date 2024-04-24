package TestDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAO_HopDong;
import ptud.Entity.HopDong;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOHopDong {
	DAO_HopDong daoHopDong;
	HopDong hopDong = new HopDong("AAAA", "A", LocalDate.of(2020, 10, 30), LocalDate.of(2021,10,30),10000,"231002","Chờ xác nhận");

	
	@Test
	void test() throws Exception{
		daoHopDong = new DAO_HopDong();
		daoHopDong.themHopDong(hopDong);
		daoHopDong.layDanhSachHopDong();
		//if (daoHopDong.timKiemHopDong(hopDong.getMaHD()) == null)
		System.out.print(daoHopDong.layDanhSachHopDong().toString());	
	}
	@Test
	void testXoaHopDong() throws  Exception
	{
		
	}
    @AfterAll
    void shutup() throws Exception
    {
    	//daoHopDong.xoaHopDong(hopDong.getMaHD());
    }

}
