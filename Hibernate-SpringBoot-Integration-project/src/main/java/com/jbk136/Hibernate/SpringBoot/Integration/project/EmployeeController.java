package com.jbk136.Hibernate.SpringBoot.Integration.project;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class EmployeeController {

	        @Autowired
	        SessionFactory sf;
	        
	        @RequestMapping("singlesa")
	        public Employee singleRecords() {
	        Session ss = sf.openSession();
	        	Employee e= ss.get(Employee.class, 101);
	    		return e;
	        }
	    	@GetMapping("AllRecordShod")
	    	public List<Employee> AllRecordShow() {
	    		Session session = sf.openSession();

	    		String select = "from Employee";

	    		Query query = session.createQuery(select);
	    		List<Employee> list = query.list();
	    		System.out.println("Employee Table");
	    		for (Employee doctor : list) {
	    			System.out.println(doctor.getId() + " " + doctor.getName());
	    		}
	    		return list;
	    	}
	        @RequestMapping("insert")
	    	public Employee insert() {
	    		
	    		Session ss = sf.openSession();
	    		Transaction tx = ss.beginTransaction();

	    		Employee e = new Employee(101, "raju", 455654455);

	    		ss.save(e);

	    		System.out.println(e);

	    		tx.commit();
	    		
	    		return e;

	    	}
	    	
	    	@RequestMapping("update")
	    	public Employee update() {
	    		
	    		Session ss = sf.openSession();
	    		Transaction tx = ss.beginTransaction();

	    		Employee s = new Employee(101, "Java", 54624568);

	    		ss.update(s);

	    		System.out.println(s);

     		tx.commit();
	    		
	    		return s;

	    	}
	    	
	    	// Non Parameter
	    	// parameter -> @PathVariable/@RequestBody
	    	
	    	
	    	@RequestMapping("delete")
	    	public Employee delete() {
	    		
	    		Session ss = sf.openSession();
	    		Transaction tx = ss.beginTransaction();

	    		Employee e=ss.get(Employee.class,101);

	    		ss.delete(e);

	    		System.out.println(e);

	    		tx.commit();
	    		
	    		return e;
	    	
	    	}
	    		

	    	
	    	      
}
