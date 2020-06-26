package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Depart;
import com.example.demo.entity.Record;
import com.example.demo.entity.Staff;

@Controller
@Transactional
@RequestMapping("/Record/")
public class RecordController {
	
	@Autowired
	EntityManagerFactory factory;

	private Session getCurrentSession() {
		return factory.unwrap(SessionFactory.class).openSession();
	}
	//tHÊM
	@RequestMapping(value = "insert",method = RequestMethod.GET)
	public String Getinsert(ModelMap model){
		model.addAttribute("record", new Record());
		return "admin/CreateTT";
	}
	
	
	
	@PostMapping(value = "insert",params = "btnInsert")
	public String Insert(ModelMap model,@ModelAttribute("record") Record record) {
		Session session = getCurrentSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		try {
			record.setDate(new Date());
			session.save(record);
			tran.commit();
			model.addAttribute("mess", "THÊM THÀNH CÔNG");
		} catch (Exception e) {
			tran.rollback();
			model.addAttribute("mess", "THÊM THẤT BẠI");
		}
		finally {
			session.close();
		}
		return "admin/CreateTT";
		
	}
	
	//Combo Staff
		@ModelAttribute("listNV")
		public List<Staff> getDeparts(){
			Session session = getCurrentSession();
			String hql = "from Staff";
			Query q = session.createQuery(hql);
			List<Staff> list = q.list();
			return list;
	 	}
		
		//tHỐNG KẾ THEO NHÂN VIÊN
		@RequestMapping("toStaff")
		public String RtoStaff(ModelMap model) {
			Session session = getCurrentSession();
			String hql = "SELECT r.staff.id,"
					+" r.staff.name,"
					+" SUM(case when r.type=1 then 1 else 0 end),"
					+" SUM(case when r.type=0 then 1 else 0 end)"
					+" from Record r"
					+" GROUP BY r.staff.id,r.staff.name";
			Query q = session.createQuery(hql);
			List<Object[]> list = q.list();
			model.addAttribute("array", list);
			return "admin/Result";
		}
		//tHỐNG KẾ THEO phòng ban
				@RequestMapping("toDepart")
				public String RtoDepart(ModelMap model) {
					Session session = getCurrentSession();
					String hql = "SELECT r.staff.depart.name,"
							+" r.staff.depart.name,"
							+" SUM(case when r.type=1 then 1 else 0 end),"
							+" SUM(case when r.type=0 then 1 else 0 end)"
							+" from Record r"
							
							+" GROUP BY r.staff.depart.name";
					Query q = session.createQuery(hql);
					List<Object[]> list = q.list();
					model.addAttribute("array", list);
					return "admin/Result2";
				}
				
				//
				
				
				
}
