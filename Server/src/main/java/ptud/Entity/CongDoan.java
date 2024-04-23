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

import DAO_Implement.DAOBoPhan;
import DAO_Implement.DAOChiTietPhanCong;
import DAO_Implement.DAOCongDoan;
import DAO_Implement.DAOSanPham;
import DAO_Interface.IDAOBoPhan;
import DAO_Interface.IDAOSanPham;
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
	@Transient
	private String maSP;
	@Transient
	private String maBP;
	@Transient
	private ArrayList<String> dsCDTQ;
	
	@Transient
	IDAOBoPhan daoBoPhan;
	@Transient
	IDAOSanPham daoSanPham;
	public void insertCDTQ(CongDoan cd)
	{
		dsCDTQs.add(cd);
	}
	public CongDoan() {
	}

	public CongDoan(String maCD, String maSP, String maBP, String tenCD, double donGia, boolean trangThai,
			int soLuongChuanBiToiThieu, ArrayList<String> dsCDTQ) {
		
		try {
			daoBoPhan = new DAOBoPhan();
			this.boPhan = daoBoPhan.get(maBP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			daoSanPham = new DAOSanPham();
			this.sanPham = daoSanPham.timKiemSanPham(maSP);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setMaCD(maCD);
		setMaSP(maSP);
		setMaBP(maBP);
		setTenCD(tenCD);
		setDonGia(donGia);
		setTrangThai(trangThai);
		setSoLuongChuanBiToiThieu(soLuongChuanBiToiThieu);
		setDsCDTQ(dsCDTQ);
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

	public int getSoLuongHoanThanh() throws Exception {
		return soLuongHoanThanh;
	}

	public ArrayList<String> getDsCDTQ() {
		return dsCDTQ;
	}

	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public void setMaBP(String maBP) {
		this.maBP = maBP;
		
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

	public void setDsCDTQ(ArrayList<String> dsCDTQ) {
		this.dsCDTQ = dsCDTQ;
	}

	public void addCDTQ(String maCDTQ) {
		if (dsCDTQ == null) {
			dsCDTQ = new ArrayList<String>();
		}
		dsCDTQ.add(maCDTQ);
	}

	public void deleteCDTQ(String maCDTQ) {
		if (dsCDTQ != null) {
			dsCDTQ.remove(maCDTQ);
		}
	}

	public void updateCDTQ(String maCDTQ, String maCDTQNew) {
		if (dsCDTQ != null) {
			int index = dsCDTQ.indexOf(maCDTQ);
			if (index != -1) {
				dsCDTQ.set(index, maCDTQNew);
			}
		}
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

	@Override
	public String toString() {
		return "CongDoan [maCD=" + maCD + ", tenCD=" + tenCD + ", donGia=" + donGia + ", trangThai=" + trangThai
				+ ", soLuongChuanBi=" + soLuongChuanBi + ", soLuongChuanBiToiThieu=" + soLuongChuanBiToiThieu
				+ ", soLuongHoanThanh=" + soLuongHoanThanh + ", maSP=" + sanPham.getMaSanPham() + ", maBP=" + boPhan.getMaBP() + "]";
	}
	
	

}
