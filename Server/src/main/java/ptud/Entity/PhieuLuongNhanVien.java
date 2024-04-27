/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.io.Serializable;
import java.rmi.RemoteException;

import java.util.Objects;
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
@Table(name = "PhieuLuongNhanVien")

public class PhieuLuongNhanVien implements Serializable {
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

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9103520691142499119L;
	@Id
    private String maPL;   
    private int thang; 
    private int nam; 
    @Transient
    private String maNV; 
    private double phat; 
    @Column(nullable = true)
     private double phuCap; 
    @Column(nullable = true)
     private double luong;
    @Column(nullable = true)
     private double thuong; 
    @Column(nullable = true)
     private int soNgayLam; 
    @Column(nullable = true)
     private double luongThucNhan; 

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNV")
    
    
    NhanVien nhanVien;
    
    

    public PhieuLuongNhanVien() {
    }

    public PhieuLuongNhanVien(String maPL, int thang, int nam, NhanVien nhanVien, double phat) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        setPhat(phat);
        this.nhanVien = nhanVien;
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

    public String getMaNV() {
        return nhanVien.getMaNV();
    }


    public double getPhat() {
        return phat;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    
    public double getPhuCap() throws RemoteException {
        return phuCap;
    }

    public double getLuong() throws RemoteException  {   
      return luong;
    }



    



    @Override
    public String toString() {

            try {
				return "PhieuLuong{" +
				        "maPL='" + maPL + '\'' +
				        ", thang=" + thang +
				        ", nam=" + nam +
				        ", maNV='" + maNV + '\'' +
				        ", phat=" + phat +
				        ", luong=" + getLuong() +
				       
				        '}';
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return maNV;
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
        final PhieuLuongNhanVien other = (PhieuLuongNhanVien) obj;
        return Objects.equals(this.maPL, other.maPL);
    }    
}


// CREATE TABLE PhieuLuongNhanVien (
// 	maPL VARCHAR(20) PRIMARY KEY,
//     thang INT,
//     nam INT,
//     maNV VARCHAR(20),
//     maNV VARCHAR(20),
//     phat FLOAT(10),
//     luong FLOAT(10),
//     thuong FLOAT(10),
//     soNgayLam INT,
//     luongThucNhan FLOAT(10),
//     FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
//     FOREIGN KEY (maNV) REFERENCES CongNhan(maNV)
// );