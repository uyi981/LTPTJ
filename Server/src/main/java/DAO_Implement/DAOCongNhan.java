package DAO_Implement;

//import static ptud.Mang.connection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ptud.Entity.BoPhan;
import ptud.Entity.CongNhan;
public class DAOCongNhan extends UnicastRemoteObject implements DAO_Interface.IDAOCongNhan
{
	EntityManager em;
	public DAOCongNhan() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("MSSQL")
				.createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7286228071263536928L;

	@Override
	public boolean themCongNhan(CongNhan congNhan) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(congNhan);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean xoaCongNhan(String maCongNhan) throws RemoteException {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			CongNhan congNhan = em.find(CongNhan.class, maCongNhan);
			em.remove(congNhan);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void suaCongNhan(CongNhan congNhan) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(congNhan);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public CongNhan timKiemCongNhan(String maCongNhan) throws RemoteException {
		// TODO Auto-generated method stub
		return em.find(CongNhan.class, maCongNhan);
	}

	@Override
	public List<CongNhan> layDanhSachCongNhan() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	  public int countAll() throws RemoteException {
	       return em.createQuery("SELECT COUNT(c) FROM CongNhan c", Integer.class).getSingleResult();
	    }
	  @Override	     
	     public ArrayList<CongNhan> search(String searchText, String searchCriteria) throws RemoteException {
	        ArrayList<CongNhan> dsCongNhan = new ArrayList<>();
	        try {
	            String query = "";
	            PreparedStatement statement = null;

	            // Xây dựng câu truy vấn dựa trên tiêu chí tìm kiếm
	            switch (searchCriteria) {
	                case "Mã CN":
	                    query = "SELECT CongNhan.MaCN FROM CongNhan WHERE maCN LIKE ? AND trangThai = 1";
	                    break;
	                case "Tên công nhân": 
	                    query = "SELECT CongNhan.MaCN FROM CongNhan WHERE tenCN LIKE ? AND trangThai = 1";
	                    break;
	                case "Số điện thoại":
	                    query = "SELECT CongNhan.MaCN FROM CongNhan WHERE dienThoai LIKE ? AND trangThai = 1";
	                    break;
	                // Thêm các trường hợp khác nếu cần
	                default:
	                    // Không hỗ trợ tiêu chí tìm kiếm
	                    return dsCongNhan;
	            }
	            	          
	            List<?> list = em.createNativeQuery(query).setParameter(1, "%" + searchText + "%").getResultList();
				list.forEach(item -> {
					String maCN = (String) item;
					CongNhan congNhan = em.find(CongNhan.class, maCN);
					dsCongNhan.add(congNhan);
				});
	            System.out.println("từ khóa: " + searchText);
	            System.out.println("Query: " + query);
	            	            
	            System.out.println("Kết quả: " + dsCongNhan.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return dsCongNhan;
	    }
  
}
