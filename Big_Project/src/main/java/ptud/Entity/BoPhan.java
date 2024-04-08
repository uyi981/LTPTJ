/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author KHANH PC
 */
@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "BoPhan")
public class BoPhan {
	@Id
	@Column(name = "maBP", columnDefinition = "VARCHAR(50)", nullable = false)
	private String maBP;
	@Column(columnDefinition = "VARCHAR(30)")
	private String tenBP;
	
	// BoPhan has many NhanVien
	@OneToMany(mappedBy = "boPhan")
	private Set<NhanVien> nhanViens;
	
	// BoPhan has many CongDoan
	@OneToMany(mappedBy = "boPhan")
	private Set<CongDoan> congDoans;
	
	// BoPhan has many CongNhan
	@OneToMany(mappedBy = "boPhan")
	private Set<CongNhan> congNhans; 

    public BoPhan() {
    }

    public BoPhan(String maBP, String tenBP) {
        this.maBP = maBP;
        this.tenBP = tenBP;
    }

    public String getMaBP() {
        return maBP;
    }

    public String getTenBP() {
        return tenBP;
    }

    public void setMaBP(String maBP) {
        this.maBP = maBP;
    }

    public void setTenBP(String tenBP) {
        this.tenBP = tenBP;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
