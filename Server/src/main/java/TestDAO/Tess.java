package TestDAO;

import DAO_Implement.DAO_PhieuChamCongCongNhan;

public class Tess {
	public static void main(String[] args) {
		try {
			DAO_PhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAO_PhieuChamCongCongNhan();
			System.out.print("tétcc");
		    Object[] aObjects = daoPhieuChamCongCongNhan.getThongTinChamCongByMaCongNhan("SX01051001");
		    System.out.print("cc"+aObjects[0]);
		} catch (Exception e) {
			//System.out.print();
			// TODO: handle exception
		}
		
	}
}
