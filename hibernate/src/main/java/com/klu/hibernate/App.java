package com.klu.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.bytecode.spi.ReflectionOptimizer.AccessOptimizer;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        
        Transaction t;
        
        Employee e1 = new Employee();
        e1.setName("name1");
        e1.setSalary(70000);
        
        
        //HQL
        t = s.beginTransaction();
        s.save(e1);
        //Employee e2 = s.find(Employee.class, 1); 
        //e2.setName("name2");
        //s.update(e2);
        //s.delete(e2);
        t.commit();
        
        System.out.println("CRUD Successfully");
        
        //HCQL
        Criteria c = s.createCriteria(Employee.class);
        c.add(Restrictions.gt("id", 1));
        List<Employee> employees = c.list();
        System.out.println(employees);
        
        //JPQL
        employees = s.createQuery("from Employee e where id > 1", Employee.class).getResultList();
        for (Employee emp : employees) {
      System.out.println(emp);
        }
        
        //Native SQL
        employees = s.createNativeQuery("select * from employee where id > 1", Employee.class).getResultList();
        for (Employee emp : employees) {
      System.out.println(emp);
        }
    }
}