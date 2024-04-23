package ptud.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import DAO_Implement.DAOCongDoan;
import DAO_Implement.DAOCongNhan;
import DAO_Interface.IDAOCongDoan;
import DAO_Interface.IDAOCongNhan;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author KHANH
 */
@Entity
@Table(name = "ChiTietPhanCong")
public class ChiTietPhanCong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2758189337952382367L;
	@Id
	@Column(name = "maCTPC", columnDefinition = "VARCHAR(50)", nullable = false)
	private String maCTPC;
	@Column(columnDefinition = "DATE")
	private LocalDate ngay;
	@Column(nullable = true)
	private int soLuongCDGiao;

	// ChiTietPhanCong has one CongNhan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCN")
	private CongNhan congNhan;

	// ChiTietPhanCong has one CongDoan
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCD")
	private CongDoan congDoan;

//	 ChiTietPhanCong has many PhieuChamCongCongNhan
	@OneToMany(mappedBy = "chiTietPhanCong")
	private Set<PhieuChamCongCongNhan> phieuChamCongCongNhans;
	@Transient
	private String maCD;
	@Transient
	private String maCN;

	public ChiTietPhanCong() {
	};
	
	@Transient
	private IDAOCongDoan daoCongDoan;
	@Transient
	private IDAOCongNhan  daoCongNhan;

    public ChiTietPhanCong(String maCTPC, String maCD, String maCN, LocalDate ngay, int soLuongCDGiao) {
    	try {
			daoCongDoan = new DAOCongDoan();
	    	daoCongNhan = new DAOCongNhan();
	    	
	    	this.congDoan = daoCongDoan.get(maCD);
	    	this.congNhan = daoCongNhan.timKiemCongNhan(maCN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setMaCD(maCD);
        setMaCN(maCN);
        setMaCTPC(maCTPC);
        setNgay(ngay);
        setSoLuongCDGiao(soLuongCDGiao);
    }

    public String getMaCTPC() {
        return maCTPC;
    }

    public void setMaCTPC(String maCTPC) {
        this.maCTPC = maCTPC;
    }

    public String getMaCD() {
        return congDoan.getMaCD();
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getMaCN() {
        return congNhan.getMaCN();
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public int getSoLuongCDGiao() {
        return soLuongCDGiao;
    }

    public void setSoLuongCDGiao(int soLuongCDGiao) {
       this.soLuongCDGiao = soLuongCDGiao;
    }

    @Override
    public String toString() {
        return "ChiTietPhanCong{" +
                "maCTPC='" + maCTPC + '\'' +
                ", maCD='" + congDoan.getMaCD() + '\'' +
                ", maCN='" + congNhan.getMaCN() + '\'' +
                ", ngay=" + ngay +
                ", soLuongCDGiao=" + soLuongCDGiao +
                '}';
    }

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 61 * hash + Objects.hashCode(this.maCTPC);
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
		final ChiTietPhanCong other = (ChiTietPhanCong) obj;
		return Objects.equals(this.maCTPC, other.maCTPC);
	}

}
