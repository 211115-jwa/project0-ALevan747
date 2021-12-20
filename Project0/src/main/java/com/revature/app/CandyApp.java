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
		*/
		app.routes(() -> {
			// localhost:8080/pets (candy in this case)
			path("/candy", () -> {
				get(ctx -> {
					// checking if they did /pets?species= (In this case, the user could search for flavor and brand)
					String flavorSearch = ctx.queryParam("flavor");
					String brandSearch = ctx.queryParam("brand");
					//space for more strings to filter gets
					if (flavorSearch != null && !"".equals(flavorSearch)) {
						Set<Candy> candyFound = userServ.searchAllCandybyFlavor(flavorSearch);
						ctx.json(candyFound);
					} else if(brandSearch != null && !"".equals(brandSearch)) {
						//Set<Candy> candyFound2 = userServ.search
						
					}else {
						Set<Candy> allCandy = userServ.getAll(); //viewAllCandy() old
						ctx.json(allCandy); 
					}
				});
				post(ctx -> {
					Candy newCandy = ctx.bodyAsClass(Candy.class);
					if (newCandy !=null) {
						empServ.addNewCandy(newCandy);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				
				// localhost:8080/pets/adopt/8   in this case localhost:8080/candy/{id}
				//path("/candy/{id}", () -> {
					//put(ctx -> {
						//try {
							//int userId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							//User newOwner = ctx.bodyAsClass(User.class);
							 //returns the person with their new pet added
							//newOwner = userServ.adoptCandy(candyId, newOwner);  //adopt candy?, needs revision
							//ctx.json(newOwner);
						//} catch (NumberFormatException e) {
						//	ctx.status(400);
						//	ctx.result("Candy ID must be a numeric value");
						//}
					//});
				//});
				
				// localhost:8080/pets/8
				path("/candy/{id}", () -> {
					
					get(ctx -> {
						try {
							int candyId = Integer.parseInt(ctx.pathParam("id"));
							Candy candy = empServ.getCandyById(candyId);
							if (candy != null)
								ctx.json(candy);
							else
								ctx.status(404); //should it fail return 404 not found
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
