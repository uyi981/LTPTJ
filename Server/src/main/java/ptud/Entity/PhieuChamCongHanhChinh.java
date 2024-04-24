/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import DAO_Implement.DAO_NhanVien;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
*
* @author NguyenTrongPhuc
*/
@Entity
@Table(name = "PhieuChamCongHanhChinh")
public class PhieuChamCongHanhChinh implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3787578402698920278L;
	@Id
   private String maPCCHC;
   @Column(name = "ngayChamCong",columnDefinition = "DATE")
   private LocalDate ngay;
   private boolean vang, diTre;
   private int gioTangCa;
   private double tienPhat;
   @Column(name = "noiDungPhat")
   private String noiDungTienPhat;

   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "maNV")
   NhanVien nhanVien;
   
   

//    public PhieuChamCongHanhChinh(String maPCCHC, String maNV, LocalDate ngay, boolean vang, int gioTangCa, String noiDungTienPhat) {
//        this.maPCCHC = maPCCHC;
//        this.maNV = maNV;
//        this.ngay = ngay;
//        this.vang = vang;
//        this.diTre = diTre;
//        this.gioTangCa = gioTangCa;
//        this.tienPhat = tienPhat;
//        this.noiDungTienPhat = noiDungTienPhat;
//    }
    
    

    public PhieuChamCongHanhChinh(String maPCCHC, NhanVien nhanVien, LocalDate ngay, boolean vang, boolean diTre,
			int gioTangCa, double tienPhat, String noiDungTienPhat) {
		super();
		this.maPCCHC = maPCCHC;
		this.nhanVien = nhanVien;
		this.ngay = ngay;
		this.vang = vang;
		this.diTre = diTre;
		this.gioTangCa = gioTangCa;
		this.tienPhat = tienPhat;
		this.noiDungTienPhat = noiDungTienPhat;
	}

    


	public NhanVien getNhanVien() {
		return nhanVien;
	}




	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}




	public String getMaPCCHC() {
        return maPCCHC;
    }

    public void setMaPCCHC(String maPCCHC) {
        this.maPCCHC = maPCCHC;
    }

    

    public PhieuChamCongHanhChinh() {
    }

    public String getMaNV() {
        return nhanVien.getMaNV();
    }

   

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public boolean isVang() {
        return vang;
    }

    public void setVang(boolean vang) {
        this.vang = vang;
    }

    public boolean isDiTre() {
        return diTre;
    }

    public void setDiTre(boolean diTre) {
        this.diTre = diTre;
    }

    public int getGioTangCa() {
        return gioTangCa;
    }

    public void setGioTangCa(int gioTangCa) {
        this.gioTangCa = gioTangCa;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getNoiDungTienPhat() {
        return noiDungTienPhat;
    }

    public void setNoiDungTienPhat(String noiDungTienPhat) {
        this.noiDungTienPhat = noiDungTienPhat;
    }
    
    
    
        
}
