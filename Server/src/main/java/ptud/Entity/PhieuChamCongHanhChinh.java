/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.time.LocalDate;

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
public class PhieuChamCongHanhChinh {
	@Id
   private String maPCCHC;
    @Transient
   private String maNV;
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
   
   

    public PhieuChamCongHanhChinh(String maPCCHC, String maNV, LocalDate ngay, boolean vang, boolean diTre, int gioTangCa, double tienPhat, String noiDungTienPhat) {
        this.maPCCHC = maPCCHC;
        this.maNV = maNV;
        this.ngay = ngay;
        this.vang = vang;
        this.diTre = diTre;
        this.gioTangCa = gioTangCa;
        this.tienPhat = tienPhat;
        this.noiDungTienPhat = noiDungTienPhat;
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
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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
