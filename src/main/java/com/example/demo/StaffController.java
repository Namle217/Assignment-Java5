package com.example.demo;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Depart;
import com.example.demo.entity.Record;
import com.example.demo.entity.Staff;

import ch.qos.logback.core.Context;

@Controller
@Transactional
@RequestMapping("/QLNV/")
public class StaffController {
	@Autowired
	EntityManagerFactory factory;

	private Session getCurrentSession() {
		return factory.unwrap(SessionFactory.class).openSession();
	}
	@Autowired
	ServletContext context;
	//list nhân viên
	@RequestMapping( value = "list", method = RequestMethod.GET)
	public String listStaff(ModelMap model, @ModelAttribute("staff") Staff staff,HttpSession httpSession) {
//		if(httpSession.getAttribute("admin")==null) {
//			 
//			return "redirect:/home/login";
//		}

		Session session = getCurrentSession();
		String hql = "SELECT s.id, s.name, s.depart.name"+
		" from Staff s "+
				"join Depart d on s.depart.id = d.id"

				;
		Query q = session.createQuery(hql);
		List<Object> list = q.list();
		model.addAttribute("list", list);
		return "admin/QLNV";
	}

	//hiện thị thông tin 1 nv
//	@RequestMapping( value = "info{id}")
//	public String infoStaff(ModelMap model, @PathVariable("id") String id,HttpSession httpSession) {
//		Staff staff = null;
//		Session session = getCurrentSession();
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
//		try {
//			staff= session.get(Staff.class, id);
//			transaction.commit();
//			httpSession.setAttribute("staffid", id);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		model.addAttribute("staffs", staff);
//		return "admin/HSNV";
//		
//		
//	}
	
	
	//Thêm
	@RequestMapping(value = "insert",params = "btn_Insert")
	public String Getinsert(ModelMap model){
		model.addAttribute("staff", new Staff());
		return "admin/CreateNV";
	}
	
	@PostMapping(value = "insert",params = "btnInsert")
	public String Insert(ModelMap model, @RequestParam("photo1") MultipartFile photo1,@ModelAttribute("staff") Staff staff){
		
		if(photo1.isEmpty()) {
			model.addAttribute("mess", "Vui Lòng Chọn Ảnh");
			return "admin/CreateNV";
		}else {
			try {
				String photo_path = context.getRealPath("/files/"+photo1.getOriginalFilename());
				photo1.transferTo(new File(photo_path));
				Session session = getCurrentSession();
				Transaction transaction = session.getTransaction();
				transaction.begin();
				staff.setPhoto(photo1.getOriginalFilename());
				session.save(staff);
				transaction.commit();
				model.addAttribute("mess", "THÊM THÀNH CÔNG");
				
				
				
			} catch (Exception e) {
				model.addAttribute("mess", "THÊM THẤT BẠI");
			}
			return"admin/CreateNV";
			
		}
		
		
		
	}
	
	
	//Xóa
	@RequestMapping(value = "delete{id}")
	public String Delete(ModelMap model, @PathVariable("id") String id) {
		Staff staff = null;
		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			staff = session.get(Staff.class, id);
			session.delete(staff);
			transaction.commit();
			model.addAttribute("mess", "XÓA THÀNH CÔNG");
			

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mess", "XÓA THẤT BẠI");
		}
		
		return "redirect:/QLNV/list";
	}
	//Cập nhật
	
	@RequestMapping(value = "Update", params = "btnUpdate", method = RequestMethod.POST)
	public String Update(ModelMap model, @RequestParam("photo1") MultipartFile photo1,@ModelAttribute("staff") Staff staff,HttpSession httpSession) {
		
		
			
			try {
				String photo_path = context.getRealPath("/files/"+photo1.getOriginalFilename());
				photo1.transferTo(new File(photo_path));
				
				try {
					Session session = getCurrentSession();
					Transaction transaction = session.getTransaction();
					transaction.begin();
					staff.setPhoto(photo1.getOriginalFilename());
					session.update(staff);
					transaction.commit();
					model.addAttribute("mess", "CẬP NHẬT THÀNH CÔNG");
					
				}
				
				catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("mess", "CẬP NHẬT THẤT BẠI");
				}
				
				
			} catch (Exception e) {
				try {
					Session session = getCurrentSession();
					Transaction transaction = session.getTransaction();
					transaction.begin();
					session.update(staff);
					transaction.commit();
					model.addAttribute("mess", "CẬP NHẬT THÀNH CÔNG");
					
				}
				
				catch (Exception e1) {
					e1.printStackTrace();
					model.addAttribute("mess", "CẬP NHẬT THẤT BẠI");
				}
				
				
			}
		
		 
		
		return "admin/HSNV";
		

	}
	
	@RequestMapping(value = "update{id}")
	public String btnUpdate(ModelMap model, @PathVariable("id") String id) {
		Staff staff = null;
		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		try {
			staff = session.get(Staff.class, id);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("staff", staff);
		return "admin/HSNV";
	}


	
	
	
	//Thêm Thành Tích
	@RequestMapping("insertR{id}")
		public String insertR(ModelMap model, @PathVariable("id") String id) {
			Staff staff = null;
			Session session = getCurrentSession();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			try {
				staff = session.get(Staff.class, id);
				
				transaction.commit();
				
				

			} catch (Exception e) {
				e.printStackTrace();
				
			}
			Record record = new Record();
			record.setStaff(staff);
			model.addAttribute("record", record);
			model.addAttribute("staff1", staff);
			return "admin/AddTT";
		}
	@PostMapping(value = "insertR",params = "btnInsert")
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
	
	//Combo Depart
	@ModelAttribute("listPB")
	public List<Depart> getDeparts(){
		Session session = getCurrentSession();
		String hql = "from Depart";
		Query q = session.createQuery(hql);
		List<Depart> list = q.list();
		return list;
 	}
}
