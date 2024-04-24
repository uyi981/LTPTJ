package DAO_Implement;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ptud.Entity.PhieuChamCongHanhChinh;

public class DAO_PhieuChamCongNhanVien extends UnicastRemoteObject implements DAO_Interface.IDAOPhieuChamCongNhanVien {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2693781337997268465L;
	private EntityManager em;
	 
	 public DAO_PhieuChamCongNhanVien() throws RemoteException {
	        em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	    }
	 
	 public static String formatChuoi(int thang, int nam, String idNV) {
	        String thangStr = String.format("%02d", thang);
	        String namStr = String.format("%04d", nam);
	        return thangStr + namStr + idNV;
	    }
	 
	 public static String formatID_PCCHC(LocalDate date, String idNV) {
	        String formattedDate = date.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	        return "PCCHC" + formattedDate + idNV;
	    }
	 
	 public static DAO_PhieuChamCongNhanVien getInstance() throws RemoteException {
	        return new DAO_PhieuChamCongNhanVien();
	    }
	
	@Override
	public boolean themPhieuChamCongNhanVien(PhieuChamCongHanhChinh PCCNV) throws RemoteException {
		try {
            em.getTransaction().begin();
            em.persist(PCCNV);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public int getSoNgayLam(String idNV, int thang, int nam) throws RemoteException {
		try {
			Query query = em.createQuery(
					"SELECT COUNT(*) FROM PhieuChamCongHanhChinh p WHERE p.idCN = :idCN AND month(pc.ngayChamCong) = :thang AND AND  year(pc.ngayChamCong) = :nam ");
			query.setParameter("idCN", idNV);
			query.setParameter("thang", thang);
			query.setParameter("nam", nam);
			return (int) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public float getTongGioTangCaTrongThang(String idNV, int thang, int nam) throws RemoteException {
		 try {
		        String query = "SELECT SUM(p.gioTangCa) " +
		                       "FROM PhieuChamCongHanhChinh p " +
		                       "WHERE p.maNV = :idNV AND month(pc.ngayChamCong) = :thang AND   year(pc.ngayChamCong) = :nam ";

		        Query jpqlQuery = em.createQuery(query);
		        jpqlQuery.setParameter("idNV", idNV);
		        jpqlQuery.setParameter("thang", thang);
		        jpqlQuery.setParameter("nam", nam);

		        Object result = jpqlQuery.getSingleResult();
		        if (result != null) {
		            return (float) result;
		        } else {
		            return 0;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return 0;
		    }
	}
	

	@Override
	public ArrayList<Object[]> getDanhSachThongTinChamCongByIDBoPhan(String maBoPhan) throws RemoteException {
		 ArrayList<Object[]> ds = new ArrayList<>();
		    try {
		        String query = "SELECT nv.maNV, nv.tenNV " +
		                       "FROM NhanVien nv " +
		                       "WHERE nv.maBP = :maBoPhan " +
		                       "AND nv.maNV NOT IN (SELECT pc.maNV FROM PhieuChamCongHanhChinh pc WHERE pc.ngayChamCong = :ngayHienTai)";
//		        Query jpqlQuery = em.createQuery(query);
//		        jpqlQuery.setParameter("maBoPhan", maBoPhan);
//		        jpqlQuery.setParameter("ngayHienTai", getCurrentDateYYYYMMDD());
		        List<Object[]> resultSet =(List<Object[]> )em.createNativeQuery(query).setParameter("maBoPhan", maBoPhan).setParameter("ngayHienTai", getCurrentDateYYYYMMDD()).getResultList();
		        for (Object[] row : resultSet) {
		            Object[] thongTinChamCong = new Object[7];
		            thongTinChamCong[0] = row[0];
		            thongTinChamCong[1] = row[1];
		            thongTinChamCong[2] = false;
		            thongTinChamCong[3] = false;
		            thongTinChamCong[4] = 0;
		            thongTinChamCong[5] = "";
		            ds.add(thongTinChamCong);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return ds;
	}

	@Override
	public Object[] gethongTinChamCongByMaNV(String maNV) throws RemoteException {
		 Object[] thongTinChamCong = null;
		    try {
		        String query = "SELECT pc.maNV, pc.ngayChamCong, pc.vang, pc.diTre, pc.gioTangCa, pc.tienPhat, pc.noiDungPhat " +
		                       "FROM PhieuChamCongHanhChinh pc " +
		                       "WHERE pc.maNV = :maNV";

		        Query jpqlQuery = em.createQuery(query);
		        jpqlQuery.setParameter("maNV", maNV);
		        Object result = jpqlQuery.getSingleResult();
		        if (result != null) {
		            thongTinChamCong = (Object[]) result;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return thongTinChamCong;
	}

	@Override
	public float getTongTienPhatTrongThang(String idNV, int thang, int nam) throws RemoteException {
		  try {
		        String query = "SELECT SUM(pc.tienPhat) " +
		                       "FROM PhieuChamCongHanhChinh pc " +
		                       "WHERE pc.maNV = :idNV AND  month(pc.ngayChamCong) = :thang AND   year(pc.ngayChamCong) = :nam ";

		        Query jpqlQuery = em.createQuery(query);
		        jpqlQuery.setParameter("idNV", idNV);
		        jpqlQuery.setParameter("thang", thang);
		        jpqlQuery.setParameter("nam", nam);

		        Object result = jpqlQuery.getSingleResult();
		        if (result != null) {
		            return (float) result;
		        } else {
		            return 0;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return 0;
		    }
	}

	@Override
	public String getCurrentDateYYYYMMDD() throws RemoteException {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return currentDate.format(formatter);
		
	}

}
