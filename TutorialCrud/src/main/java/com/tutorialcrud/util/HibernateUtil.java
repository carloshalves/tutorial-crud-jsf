package com.tutorialcrud.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            ///Cria um sessionFactory a partir do hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure();
            
           // ServiceRegistry serviceRegistry = ((Object) new ServiceRegistryBuilder()
           //		.applySettings(configuration.getProperties())).build();
            
            //SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	return sessionFactory;
            //Original eram essas duas linhas corrigidas da linha 17 a 23
        	//return new Configuration().configure().buildSessionFactory(
			  //  new StandardServiceRegistryBuilder().build() );
        }
        catch (Throwable ex) {
            // Exibe uma mensagem de erro 
            System.err.println("Falha ao tentar criar o SessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
