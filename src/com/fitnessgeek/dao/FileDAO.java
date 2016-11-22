package com.fitnessgeek.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Named;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@Named
public class FileDAO implements IFileDAO {

	/* (non-Javadoc)
	 * @see com.fitnessgeek.dao.IFileDAO#save(java.io.InputStream, java.io.File)
	 */
	@Override
	public void save(InputStream inputstream, File file) throws IOException{
		OutputStream output = new FileOutputStream(file);
		IOUtils.copy(inputstream, output);
		output.flush();
		output.close();
	}
}
