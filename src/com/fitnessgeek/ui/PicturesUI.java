package com.fitnessgeek.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import com.fitnessgeek.dto.Photo;
import com.fitnessgeek.services.IUserService;
@Named
@ManagedBean
@Scope("session")
public class PicturesUI {
	
	@Inject
	private Photo photo;
	
	@Inject
	private IUserService userService;
	
	
	private UploadedFile file;
	
	private List<Photo> photos;
	
	
	public void upload() {
		if (getFile() != null) {
			try {
				InputStream inputstream = getFile().getInputstream();

				userService.savePhoto(getPhoto(), inputstream);

				FacesMessage message = new FacesMessage("Succesful", getFile().getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Fail", getFile().getFileName() + " not uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessage message = new FacesMessage("Fail", getFile().getFileName() + " not uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
		
		
	}

	public void loadPicutres(){
		setPhotos(userService.fetchPhotos());
	}

	public Photo getPhoto() {
		return photo;
	}


	public void setPhoto(Photo photo) {
		this.photo = photo;
	}


	public List<Photo> getPhotos() {
		return photos;
	}


	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
}
