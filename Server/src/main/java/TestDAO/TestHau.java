package TestDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO_Implement.*;
import ptud.Entity.HopDong;
import ptud.Entity.*;
public class TestHau {
	public static void main(String[] args) throws Exception {
		DAO_CongDoan cd = new DAO_CongDoan();
		DAO_SanPham sp = new DAO_SanPham();
		CongDoan cdds = cd.get("05112023020102");
		CongDoan cdd = cd.get("05112023020103");
		CongDoan cddd = cd.get("05112023020101");
		SanPham spp = sp.timKiemSanPham("051120230201");
		HopDong hd = new HopDong();
		DAO_HopDong hdd = new DAO_HopDong();
		DAO_NhanVien nv = new DAO_NhanVien();
		System.out.println(nv.getMaBoPhan("HC01181001"));
		hd = hdd.timKiemHopDong("0511202302");
		//spp.getCongDoans().iterator().next().getTenCD();
		
		try
		{
			System.out.print(sp.getTienDo(spp.getMaSanPham()));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
            System.out.println("Error");
        }
		ArrayList<String> cd1 = new ArrayList<String>();
		cd1.add(cdd.getMaCD());
		cd1.add(cddd.getMaCD());
        //System.out.println(cdds.getTenCD());	
		cd.themCongDoanTienQuyet(cdds, cd1);
	//	System.out.println(cdd);
	}
}
