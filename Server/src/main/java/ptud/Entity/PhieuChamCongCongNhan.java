package ptud.Entity;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
*
* @author NguyenTrongPhuc
*/
@Entity
@Table(name = "PhieuChamCongCongNhan")

public class PhieuChamCongCongNhan implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179437309301218357L;
	@Id
   private String maPCCCN;
	@Column(name = "ngayChamCong",columnDefinition = "DATE")
   private LocalDate ngay;
   private boolean vang;
   @Column(name = "soluongCD")
   private int soLuongSanPham;
   @Transient
   private String maCTPC;
   public String getMaCTPC() {
	return maCTPC;
}

public void setMaCTPC(String maCTPC) {
	this.maCTPC = maCTPC;
}

public ChiTietPhanCong getChiTietPhanCong() {
	return chiTietPhanCong;
}

public void setChiTietPhanCong(ChiTietPhanCong chiTietPhanCong) {
	this.chiTietPhanCong = chiTietPhanCong;
}

   private String noiDungPhat;
   private double tienCong;
   private double tienThuong;
   private double tienPhat;
   @Column(name = "soLuongCDTangCa")
   private int soLuongSanPhamTangCa;
   
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "maCTPC")
   private ChiTietPhanCong chiTietPhanCong;
 

    public PhieuChamCongCongNhan() {
    }

    public PhieuChamCongCongNhan(String maPCCCN, String maCN, LocalDate ngay, boolean vang, int soLuongSanPham, String maCTPC, String noiDungPhat, double tienCong, double tienThuong, double tienPhat, int soLuongSanPhamTangCa) {
        this.maPCCCN = maPCCCN;
        this.ngay = ngay;
        this.vang = vang;
        this.soLuongSanPham = soLuongSanPham;
        this.noiDungPhat = noiDungPhat;
        this.tienCong = tienCong;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.soLuongSanPhamTangCa = soLuongSanPhamTangCa;
    }

    public String getMaPCCCN() {
        return maPCCCN;
    }

    public void setMaPCCCN(String maPCCCN) {
        this.maPCCCN = maPCCCN;
    }

    

    public boolean isVang() {
        return vang;
    }

    public void setVang(boolean vang) {
        this.vang = vang;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

  
    public String getNoiDungPhat() {
        return noiDungPhat;
    }

    public void setNoiDungPhat(String noiDungPhat) {
        this.noiDungPhat = noiDungPhat;
    }

    public double getTienCong() {
        return tienCong;
    }

    public void setTienCong(double tienCong) {
        this.tienCong = tienCong;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getSoLuongSanPhamTangCa() {
        return soLuongSanPhamTangCa;
    }

    public void setSoLuongSanPhamTangCa(int soLuongSanPhamTangCa) {
        this.soLuongSanPhamTangCa = soLuongSanPhamTangCa;
    }      

    @Override
    public String toString() {
        return "PhieuChamCongCongNhan{" + "maPCCCN=" + maPCCCN + ", ngay=" + ngay + ", vang=" + vang + ", soLuongSanPham=" + soLuongSanPham  + ", noiDungPhat=" + noiDungPhat + ", tienCong=" + tienCong + ", tienThuong=" + tienThuong + ", tienPhat=" + tienPhat + ", soLuongSanPhamTangCa=" + soLuongSanPhamTangCa + '}';
    }
    
}
