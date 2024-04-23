package TestDAO;

import DAO_Implement.DAOPhieuChamCongCongNhan;

public class Tess {
	public static void main(String[] args) {
		try {
			DAOPhieuChamCongCongNhan daoPhieuChamCongCongNhan = new DAOPhieuChamCongCongNhan();
			System.out.print("tétcc");
		    Object[] aObjects = daoPhieuChamCongCongNhan.getThongTinChamCongByMaCongNhan("SX01051001");
		    System.out.print("cc"+aObjects[0]);
		} catch (Exception e) {
			System.out.print();
			// TODO: handle exception
		}
		
	}
}
