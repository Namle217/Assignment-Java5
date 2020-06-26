package com.example.demo;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Depart;
import com.example.demo.entity.User;

@org.springframework.stereotype.Controller
@Configuration
@ImportResource(locations = {"classpath:/com/example/demo/bean/mvc-dispatcher.xml"})
@RequestMapping("/home/")
public class UserController {
	@Autowired
	EntityManagerFactory factory;
	private Session getCurrentSession() {
		return factory.unwrap(SessionFactory.class).openSession();
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPOST(ModelMap model, @ModelAttribute("user") User user,HttpSession httpSession) {
		
		User u = null;
		Session session = getCurrentSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
	try {
		  u=session.get(User.class, user.getUsername());
		transaction.commit();
		if(u.getPassword().equals(user.getPassword())){
			if(u.getIsAdmin()) {
				httpSession.setAttribute("admin", u);
				
				return "admin/Home";
			}else {
				httpSession.setAttribute("user", u);
				return "user/Home";
			}
		}else {
			model.addAttribute("message", "Account is Incorrect");
			httpSession.invalidate(); //xoa toan bo sesson tồn tại
			
			return "login/login";
		}
			
		
	} catch (Exception e) {
		e.printStackTrace(); // in lỗi ở console
	}
		
		return "login/login";
	}
		
		
		
		
		
		
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String loginGET(ModelMap model) {
		model.addAttribute("user",new User());
		return "login/login";
	}
	
	
	
	@ModelAttribute("top10")
	public List<Object[]> getTop10(){
		Session session = getCurrentSession();
		String hql = "SELECT r.staff.name,"
				+" r.staff.depart.name,"
				+" r.staff.photo,"
				+" SUM(case when r.type=1 then 1 else 0 end)- SUM(case when r.type=0 then 1 else 0 end) AS T"
				
				+" from Record r"
				
				+" GROUP BY r.staff.depart.name, r.staff.name, r.staff.photo"
				+" ORDER BY T DESC";
		
		
		
		Query q = session.createQuery(hql).setMaxResults(10);
		List<Object[]> list = q.list();
		return list;
 	}
	
	

	
}
