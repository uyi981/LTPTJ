package ptud.Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import DAO_Implement.DAO_NhanVien;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TomTom
 */
@Entity
public class NhanVien implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6305668314033284816L;
	@Id
    private String maNV;
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
	@jakarta.persistence.JoinColumn(name = "maBP")
    private BoPhan boPhan;
	@Column(name = "tenNV",columnDefinition = "NVARCHAR(100)")
    private String ten;
    private boolean gioiTinh;
    @Column(name = "ngaySinh",columnDefinition = "DATE")
    private LocalDate ngaySinh;
    @Column(name = "ngayBatDauLam",columnDefinition = "DATE")
    private LocalDate ngayBatDauLam;
    @Column(name = "CCCD")
    private String cccd;
    private String dienThoai;
    private boolean trangThai;
    @Column(name ="hinhAnh",columnDefinition = "VARBINARY(MAX)"
    		,nullable = true)
    private byte[] avatar;
    private double luongCoBan;
    private double phuCap;
    @OneToMany(mappedBy = "nhanVien")
    Set<BangDanhGiaNhanVien> bangDanhGiaNhanViens;
    @OneToMany(mappedBy = "nhanVien")
    Set<PhieuChamCongHanhChinh>chamCongHanhChinhs;
    @OneToMany(mappedBy = "nhanVien")
    Set<PhieuLuongNhanVien> nhanViens;
    @OneToOne(mappedBy = "nhanVien")
    TaiKhoan taiKhoan;
    
    public String getMaNV() {
        return maNV;
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

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public NhanVien(String maNV, BoPhan boPhan, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar, double luongCoBan, double phuCap) {
        this.maNV = maNV;
        this.boPhan = boPhan;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayBatDauLam = ngayBatDauLam;
        this.cccd = cccd;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
        this.avatar = avatar;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    public NhanVien(BoPhan boPhan, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar, double luongCoBan, double phuCap) throws Exception{
        this.maNV = genMaNV(boPhan, ngayBatDauLam, gioiTinh);
        this.boPhan = boPhan;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayBatDauLam = ngayBatDauLam;
        this.cccd = cccd;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
        this.avatar = avatar;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    private String genMaNV(BoPhan boPhan,LocalDate ngayBatDauLam, boolean gioiTinh) throws Exception {
        DAO_NhanVien daoNhanVien = new DAO_NhanVien();
        int count = daoNhanVien.countAll();

        // Sử dụng DateTimeFormatter để lấy hai số cuối của năm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String lastTwoDigitsOfYear = ngayBatDauLam.format(formatter);

        // Kết hợp mã NV với số lượng và giới tính
        return String.format("%s%s%s%03d", boPhan.getMaBP(), lastTwoDigitsOfYear, gioiTinh?"1":0, count++) ;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", boPhan="  + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayBatDauLam=" + ngayBatDauLam + ", cccd=" + cccd + ", dienThoai=" + dienThoai + ", trangThai=" + trangThai + ", avatar=" + avatar + ", luongCoBan=" + luongCoBan + ", phuCap=" + phuCap + '}';
    }

}
