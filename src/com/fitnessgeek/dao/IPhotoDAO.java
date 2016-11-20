package com.fitnessgeek.dao;

import java.util.List;

import com.fitnessgeek.dto.Photo;

public interface IPhotoDAO {

	void insert(Photo photo);

	List<Photo> fetchPhotos();

}