/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


/**
 * 
 * @author Hung
 */
@Entity
@Table(name = "CongDoan")
public class CongDoan implements java.io.Serializable {
	public BoPhan getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(BoPhan boPhan) {
		this.boPhan = boPhan;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5017574781139848315L;
	@Id
	@Column(name = "maCD", columnDefinition = "VARCHAR(50)", nullable = false)
	private String maCD;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String tenCD;
	@Column(columnDefinition = "REAL NULL")
	private double donGia;
	@Column(columnDefinition = "BIT")
	private boolean trangThai;
	  @Column(nullable = true)
	private int soLuongChuanBi;
	  @Column(nullable = true)
	private int soLuongChuanBiToiThieu;
	  @Column(nullable = true)
	private int soLuongHoanThanh;

	// CongDoan has one BoPhan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maBP")
	private BoPhan boPhan;

	// CongDoan has many ChiTietPhanCong
	@OneToMany(mappedBy = "congDoan")
	private Set<ChiTietPhanCong> chiTietPhanCongs;

	// CongDoan has many CongDoanTienQuyet
//		@OneToMany(mappedBy = "congDoan")
//		private Set<CongDoanTienQuyet> congDoanTienQuyets;

	// CongDoan has one SanPham
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maSP")
	private SanPham sanPham;
	

	 @ManyToMany
	    @JoinTable(
	        name = "CongDoanTienQuyet",
	        joinColumns = @JoinColumn(name = "maCD"),
	        inverseJoinColumns = @JoinColumn(name = "maCDTQ")
	    )
	 private Set<CongDoan> dsCDTQs = new HashSet<CongDoan>();

	public CongDoan() {
	}

	public CongDoan(String maCD, SanPham sanPham, BoPhan boPhan, String tenCD, double donGia, boolean trangThai,
			int soLuongChuanBiToiThieu) {
		
		
		this.sanPham = sanPham;
		this.boPhan = boPhan;
		setTenCD(tenCD);
		setDonGia(donGia);
		setTrangThai(trangThai);
		setSoLuongChuanBiToiThieu(soLuongChuanBiToiThieu);
	}

	public String getMaCD() {
		return maCD;
	}

	public String getMaSP() {
		return this.sanPham.getMaSanPham();
	}

	public String getMaBP() {
		return this.boPhan.getMaBP();
	}

	public String getTenCD() {
		return tenCD;
	}

	public double getDonGia() {
		return donGia;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public int getSoLuongChuanBi() throws Exception  {
		return soLuongChuanBi;
	}

	public int getSoLuongChuanBiToiThieu() {
		return soLuongChuanBiToiThieu;
	}

	public int getSoLuongHoanThanh() {
		return soLuongHoanThanh;
	}


	public void setTenCD(String tenCD) {
		this.tenCD = tenCD;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public void setSoLuongChuanBiToiThieu(int soLuongChuanBiToiThieu) {
		this.soLuongChuanBiToiThieu = soLuongChuanBiToiThieu;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.maCD);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CongDoan other = (CongDoan) obj;
		return Objects.equals(this.maCD, other.maCD);
	}

	public Set<CongDoan> getDsCDTQs() {
		return dsCDTQs;
	}

	public void setDsCDTQs(Set<CongDoan> dsCDTQs) {
		this.dsCDTQs = dsCDTQs;
	}

	@Override
	public String toString() {
		return "CongDoan [maCD=" + maCD + ", tenCD=" + tenCD + ", donGia=" + donGia + ", trangThai=" + trangThai
				+ ", soLuongChuanBi=" + soLuongChuanBi + ", soLuongChuanBiToiThieu=" + soLuongChuanBiToiThieu
				+ ", soLuongHoanThanh=" + soLuongHoanThanh + ", maSP=" + sanPham.getMaSanPham() + ", maBP=" + boPhan.getMaBP() + "]";
	}
	
	

}
