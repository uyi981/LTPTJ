package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ptud.Entity.ChamCongDTO;
import ptud.Entity.PhieuChamCongCongNhan;

public class DAO_PhieuChamCongCongNhan extends UnicastRemoteObject implements DAO_Interface.IDAOPhieuChamCongCongNhan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4603057401427970452L;
	private EntityManager em;

	public DAO_PhieuChamCongCongNhan() throws RemoteException {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	public static String formatChuoi(int thang, int nam, String idCN) {
		String thangStr = String.format("%02d", thang);
		String namStr = String.format("%04d", nam);
		return thangStr + namStr + idCN;
	}

	public static String formatID_PCCCN(LocalDate date, String idCN) {
		String formattedDate = date.format(DateTimeFormatter.ofPattern("ddMMyy"));
		return formattedDate + idCN;
	}

	public static DAO_PhieuChamCongCongNhan getInstance() throws RemoteException {
		return new DAO_PhieuChamCongCongNhan();
	}

	@Override
	public boolean themPhieuChamCongCongNhan(PhieuChamCongCongNhan PCCCN) throws RemoteException {
		try {
			em.getTransaction().begin();
			em.persist(PCCCN);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public float getTongTienPhatTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
			String query = "select sum(tienPhat) as tongTienPhat\n"
	                + "from [dbo].[PhieuChamCongCongNhan]\n"
	                + "where maPCCCN like ?";
			return (int) em.createNativeQuery(query).setParameter(1, "%" + formatChuoi(thang, nam, idCN)+"%").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();	
			return 0;
		}
	}

	@Override
	public float getTongTienThuongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
			Query query = em.createQuery("select sum(p.tienThuong) as tongTienPhat " + "from PhieuChamCongCongNhan p "
					+ "where p.maPCCCN like :idCN and p.thang = :thang and p.nam = :nam");
			query.setParameter("idCN", "%" + idCN + "%");
			query.setParameter("thang", thang);
			query.setParameter("nam", nam);
			return (float) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public float getTongTienCongKhongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
			String query = "select sum(soLuongCD * donGia)\n as tongTien\n"
	                + "from [dbo].[PhieuChamCongCongNhan] p\n"
	                + "join [dbo].[ChiTietPhanCong] c on p.maCTPC = c.maCTPC\n"
	                + "join [dbo].[CongDoan] cd on c.maCD = cd.maCD\n"
	                + "where maPCCCN like ?";
			return (float) em.createNativeQuery(query).setParameter(1, "%" + formatChuoi(thang, nam, idCN)+"%").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();	
			return 0;
		}
	}


	@Override
	public float getTongTienCongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
			String query = "select sum(soLuongCD * donGia * 1.2)\n as tongTien\n"
	                + "from [dbo].[PhieuChamCongCongNhan] p\n"
	                + "join [dbo].[ChiTietPhanCong] c on p.maCTPC = c.maCTPC\n"
	                + "join [dbo].[CongDoan] cd on c.maCD = cd.maCD\n"
	                + "where maPCCCN like ?";
			float result = (float) em.createNativeQuery(query).setParameter(1, "%" + formatChuoi(thang, nam, idCN)+"%").getSingleResult();
		   if(result>=0) return result;
		   else
			    return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public float getTongTienCongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		return getTongTienCongKhongTangCaTrongThang(idCN, thang, nam)
				+ getTongTienCongTangCaTrongThang(idCN, thang, nam);
	}

	@Override
	public float getTienLuongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		return getTongTienCongTrongThang(idCN, thang, nam) + getTongTienThuongTrongThang(idCN, thang, nam)
				- getTongTienPhatTrongThang(idCN, thang, nam);
	}

	@Override
	public int getSoNgayLam(String idCN, int thang, int nam) throws RemoteException {
		try {
			String query = 
					"select count(*) as soLuong from [dbo].[PhieuChamCongCongNhan] where maPCCCN like ? and vang = 0";
			return (int) em.createNativeQuery(query).setParameter(1, "%" + formatChuoi(thang, nam, idCN)+"%").getSingleResult();
		
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	private void setParameter(Query query, String idCN, int thang, int nam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentDateYYYYMMDD() throws RemoteException {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return currentDate.format(formatter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Object[]> getDanhSachThongTinChamCongByIDBoPhan(String maBoPhan) throws RemoteException {
		    
		 String query =  "select cn.maCN, cn.tenCN, cd.tenCD, c.soLuongCDGiao\n"
                 + "from [dbo].[ChiTietPhanCong] c\n"
                 + "join [dbo].[CongNhan] cn on c.maCN = cn.maCN\n"
                 + "join [dbo].[CongDoan] cd on c.maCD = cd.maCD\n"
                 + "left join PhieuChamCongCongNhan p on c.maCTPC = p.maCTPC\n"
                 + "where cd.maBP = ? and c.maCTPC not in (select p.maCTPC from [dbo].[PhieuChamCongCongNhan] p)\n";
		 
		ArrayList<Object[]> result = (ArrayList<Object[]>) em.createNativeQuery(query).setParameter(1, maBoPhan).getResultList(); 
		
		ArrayList<Object[]> rs = new ArrayList<Object[]>();
		for (Object[] obj : result) {
			Object[] hold = new Object[10];
			hold[0] = obj[0];
			hold[1] = obj[1];
			hold[2] = false;
			hold[3] = obj[2];
			hold[4] = obj[3];
			hold[5] = hold[4];
			hold[6] = 0;
			hold[7] = 0;
			hold[8] = 0;
			hold[9] = "";
			rs.add(hold);
		}
		return rs;

//		        query.setParameter("maBoPhan", maBoPhan);
//		        query.setParameter("ngay", getCurrentDateYYYYMMDD());
//		        ds = (ArrayList<Object[]>) query.getResultList();
//		    
//		    return ds;
	}

	@Override
	public Object[] getThongTinChamCongByMaCongNhan(String maCN) throws RemoteException {
		
		String query =  "select cd.maBP, cn.maCN, cn.tenCN, cd.tenCD, c.soLuongCDGiao\n"
                + "from [dbo].[ChiTietPhanCong] c\n"
                + "join [dbo].[CongNhan] cn on c.maCN = cn.maCN\n"
                + "join [dbo].[CongDoan] cd on c.maCD = cd.maCD\n"
                + "where cn.maCN = ? and c.maCTPC not in (select p.maCTPC from [dbo].[PhieuChamCongCongNhan] p)\n";
		
		// TODO Auto-generated method stub
		Object result =   em.createNativeQuery(query).setParameter(1, maCN).getSingleResult();
		Object[] rs =  (Object[]) result;
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ChamCongDTO> getDsCongDoanLamDuocCuaCongNhanTrongThang(String maCN, int thang, int nam)
			throws RemoteException {
		ArrayList<ChamCongDTO> resultList = (ArrayList<ChamCongDTO>) em
				.createNativeQuery("select cn.maCD, SUM(c.soLuongCD) as TongSoLuongCD, SUM(c.soLuongCDTangCa) as TongSoLuongCDTangCa\n"
	                    + "from [dbo].[PhieuChamCongCongNhan] c\n"
	                    + "join [dbo].[ChiTietPhanCong] cn on c.maCTPC = cn.maCTPC\n"
	                    + "where cn.maCN = ? and MONTH(ngay) = ? and YEAR(ngay) = ?\n"
	                    + "group by cn.maCD", ChamCongDTO.class)
				.setParameter("maCN", maCN).setParameter(nam, thang).setParameter(nam, maCN) .getResultList();
		return resultList;
		
	}

}
