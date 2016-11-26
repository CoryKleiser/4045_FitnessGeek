package com.fitnessgeek.dao;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fitnessgeek.dto.Photo;

@Named
public class PhotoDAO implements IPhotoDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IPhotoDAO#insert(com.fitnessgeek.dto.Photo)
	 */
	@Override
	public void insert(Photo photo) {
		// save user to database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(photo);

		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fitnessgeek.dao.IPhotoDAO#fetchPhotos()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Photo> fetchPhotos() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from Photo");

		@SuppressWarnings("rawtypes")
		List list = query.list();

		List<Photo> photos = list;

		return photos;
	}
}
