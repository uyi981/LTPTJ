package ptud.Entity;

import java.util.ArrayList;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ptud.Entity.CongDoan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.util.Set;

import DAO_Implement.DAOCongDoan;
import DAO_Implement.DAOCongNhan;
import DAO_Implement.DAOHopDong;
import DAO_Implement.DAOSanPham;
@NoArgsConstructor
@Entity
public class SanPham implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6404978116106301355L;
	// Author VoPhuocHau
  @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
  @jakarta.persistence.JoinColumn(name = "maHD")
  HopDong hopDong;
  @Transient
  String maHD;
  @Transient
  ArrayList<CongDoan> congDoans = new ArrayList<>();
  
    public String getMaHD() 
    {
        return hopDong.getMaHD();
    }

    public void setMaHD(String maHD) 
    {
    	try {
    	    this.maHD = maHD;
            DAOHopDong daoHopDong = new DAOHopDong();
            hopDong = daoHopDong.timKiemHopDong(maHD);
		} catch (Exception e) {
			// TODO: handle exception
		}
    
    }
  @Id
  @Column(name = "maSP")
  String maSanPham;
  @Column(name = "tenSP",columnDefinition = "NVARCHAR(100)")
  String tenSanPham;
  int soLuong;
  double donGia;
  @Transient
  int tienDo;
  @OneToMany(mappedBy = "sanPham")
  Set<CongDoan> congDoan;
	@Column(name ="hinhAnh",columnDefinition = "VARBINARY(MAX)"
			,nullable = true)
	private byte[] avatar;
    public ArrayList<CongDoan> getCongDoans() {
        return congDoans;
    }

    public void updateListCongDoans() throws Exception
    {
    	DAOCongDoan daocd = new DAOCongDoan();
       for(CongDoan congDoan : daocd.getAll())
       {
           if(congDoan.getMaSP().compareToIgnoreCase(this.maSanPham)==0)
           {
               if(!congDoans.contains(congDoan))
               {
                   congDoans.add(congDoan);
               }
           }
       }
    }

    public int getTienDo() {
        return tienDo;
    }

    public void setTienDo() throws Exception
    {        
        updateListCongDoans();
        int tienDo;
        if (congDoans.size() != 0) {
            String max = congDoans.get(0).getMaCD();
            tienDo = congDoans.get(0).getSoLuongHoanThanh();
            System.out.println(congDoans.get(0).getSoLuongHoanThanh());
            for (CongDoan congDoan : congDoans) {
                if (congDoan.getMaCD().compareToIgnoreCase(max) > 0) {
                    max = congDoan.getMaCD();
                    tienDo = congDoan.getSoLuongHoanThanh();
                    System.out.println(congDoan.getSoLuongHoanThanh());
                }

                this.tienDo = tienDo;              
            }
        } 
        else 
        {
             this.tienDo = 0;
        }
    }

  public String getMaSanPham() 
    {
		return maSanPham;
	}
	public void setMaSanPham(int stt) 
	{
		if(stt<10)
		{
                    String sttString = "0"+stt;
			this.maSanPham = this.maHD+sttString;
		}
		else 
		{  
                    String sttString = ""+stt;
                    this.maSanPham = this.maHD+stt;
		}
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		if(tenSanPham.trim().equals(""))
		{
			tenSanPham = "Khong xac dinh";
		}
		this.tenSanPham = tenSanPham;
	}
	public int getSoLuong() 
	{
		
		return soLuong;
	}
	public void setSoLuong(int soLuong) 
	{
		if(soLuong<0)
		{
			soLuong = 0;
		}
		this.soLuong = soLuong;
	}
	public double getDonGia() 
	{
		
		return donGia;
	}
	public void setDonGia(double donGia) 
	{
		if(donGia<0)
		{
			donGia = 0;
		}
		this.donGia = donGia;
	}
        public void setMaSanPham(String maSanPham)
        {
            this.maSanPham = maSanPham;
        }
	public SanPham(String maSanPham, String tenSanPham, int soLuong, double donGia,String maHD) 
	{
		super();
		this.setDonGia(donGia);               
		this.setMaSanPham(maSanPham);
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
                this.setMaHD(maHD);
	}
        public SanPham(int stt, String tenSanPham, int soLuong, double donGia,String maHD) 
	{
		super();
                this.setMaHD(maHD);
		this.setDonGia(donGia);               		
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
                this.setMaSanPham(stt);
               
	}
}