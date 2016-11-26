package com.fitnessgeek.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileDAO {
	/**
	 * save a file from one location, to the local server
	 * 
	 * @param activity
	 */
	void save(InputStream inputstream, File file) throws IOException;

}