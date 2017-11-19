package com.dotridge.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Hospital addHospital(Hospital hostpital) {
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		session.save(hostpital);
		trasaction.commit();
		session.close();
		return hostpital;
	}

	public boolean deleteHospital(int hospitalId) {
		boolean flag = false;
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		Hospital hospital = (Hospital) session.get(Hospital.class, hospitalId);
		session.delete(hospital);
		trasaction.commit();
		hospital = (Hospital) session.get(Hospital.class, hospitalId);
		if (hospital == null) {
			flag = true;
		}
		return flag;
	}

	public String activateHospital(int hospitalId) {
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Hospital hospital = (Hospital) session.load(Hospital.class, hospitalId);
		hospital.setStatus("active");
		session.update(hospital);
		session.close();
		return hospital.getStatus();
	}

	public String inactivateHospital(int hospitalId) {
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Hospital hospital = (Hospital) session.load(Hospital.class, hospitalId);
		hospital.setStatus("Inactive");
		session.update(hospital);
		session.close();
		return hospital.getStatus();
	}

	public List<Hospital> getAllHospital() {
		System.out.println("HospitalDaoImpl:getAllHospital()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Hospital");
		List<Hospital> listOfHospitals = query.list();
		System.out.println("Hospital list size "+listOfHospitals.size());
		session.close();
		return listOfHospitals;
	}

	public Hospital getHospitalById(int hospitalId) {
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		// Hospital hospital = (Hospital) session.load(Hospital.class,
		// hospitalId);
		Hospital hospital = (Hospital) session.get(Hospital.class, hospitalId);
		session.close();
		return hospital;
	}

	public Hospital updateHospital(Hospital hostpital) {
		System.out.println("DAO:updateHospital");
		System.out.println("Hospital Domain" + hostpital);
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(hostpital);
		transaction.commit();
		session.close();
		return hostpital;
	}

	public List<Hospital> getAllHospitalByPaging(int currentPage, int noOfRecordsByPage) {

		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Hospital");
		query.setFirstResult((currentPage - 1) * noOfRecordsByPage);
		query.setMaxResults(noOfRecordsByPage);
		List<Hospital> hospitalList = query.list();
		return hospitalList;
	}

	public Hospital getHospitalByName(String hospitalName) {
		
		System.out.println("HospitalDaoImpl:getHospitalForName(-)");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		
		String hql="from Hospital hosp where hosp.hospitalName=:hospName";
		Query query = session.createQuery(hql);
		query.setParameter("hospName", hospitalName);
		Hospital hospital =(Hospital)query.uniqueResult();
		System.out.println("HospitalName:"+hospital);
		return hospital;
	}
	
	public List<Hospital> getAllHospitalForDropDownAdmin() {
		System.out.println("HospitalDaoImpl:getAllHospitalForDropDownAdmin()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT hospitalName hospName FROM Hospital");
		sqlQuery.addEntity(Hospital.class);
		
		//Query query = session.createQuery("from Hospital hosp DISTINCT hosp.ho ");
		//List<Hospital> listOfHospitals = query.list();
		return null;
	}
	

	public List<Hospital> searchHospitalByName(String hospitalName) {
		System.out.println("HospitalDaoImpl:searchHospitalByName()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		//String hqlQuery="from Hospital";
		//String hqlQuery="from Hospital h where h.hospitalName like=hName";
		String hqlQuery="from Hospital h where h.hospitalName like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+hospitalName+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByEmail(String email) {
		System.out.println("HospitalDaoImpl:searchHospitalByEmail()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.email like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+email+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByAddress1(String address1) {
		System.out.println("HospitalDaoImpl:searchHospitalByAddress1()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.address1 like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+address1+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByPhone(long phone) {
		System.out.println("HospitalDaoImpl:searchHospitalByPhone()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.phone like:hphone";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("hphone", phone);
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}

	public List<Hospital> searchHospitalByStatus(String status) {
		System.out.println("HospitalDaoImpl:searchHospitalByStatus()");
		//SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Hospital h where h.status like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+status+"%");
		List<Hospital> hosptialList = query.list();
		System.out.println("size---> "+hosptialList.size());
		return hosptialList;
	}
	
	public static void main(String[] args) {
		HospitalDaoImpl d = new HospitalDaoImpl();
	//	d.searchHospitalByName("vam");
		//d.searchHospitalByStatus("false");
		d.searchHospitalByAddress1("baj");
		//d.searchHospitalByEmail("k@gmail.com");
		//long val =22133L;
		//Long value =Long.parseLong("22133");
		//d.searchHospitalByPhone(value);
	}
	/*public static void main(String[] args) {
		HospitalDaoImpl doa= new HospitalDaoImpl();
		
		List<Hospital> listOfHospitals = doa.getAllHospitalForDropDownAdmin();
		for (Hospital hospital : listOfHospitals) {
			System.out.println("**********"+hospital);
		}
		
	}*/

}
