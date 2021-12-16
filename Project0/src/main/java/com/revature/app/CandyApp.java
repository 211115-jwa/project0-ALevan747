package com.revature.app;


import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.beans.Candy;
import com.revature.beans.User;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class CandyApp {
	private static UserService userServ = new UserServiceImpl();
	private static EmployeeService empServ = new EmployeeServiceImpl();

	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		app.start();
		
		/*
		 what endpoints do we need?
		 in other words, what actions would a user need to do
		 and what address + HTTP method combo would represent
		 each of those actions?
		 (in your p0, these endpoints are provided to you.)
		*/
		app.routes(() -> {
			// localhost:8080/pets
			path("/candy", () -> {
				get(ctx -> {
					// checking if they did /pets?species=
					String flavorSearch = ctx.queryParam("flavor");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (flavorSearch != null && !"".equals(flavorSearch)) {
						Set<Candy> candyFound = userServ.searchAvailableCandybyFlavor(flavorSearch);
						ctx.json(candyFound);
					} else {
						// if they didn't put ?species
						Set<Candy> availableCandy = userServ.viewAvailableCandy();
						ctx.json(availableCandy);
					}
				});
				post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Candy newCandy = ctx.bodyAsClass(Candy.class);
					if (newCandy !=null) {
						empServ.addNewCandy(newCandy);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				
				// localhost:8080/pets/adopt/8
				//path("/adopt/{id}", () -> {
					//put(ctx -> {
						//try {
							//int userId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							//User newOwner = ctx.bodyAsClass(User.class);
							// returns the person with their new pet added
							//newOwner = userServ.adoptCandy(candyId, newOwner);  //adopt candy?, needs revision
							//ctx.json(newOwner);
						//} catch (NumberFormatException e) {
							//ctx.status(400);
							//ctx.result("Candy ID must be a numeric value");
						//}
					//});
				//});
				
				// localhost:8080/pets/8
				path("/{id}", () -> {
					
					get(ctx -> {
						try {
							int candyId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Candy candy = empServ.getCandyById(candyId);
							if (candy != null)
								ctx.json(candy);
							else
								ctx.status(404);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Candy ID must be a numeric value");
						}
					});
					
					put(ctx -> {
						try {
							int candyId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Candy candyToEdit = ctx.bodyAsClass(Candy.class);
							if (candyToEdit != null && candyToEdit.getId() == candyId) {
								candyToEdit = empServ.editCandy(candyToEdit);
								if (candyToEdit != null)
									ctx.json(candyToEdit);
								else
									ctx.status(404);
							} else {
								// conflict: the id doesn't match the id of the pet sent
								ctx.status(HttpCode.CONFLICT);
							}
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Candy ID must be a numeric value");
						}
					});
					
				});
			});
		});
	}
	

}
