package ptud.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.util.Set;

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
  
    public String getMaHD() 
    {
        return hopDong.getMaHD();
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
  Set<CongDoan> congDoans;
	@Column(name ="hinhAnh",columnDefinition = "VARBINARY(MAX)"
			,nullable = true)
	private byte[] avatar;


 


    

  public String getMaSanPham() 
    {
		return maSanPham;
	}
	public void setMaSanPham(int stt) 
	{
		if(stt<10)
		{
                    String sttString = "0"+stt;
			this.maSanPham = hopDong.getMaHD()+sttString;
		}
		else 
		{  
                    String sttString = ""+stt;
                    this.maSanPham =hopDong.getMaHD()+stt;
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
	public SanPham(String maSanPham, String tenSanPham, int soLuong, double donGia,HopDong hopDong) 
	{
		super();
		this.setDonGia(donGia);               
		this.setMaSanPham(maSanPham);
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
        this.hopDong = hopDong;
	}
        public SanPham(int stt, String tenSanPham, int soLuong, double donGia,HopDong hopDong) 
	{
		super();
         this.hopDong = hopDong;    
		this.setDonGia(donGia);               		
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
                this.setMaSanPham(stt);
               
	}

		public Set<CongDoan> getCongDoans() {
			return congDoans;
		}

		public void setCongDoans(Set<CongDoan> congDoans) {
			this.congDoans = congDoans;
		}
}