package com.example.demo;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Depart;
import com.example.demo.entity.Staff;
import com.example.demo.entity.User;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@Transactional
//@ImportResource(locations = {"classpath:/com/example/demo/bean/mvc-dispatcher.xml"})
@RequestMapping(value = "/QLPB/")
public class DepartController {
	@Autowired
	EntityManagerFactory factory;

	private Session getCurrentSession() {
		return factory.unwrap(SessionFactory.class).openSession();
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listDepart(ModelMap model, @ModelAttribute("depart") Depart depart,HttpSession httpSession) {
//		if(httpSession.getAttribute("admin")==null) {
//			
//			return "redirect:/home/login";
//		}

		Session session = getCurrentSession();
		String hql = "from Depart";
		Query q = session.createQuery(hql, Depart.class);
		List<Depart> list = q.list();
		model.addAttribute("list", list);
		return "admin/QLPB";

	}

	@RequestMapping(value = "list", method = RequestMethod.POST, params = "btnInsert")
	public String btnInsert() {
		return "admin/CreatePB";
	}

	@RequestMapping(value = "update{id}")
	public String btnUpdate(ModelMap model, @PathVariable("id") String id) {
		Depart depart = null;
		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			depart = session.get(Depart.class, id);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("depart", depart);
		return "admin/UpdatePB";
	}
//SỬA
	@RequestMapping(value = "Update", params = "update", method = RequestMethod.POST)
	public String Update(ModelMap model, @ModelAttribute("depart") Depart depart) {

		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			session.update(depart);
			transaction.commit();
			model.addAttribute("mess", "CẬP NHẬT THÀNH CÔNG");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mess", "CẬP NHẬT THẤT BẠI");
		} 
		
		finally {
			session.close();
		}
		return "admin/UpdatePB";

	}
	//XÓA
	@RequestMapping(value = "delete{id}")
	public String Delete(ModelMap model, @PathVariable("id") String id) {
		Depart depart = null;
		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			depart = session.get(Depart.class, id);
			session.delete(depart);
			transaction.commit();
			model.addAttribute("mess", "XÓA THÀNH CÔNG");
			

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mess", "XÓA THẤT BẠI");
		}
		
		return "redirect:/QLPB/list";
	}
	
	//THÊM
	@RequestMapping(value = "insert",params = "btn_Insert")
	public String Getinsertss(ModelMap model){
		model.addAttribute("depart", new Depart());
		return "admin/CreatePB";
	}

	
	

	@PostMapping(value = "insert",params = "btnInsert")
	public String Insert(ModelMap model,@ModelAttribute("depart") Depart depart) {
		Session session = getCurrentSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		try {
			session.save(depart);
			tran.commit();
			model.addAttribute("mess", "THÊM THÀNH CÔNG");
		} catch (Exception e) {
			tran.rollback();
			model.addAttribute("mess", "THÊM THẤT BẠI");
		}
		finally {
			session.close();
		}
		return "admin/CreatePB";
		
	}
	
}
