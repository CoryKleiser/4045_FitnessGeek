package com.fitnessgeek.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * This is our Hibernate Utility class
 * This class contains all of the necessary methods to implement hibernation
 */
public class HibernateUtil {
	final static Logger logger = Logger.getLogger(HibernateUtil.class);

    private static final SessionFactory sessionFactory = buildSessionFactory();
    logger.info("INFO: SessionFactory successfully created");

    /**
    * Creates the SessionFactory from hibernate.cfg.xml
    * No input taken
    * @return Returns a new Session Factory Configuration
    * Throws exception
    */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
        	logger.error("ERROR: SessionFactory failed to build", ex);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets the Session Factory 
     * @return returns the SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Close caches and connection pools
     * No return from this method
     */
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
