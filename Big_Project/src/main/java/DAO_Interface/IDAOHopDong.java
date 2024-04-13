package DAO_Interface;

import java.util.List;

import ptud.Entity.HopDong;

public interface IDAOHopDong
{
 public boolean themHopDong();
 public boolean suaHopDong();
 public boolean xoaHopDong();
 public HopDong timKiemHopDong();
 public List<HopDong> layDanhSachHopDong();
}
