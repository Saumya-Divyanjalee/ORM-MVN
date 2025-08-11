package config;

import entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() throws HibernateException {
        //xml file read krnn sessionfactory configurations blnwa,because eya thama database ekth ekk interact wenne
// important
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Customer.class);//customer class eka add kra,tiyena class okk me widiyt add krnn
        //thawa class tiyenm me widiyta link krnn
        sessionFactory = configuration.buildSessionFactory();

    }
    //instance eliyt gnn method

    public static FactoryConfiguration getInstance() throws HibernateException {
        return factoryConfiguration == null ?
                factoryConfiguration = new FactoryConfiguration(): factoryConfiguration;

    }

    public Session getSession() throws HibernateException {
        return sessionFactory.openSession(); //aluthin session create krla eliyt denwa
    }
}
