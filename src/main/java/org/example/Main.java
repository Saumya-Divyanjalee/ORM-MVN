package org.example;

import config.FactoryConfiguration;
import entity.Customer;
import entity.FullName;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class Main {


    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = new Customer();
        customer.setName("Saumya");

        FullName fullName = new FullName();
        fullName.setFirstName("Divyanjalee");
        fullName.setLastName("Hello");

        customer.setFullName(fullName);

        Transaction transaction = session.beginTransaction();
//        saveCustomer();
//        getCustomer();
//        mergeCustomer();
//        deleteCustomer();
//          getAllCustomers();

    }

    private static void deleteCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, 1);
        Transaction transaction = session.beginTransaction();
        session.remove(customer);
       // session.delete(customer);
        transaction.commit();// transaction - interface ekk - reference object ekk hadagnnwa, transactions one me dewl manage krgnn
    }

    private static void mergeCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, 1);
        Transaction transaction = session.beginTransaction();
        customer.setName("bob");
       // session.merge(customer);
        transaction.commit();

    }
 private static void getAllCustomers() {
     Session session = FactoryConfiguration.getInstance().getSession();
     Query<Customer> query = session.createQuery("from Customer", Customer.class);
     List<Customer> customerList = query.list();
     customerList.forEach(customer -> System.out.println(customer)
 );


 }



    private static void getCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class,6);
        System.out.println(customer.toString());

    }
    private static void saveCustomer() {
        Session session = FactoryConfiguration.getInstance().getSession();//me method eken thama database create wela table create wenne
        Customer customer = new Customer();
        customer.setName("John");

        //crud ekt me step tika aniwa one
        Transaction transaction = session.beginTransaction();//transaction ekk start krnn one,because transaction base thama database ekk connect wenn puluwn,object eka database ekth ekk map krnn one
        //session though customer object save krnwa

        //session.save(customer);
        //save method eka dn use wenne na, so use krnn me persist method eka, save method eke dewl update wenne na old
        session.persist(customer);

        transaction.commit();
    }
}