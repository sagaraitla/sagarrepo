package novelhealthcare;

import java.io.File;

import com.dotridge.dao.HospitalDao;
import com.dotridge.dao.HospitalDaoImpl;
import com.dotridge.domain.Hospital;

public class HospitalTest {

	public static void main(String[] args) {
		
		HospitalDao hospitalDao = new HospitalDaoImpl();
		Hospital hospital = new Hospital();
		hospital.setHospitalName("KKK");
		hospital.setAddress1("ekajfk");
		hospital.setCity("hyd");
		hospital.setEmail("yah@gmail.com");
		hospital.setPhone(4545);
		hospital.setState("TS");
		hospital.setLogo(new File("logo"));
		hospital.setStatus("inactive");
		hospitalDao.addHospital(hospital);
		
		
		//hospitalDao.inactivateHospital(4);
		
		/*boolean flag =hospitalDao.deleteHospital(3);
		System.out.println("Is patient deleted?"+flag);*/
		
	}
}
