/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import ptud.DAO.DAO_CongNhan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.Set;
/**
 *
 * @author TomTom
 */
@jakarta.persistence.Entity
public class CongNhan {
	@Id
    private String maCN;
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
	@JoinColumn(name = "maBP")
    private BoPhan boPhan;
    private String ten;
    private boolean gioiTinh;
    @Column(name = "ngaySinh",columnDefinition = "DATE")
    @Transient
    private LocalDate ngaySinh;
    
    @Column(name = "ngayBatDauLam",columnDefinition = "DATE")
    @Transient
    private Date ngayBatDauLam1;
    @Transient
    private LocalDate ngayBatDauLam;
    private String cccd;
    private String dienThoai;
    private boolean trangThai;
    @Column(columnDefinition = "VARBINARY(MAX)")
    private byte[] avatar;
    private boolean choPhanCong;
    @OneToMany(mappedBy = "congNhan")
    Set<BangDanhGiaCongNhan> bangDanhGiaCongNhans;
    @OneToMany(mappedBy = "congNhan")
    Set<ChiTietPhanCong> chiTietPhanCongs;
    @OneToMany(mappedBy = "congNhan")
    Set<PhieuLuongCongNhan> phieuLuongCongNhans;
    public String getMaCN() {
        return maCN;
    }
    
    public BoPhan getBoPhan() {
    	return boPhan;
    }

    public String getTen() {
        return ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public LocalDate getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public String getCccd() {
        return cccd;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public boolean isChoPhanCong() {
        return choPhanCong;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }
    
    public void setBoPhan(BoPhan boPhan) {
    	this.boPhan = boPhan;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayBatDauLam(LocalDate ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public void setChoPhanCong(boolean choPhanCong) {
        this.choPhanCong = choPhanCong;
    }

    public CongNhan(String maCN, BoPhan boPhan, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar, boolean choPhanCong) {
        this.maCN = maCN;
        this.boPhan = boPhan;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayBatDauLam = ngayBatDauLam;
        this.cccd = cccd;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
        this.avatar = avatar;
        this.choPhanCong = choPhanCong;
    }

    public CongNhan(BoPhan boPhan, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar, boolean choPhanCong) {
        this.maCN = genMaCN(boPhan, ngayBatDauLam, gioiTinh);
        this.boPhan = boPhan;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayBatDauLam = ngayBatDauLam;
        this.cccd = cccd;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
        this.avatar = avatar;
        this.choPhanCong = choPhanCong;
    }

    
    public CongNhan() {
    }
    
    
    private String genMaCN(BoPhan boPhan, LocalDate ngayBatDauLam, boolean gioiTinh) {
        DAO_CongNhan daoConNhan = new DAO_CongNhan().getInstance();
        int count = daoConNhan.countAll();

        // Sử dụng DateTimeFormatter để lấy hai số cuối của năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String lastTwoDigitsOfYear = ngayBatDauLam.format(formatter);

        // Kết hợp mã NV với số lượng và giới tính
        return String.format("%s%s%s%03d", boPhan.getMaBP(),lastTwoDigitsOfYear, gioiTinh?"1":0, count++) ;
    }

    @Override
    public String toString() {
        return "CongNhan{" + "maCN=" + maCN + "boPhan" + boPhan.toString() + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayBatDauLam=" + ngayBatDauLam + ", cccd=" + cccd + ", dienThoai=" + dienThoai + ", trangThai=" + trangThai + ", avatar=" + avatar + ", choPhanCong=" + choPhanCong + '}';
    }

    
}
