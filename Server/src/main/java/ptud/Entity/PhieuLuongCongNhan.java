/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Objects;

import DAO_Implement.DAO_CongNhan;
import DAO_Implement.DAO_PhieuChamCongCongNhan;
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
@Table(name = "PhieuLuongCongNhan")

public class PhieuLuongCongNhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261165638034278278L;
	@Id
    private String maPL;     
    private int thang; 
    private int nam; 
    public CongNhan getCongNhan() {
		return congNhan;
	}

	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}

	private double phat; 
    @Column(nullable = true)
     private double luong; 
    @Column(nullable = true)
     private double thuong; 
    @Column(nullable = true)
     private int soNgayLam; 
    @Column(nullable = true)
     private double luongThucNhan; 

    public PhieuLuongCongNhan() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maCN")   
    CongNhan congNhan;

    public PhieuLuongCongNhan(String maPL, int thang, int nam, CongNhan congNhan, double phat) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        this.congNhan = congNhan;
        setPhat(phat);
    }

    public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getThuong() {
		return thuong;
	}

	public void setThuong(double thuong) {
		this.thuong = thuong;
	}

	public int getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public double getLuongThucNhan() {
		return luongThucNhan;
	}

	public void setLuongThucNhan(double luongThucNhan) {
		this.luongThucNhan = luongThucNhan;
	}

	public String getMaPL() {
        return maPL;
    }

    public void setMaPL(String maPL) {
        this.maPL = maPL;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getMaCN() {
        return congNhan.getMaCN();
    }

    
    public double getPhat() {
      return 0;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    





    @Override
    public String toString() {
        return "PhieuLuong{" +
                "maPL='" + maPL + '\'' +
                ", thang=" + thang +
                ", nam=" + nam +
                ", phat=" + phat +
              
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.maPL);
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
        final PhieuLuongCongNhan other = (PhieuLuongCongNhan) obj;
        return Objects.equals(this.maPL, other.maPL);
    }    
}
