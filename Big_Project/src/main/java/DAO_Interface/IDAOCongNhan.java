package DAO_Interface;

import java.util.List;

import ptud.Entity.CongNhan;

public interface IDAOCongNhan {
	public boolean ThemCongNhan(CongNhan congNhan);
	public boolean XoaCongNhan(String maCongNhan);
	public void SuaCongNhan(String maCongNhan);
	public CongNhan TimKiemCongNhan(String maCongNhan);
	public List<CongNhan> layDanhSachCongNhan();
}
