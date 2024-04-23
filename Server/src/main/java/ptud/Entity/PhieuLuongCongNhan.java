/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Objects;

import DAO_Implement.DAOCongNhan;
import DAO_Implement.DAOPhieuChamCongCongNhan;
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
    @Transient
    private String maCN; 
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

    public PhieuLuongCongNhan(String maPL, int thang, int nam, String maCN, double phat) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        setMaCN(maCN);
        setPhat(phat);
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
        return maCN;
    }

    public void setMaCN(String maCN) {
    	try {
    		this.maCN = maCN;
            DAOCongNhan daoCongNhan = new DAOCongNhan();
            this.congNhan = daoCongNhan.timKiemCongNhan(maCN);
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

    public double getPhat() {
        double phat2 = 0; 
        try {
            phat2 = DAOPhieuChamCongCongNhan.getInstance().getTongTienPhatTrongThang(maCN, thang, nam);
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // xử lý tính toán
        return phat2;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    

    public double getLuong() {
        double luong = 0;
        // xử lý tính toán
        try {
            luong = DAOPhieuChamCongCongNhan.getInstance().getTongTienCongTrongThang(maCN, thang, nam);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return luong;
    }

    public double getThuong() {
        double thuong = 0;
        // xử lý tính toán
        try {
            thuong = DAOPhieuChamCongCongNhan.getInstance().getTongTienCongTrongThang(maCN, thang, nam)*0.15;
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return thuong;
    }


    public int getSoNgayLam() {
        int soNgayLam = 0; 
        // xử lý tính toán
        try {
            soNgayLam = DAOPhieuChamCongCongNhan.getInstance().getSoNgayLam(maCN,  thang, nam);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return soNgayLam;
    }

    public double getLuongThucNhan() {
        double luongThucNhan = 0;
        // xử lý tính toán
        try {
            luongThucNhan = DAOPhieuChamCongCongNhan.getInstance().getTongTienCongTrongThang(maCN, thang, nam) + getThuong() - getPhat();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return luongThucNhan;
    }


    @Override
    public String toString() {
        return "PhieuLuong{" +
                "maPL='" + maPL + '\'' +
                ", thang=" + thang +
                ", nam=" + nam +
                ", maCN='" + maCN + '\'' +
                ", phat=" + phat +
                ", luong=" + getLuong() +
                ", thuong=" + getThuong() +
                ", soNgayLam=" + getSoNgayLam() +
                ", luongThucNhan=" + getLuongThucNhan() +
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
