package com.fitnessgeek.dao;

import java.util.List;

import com.fitnessgeek.dto.Photo;

public interface IPhotoDAO {
	/**
	 * insert a photo to the database
	 * 
	 * @param activity
	 */
	void insert(Photo photo);

	/**
	 * get all photos from the database
	 * 
	 * @param activity
	 */
	List<Photo> fetchPhotos();

}