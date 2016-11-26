package com.fitnessgeek.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.fitnessgeek.dto.User;
import com.fitnessgeek.services.IUserService;

@SuppressWarnings("serial")
public class UserJSONServlet extends HttpServlet {

	@Inject
	private IUserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> users = new ArrayList<User>(userService.showAllUsers());

		resp.setContentType("appliction/json");
		PrintWriter writer = resp.getWriter();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();

		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

		for (User user : users) {
			JsonObjectBuilder userBuilder = Json.createObjectBuilder();

			JsonObject userJson = userBuilder.add("email", user.getEmail() != null ? user.getEmail() : "")
					.add("firstName", user.getFirstName() != null ? user.getFirstName() : "")
					.add("lastName", user.getLastName() != null ? user.getLastName() : "")
					.add("password", user.getPassword() != null ? user.getPassword() : "")
					.add("userHeight", user.getUserHeight()).add("userFeet", user.getUserHeightFeet())
					.add("userInches", user.getUserHeightInches()).add("userId", user.getUserId())
					.add("userName", user.getUserName() != null ? user.getUserName() : "")
					.add("userWeight", user.getUserWeight()).build();

			arrayBuilder.add(userJson);
		}
		JsonObject root = rootBuilder.add("users", arrayBuilder).build();
		writer.print(root);
		writer.flush();
		writer.close();
	}

}
