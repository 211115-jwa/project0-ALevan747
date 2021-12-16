package com.revature.data.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.utils.ConnectionUtil;

public class UserPostgres implements UserDAO{
	private ConnectionUtil connUtil =ConnectionUtil.getConnectionUtil();
	

	@Override
	public int create(User dataToAdd) {
		int generatedId = 0;
		
		//try with resources auto-close resources
		try(Connection conn = connUtil.getConnection()){
			//when you run DML statements, you want to manage the TCL
			conn.setAutoCommit(false);
			
			String sql = "insert into person(id,Name,Username,password) "
					+ "values (default, ?, ?, ?)";
			String[] keys = {"id"};   //the name of the primary key column that will be autogenrated
			//creating the prepared statement
			PreparedStatement pStmt = conn.prepareStatement(sql,keys);
			//we need to set the values of the question marks
			pStmt.setString(1, dataToAdd.getName());
			pStmt.setString(2, dataToAdd.getUsername());
			pStmt.setString(3, dataToAdd.getPassword());
			
			//after setting the values, we can run the statement
			pStmt.executeUpdate();
			ResultSet resultSet = pStmt.getGeneratedKeys();
			
			if(resultSet.next()) { //"next goes to the next row in the resultset )or the first row)
				//getting the ID value from the resultSet
				generatedId = resultSet.getInt("id");
				conn.commit(); //running the TCL commit statement
			} else {
				conn.rollback();
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public User getById(int id) {
		User user = null;
		
		try(Connection conn = connUtil.getConnection()){
			String sql = "select * from User where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,id);
			
			ResultSet resultSet = pStmt.executeQuery();
			
			if(resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setName(resultSet.getString("Name"));
				user.setUsername(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				//to do get user candy?
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Set<User> getAll() {
		Set<User> allUsers = new HashSet<>();
		
		try(Connection conn = connUtil.getConnection()){
			String sql = "select * from candy";  //why select all from candy and not user?
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while(resultSet.next()) {
				//create the Candy object
				User user = new User();
				//pull the data from each row in the result set
				//and put it into the java object so that we can use it here
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("Name"));
				user.setUsername(resultSet.getString("Username"));
			    user.setPassword(resultSet.getString("Password")); //possible typo on Sierra's?
			    
			    //to-do get user's candy
			    allUsers.add(user);  
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public void update(User dataToUpdate) {
		try(Connection conn = connUtil.getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "update User set " + "Name=?,Username=?,Password=? "
			+ "where id=?";
		    PreparedStatement pStmt = conn.prepareStatement(sql);
		    pStmt.setString(1, dataToUpdate.getName());
		    pStmt.setString(2, dataToUpdate.getUsername());
		    pStmt.setString(3, dataToUpdate.getPassword());
		    pStmt.setInt(4, dataToUpdate.getId());
		    
		    int rowsAffected = pStmt.executeUpdate();
		    
		    if(rowsAffected == 1) {
		    	conn.commit();
		    }else {
		    	conn.rollback();
		    }
		}catch (SQLException e) {
			e.printStackTrace();		
		}
	}

	@Override
	public void delete(User dataToDelete) {
		try(Connection conn = connUtil.getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "delete from User " + "where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToDelete.getId());
			
			int rowsAffected = pStmt.executeUpdate(); //not delete?
			
			if(rowsAffected == 1) {
				//TO DO remove user's user-candy relationships
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getByUsername(String Username) {
		User user = null;
		
		try(Connection conn = connUtil.getConnection()){
			String sql = "select * from User where Username=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Username); //double check capitalizations later
			
			ResultSet resultSet = pStmt.executeQuery();
			
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("Name"));
				user.setUsername(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				//TO DO get user's pets
						
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
