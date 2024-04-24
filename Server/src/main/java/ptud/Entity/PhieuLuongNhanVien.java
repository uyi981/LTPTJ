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
import DAO_Implement.DAO_NhanVien;
import DAO_Implement.DAO_PhieuChamCongNhanVien;
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
        double phat2 = 0; 
        // xử lý tính toán
 
        return phat2;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    
    public double getPhuCap() throws RemoteException {
    	DAO_NhanVien daoNhanVien = new DAO_NhanVien();
        double PhuCap = daoNhanVien.timKiemNhanVien(maNV).getPhuCap();
        return PhuCap;
    }

    public double getLuong() throws RemoteException  {
    	DAO_NhanVien daoNhanVien = new DAO_NhanVien();
    	double luong = 0;
        // xử lý tính toán
        try {
            luong = new DAO_PhieuChamCongNhanVien().getSoNgayLam(maNV, thang, nam)*daoNhanVien.timKiemNhanVien(maNV).getLuongCoBan()/24;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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