package TestDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO_Implement.DAOBoPhan;
import DAO_Implement.DAOHopDong;
import DAO_Implement.DAONhanVien;
import ptud.Entity.HopDong;
import ptud.Entity.*;

public class TestHau {
	public static void main(String[] args) throws Exception {
		DAONhanVien daoNhanVien = new DAONhanVien();
		NhanVien cn = daoNhanVien.timKiemNhanVien("HC01181005");
		System.out.println(cn.getBoPhan().getTenBP());
		DAOBoPhan daoBoPhan = new DAOBoPhan();
		BoPhan bp = daoBoPhan.get(cn.getBoPhan().getMaBP());
		ArrayList<NhanVien> a = (ArrayList)daoNhanVien.layDanhSachNhanVien();
		if(bp.getTenBP().equals(cn.getBoPhan().getTenBP()))	
		System.out.println(a);
	}
}
