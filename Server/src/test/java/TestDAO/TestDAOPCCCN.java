package TestDAO;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import DAO_Implement.DAOPhieuChamCongCongNhan;
import DAO_Implement.DAOPhieuChamCongNhanVien;
import ptud.Entity.PhieuChamCongCongNhan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestDAOPCCCN {
	DAOPhieuChamCongCongNhan daoPCCCN;

	PhieuChamCongCongNhan PCCCN = 
			new PhieuChamCongCongNhan(null, null, null, false, 0, null, null, 0, 0, 0, 0);
	
	
	
	
	
}
