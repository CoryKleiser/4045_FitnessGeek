package com.fitnessgeek.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileDAO {

	void save(InputStream inputstream, File file) throws IOException;

}