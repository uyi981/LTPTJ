package TestDAO;

import java.time.LocalDate;

import DAO_Implement.DAOHopDong;
import ptud.Entity.HopDong;

public class TestHau {
	public static void main(String[] args) throws Exception {
		DAOHopDong daoHopDong = new DAOHopDong();
		HopDong hopDong = new HopDong("AAAA", "A", LocalDate.of(2020, 10, 30), LocalDate.of(2021,10,30),10000,"231002","Chờ xác nhận");
		//daoHopDong.themHopDong(hopDong);
	System.out.print(daoHopDong.timKiemHopDong(hopDong.getMaHD()).ToString());
		daoHopDong.xoaHopDong(hopDong.getMaHD());
	}
}
