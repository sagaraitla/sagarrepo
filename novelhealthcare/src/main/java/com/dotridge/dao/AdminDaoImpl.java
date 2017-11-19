package com.dotridge.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;
import com.dotridge.util.SessionFactoryUtil;
	
@Repository
public class AdminDaoImpl implements AdminDao {

	public Admin addAdmin(Admin admin) {
		System.out.println("AdminDaoImpl:addAdmin()");
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction =session.beginTransaction();
		session.save(admin);
		trasaction.commit();
		session.close();
		return admin;

	}

	public boolean deleteAdmin(int adminId) {
		System.out.println("AdminDaoImpl:deleteAdmin()");
		boolean flag = false;
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction trasaction = session.beginTransaction();
		Admin admin =(Admin)session.get(Admin.class, adminId);
		session.delete(admin); 
		trasaction.commit();
		admin =(Admin)session.get(Admin.class, adminId);
		if(admin==null){
			flag=true;
		}
		return flag;
	}

	public String activateAdmin(int adminId) {
			SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
			Session session = sessionFactory.openSession();
			Admin admin =(Admin)session.load(Admin.class, adminId);
			admin.setStatus("Active");
			session.update(admin);
			session.close();
			return admin.getStatus();
	}

	public String inactivateAdmin(int adminId) {
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Admin admin =(Admin)session.load(Admin.class, adminId);
		admin.setStatus("Inactive");
		session.update(admin);
		session.close();
		return admin.getStatus();
	}

	public List<Admin> getAllAdmins() {
		System.out.println("AdminDaoImpl:getAllAdmins()");
		SessionFactory sessionFactory=SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Admin");
		List<Admin> listOfAdmins =query.list();
		session.close();
		return listOfAdmins;
		
	}

	public Admin getAdminById(int adminId) {
		System.out.println("AdminDaoImpl:getAdminById()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		// Hospital hospital = (Hospital) session.load(Hospital.class,
		// hospitalId);
		Admin admin = (Admin) session.get(Admin.class, adminId);
		session.close();
		return admin;
	}

	public Admin updateAdmin(Admin admin) {
		System.out.println("AdminDaoImpl:updateAdmin()");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(admin);
		transaction.commit();
		session.close();
		return admin;
	}

	public List<Admin> searchAdminByFirstName(String adminFirstName) {
		System.out.println("AdminDaoImpl:searchAdminByFirstName(-)");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		//String hqlQuery="from Hospital";
		//String hqlQuery="from Hospital h where h.hospitalName like=hName";
		String hqlQuery="from Admin a where a.firstName like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+adminFirstName+"%");
		List<Admin> adminList = query.list();
		System.out.println("size---> "+adminList.size());
		return adminList;
	}

	public List<Admin> searchAdminByEmail(String email) {
		System.out.println("AdminDaoImpl:searchAdminByEmail(-)");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Admin a where a.email like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+email+"%");
		List<Admin> adminList = query.list();
		System.out.println("size---> "+adminList.size());
		return adminList;
	}

	public List<Admin> searchAdminByPhone(long phone) {
		System.out.println("AdminDaoImpl:searchAdminByPhone(-)");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Admin a where a.phone like:aphone";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("aphone", phone);
		List<Admin> adminList = query.list();
		System.out.println("size---> "+adminList.size());
		return adminList;
	}

	public List<Admin> searchAdminByStatus(String status) {
		System.out.println("AdminDaoImpl:searchAdminByStatus(-)");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		String hqlQuery="from Admin a where a.status like ?";
		Query query = session.createQuery(hqlQuery);
		query.setParameter(0, "%"+status+"%");
		List<Admin> adminList = query.list();
		System.out.println("size---> "+adminList.size());
		return adminList;
	}
	
	public List<Admin> getAllAdminByPaging(int currentPage, int noOfRecordsByPage) {

		System.out.println("AdminDaoImpl:searchAdminByPaging(-)");
		SessionFactory sessionFactory = SessionFactoryUtil.getInstance();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Admin");
		query.setFirstResult((currentPage - 1) * noOfRecordsByPage);
		query.setMaxResults(noOfRecordsByPage);
		List<Admin> adminList = query.list();
		return adminList;
	}

}
