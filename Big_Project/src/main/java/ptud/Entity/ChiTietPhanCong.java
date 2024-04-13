package ptud.Entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class ChiTietPhanCong {
	@Id
	@Column(name = "maCTPC", columnDefinition = "VARCHAR(50)", nullable = false)
	private String maCTPC;
	@Column(columnDefinition = "DATE")
	private LocalDate ngay;
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
	private String maCD;
	private String maCN;

	public ChiTietPhanCong() {
	};

    public ChiTietPhanCong(String maCTPC, String maCD, String maCN, LocalDate ngay, int soLuongCDGiao) {
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
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getMaCN() {
        return maCN;
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
                ", maCD='" + maCD + '\'' +
                ", maCN='" + maCN + '\'' +
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
