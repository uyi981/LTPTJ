package ptud.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column; 
@Entity
public class KhachHang implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4537509636308592658L;
	// Author VoPhuocHau
	@Id
	@Column(name = "maKH")
	String maKhachHang;
	@Column(name = "tenKH")
	String tenKhachHang;
	@Column(name = "toChuc")
	boolean isToChuc;
	String email;
	@Column(name = "dienThoai")
	String sdt;
	@OneToMany(mappedBy = "khachHang")
	Set<HopDong> hopDongs;
	@Column(name ="hinhAnh",columnDefinition = "VARBINARY(MAX)"
			,nullable = true)
	private byte[] avatar;
	public String getMaKhachHang() 
	{
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) 
	{
		this.maKhachHang = maKhachHang;
	}
        public void setMaKhachHang(int stt) 
	{
          int year = LocalDate.now().getYear();
          year= year%100;
          maKhachHang = ""+year;
            System.out.println(maKhachHang);
          if(stt<10)
          {
              maKhachHang += "000"+stt;
          }
          else if(stt<100)
          {
              maKhachHang += "00"+stt;
          }
          else if(stt<1000)
          {
              maKhachHang += "0"+stt; 
          }
          else
          {
              maKhachHang += ""+stt;   
          }
	}
	public String getTenKhachHang() 
	{
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) 
	{
		this.tenKhachHang = tenKhachHang;
	}
	public boolean isToChuc() 
	{
		return isToChuc;
	}
	public void setToChuc(boolean isToChuc) 
	{
		this.isToChuc = isToChuc;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getSdt() 
	{
		return sdt;
	}
	public void setSdt(String sdt) 
	{
		this.sdt = sdt;
	}
        public KhachHang()
        {
            
        }       
        public KhachHang(String maKhachHang, String tenKhachHang, boolean isToChuc, String email, String sdt) 
        {
	 super();
	 this.setMaKhachHang(maKhachHang);
         this.setSdt(sdt);
         this.setEmail(email);
         this.setTenKhachHang(tenKhachHang);
         this.setToChuc(isToChuc);
	}
        public KhachHang(int stt,String tenKhachHang, boolean isToChuc, String email, String sdt) 
        {
	 super();	
         this.setSdt(sdt);
         this.setEmail(email);
         this.setTenKhachHang(tenKhachHang);
         this.setToChuc(isToChuc);
         this.setMaKhachHang(stt);
	}
	
}
