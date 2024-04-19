package DAO_Implement;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import ptud.Entity.PhieuChamCongCongNhan;

public class DAOPhieuChamCongCongNhan implements DAO_Interface.IDAOPhieuChamCongCongNhan{
	
	private EntityManager em;
	 
	 public DAOPhieuChamCongCongNhan() throws RemoteException {
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
	        Query query = em.createQuery("select sum(p.tienPhat) as tongTienPhat " +
	                                     "from PhieuChamCongCongNhan p " +
	                                     "where p.maPCCCN like :idCN and p.thang = :thang and p.nam = :nam");
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
	public float getTongTienThuongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
	        Query query = em.createQuery("select sum(p.tienThuong) as tongTienPhat " +
	                                     "from PhieuChamCongCongNhan p " +
	                                     "where p.maPCCCN like :idCN and p.thang = :thang and p.nam = :nam");
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
	        String query = "select sum(p.soLuongCD * cd.donGia) as tongTien " +
	                       "from PhieuChamCongCongNhan p " +
	                       "join ChiTietPhanCong c on p.maCTPC = c.maCTPC " +
	                       "join CongDoan cd on c.maCD = cd.maCD " +
	                       "where p.maPCCCN like :idCN";
	        
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("idCN", "%" + idCN + "%");

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
	public float getTongTienCongTangCaTrongThang(String idCN, int thang, int nam) throws RemoteException {
		try {
	        String query = "select sum(p.soLuongCDTangCa * cd.donGia) as tongTien " +
	                       "from PhieuChamCongCongNhan p " +
	                       "join ChiTietPhanCong c on p.maCTPC = c.maCTPC " +
	                       "join CongDoan cd on c.maCD = cd.maCD " +
	                       "where p.maPCCCN like :idCN";
	        
	        Query jpqlQuery = em.createQuery(query);
	        jpqlQuery.setParameter("idCN", "%" + idCN + "%");

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
	public float getTongTienCongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		 return getTongTienCongKhongTangCaTrongThang(idCN, thang, nam)
	                + getTongTienCongTangCaTrongThang(idCN, thang, nam);
	}
	@Override
	public float getTienLuongTrongThang(String idCN, int thang, int nam) throws RemoteException {
		return getTongTienCongTrongThang(idCN, thang, nam)
                + getTongTienThuongTrongThang(idCN, thang, nam)
                - getTongTienPhatTrongThang(idCN, thang, nam);
		}
	@Override
	public int getSoNgayLam(String idCN, int thang, int nam) throws RemoteException {
		try {
			Query query = em.createQuery(
					"SELECT SUM(p.soNgayLam) FROM PhieuChamCongCongNhan p WHERE p.idCN = :idCN AND p.thang = :thang AND p.nam = :nam");
			query.setParameter("idCN", idCN);
			query.setParameter("thang", thang);
			query.setParameter("nam", nam);
			return (int) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	

}
