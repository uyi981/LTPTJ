/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
*
* @author NguyenTrongPhuc
*/

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	
	@Transient
	private String maNV;
   private String userName, matKhau;
   private int vaiTro;
   private boolean trangThai;
   @Id
   @OneToOne(fetch = FetchType.LAZY)
   NhanVien nhanVien;
   
    public TaiKhoan() {
    }

       
    public TaiKhoan(String userName, String maNV, String matKhat, int vaiTro, boolean trangThai) {
        this.userName = userName;
        this.maNV = maNV;
        this.matKhau = matKhat;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhat() {
        return matKhau;
    }

    public void setMatKhat(String matKhat) {
        this.matKhau = matKhat;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
