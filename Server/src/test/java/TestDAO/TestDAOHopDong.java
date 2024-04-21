package TestDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAOHopDong;
import ptud.Entity.HopDong;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOHopDong {
	DAOHopDong daoHopDong;
	HopDong hopDong = new HopDong("AAAA", "A", LocalDate.of(2020, 10, 30), LocalDate.of(2021,10,30),10000,"231002","Chờ xác nhận");

	
	@Test
	void test() throws Exception{
		daoHopDong = new DAOHopDong();
		daoHopDong.themHopDong(hopDong);
		if (daoHopDong.timKiemHopDong(hopDong.getMaHD()) == null)
		{
			fail("Chưa thêm được hợp đồng");
		}		
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
