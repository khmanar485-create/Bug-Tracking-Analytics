package com.bugtracker.service;
import com.bugtracker.model.*;
import com.bugtracker.util.DBConnection;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class BugService {
	

//create a bug in the database
	public void createBug(String title, String description, Priority priority, Status status, int assignedTo) {
		  String sql = "INSERT INTO bugs (title, description, status, priority, assigned_to, created_at) " +
                  "VALUES (?, ?, ?, ?, ?, ?)";
     try (Connection conn = DBConnection.getConnection();
          PreparedStatement ps = conn.prepareStatement(sql)) {

         ps.setString(1, title);
         ps.setString(2, description);
         ps.setString(3, status.name());
         ps.setString(4, priority.name());
         ps.setInt(5, assignedTo);
         ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));

         ps.executeUpdate();
         System.out.println("Bug created successfully!");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

// display all bugs	
	 public void displayAllBugs() {
	        String sql = "SELECT * FROM bugs";
	        try (Connection conn = DBConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            List<Bug> bugs = new ArrayList<>();
	            while (rs.next()) {
	                Bug bug = new Bug(
	                        rs.getInt("bug_id"),
	                        rs.getString("title"),
	                        rs.getString("description"),
	                        Priority.valueOf(rs.getString("priority")),   
	                        Status.valueOf(rs.getString("status")),       
	                        rs.getInt("assigned_to"),                     
	                        rs.getTimestamp("created_at").toLocalDateTime() 
	                );
	                bugs.add(bug);
	            }

	            if (bugs.isEmpty()) {
	                System.out.println("No bugs reported.");
	                return;
	            }

	            for (Bug bug : bugs) {
	                System.out.println(bug);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	
// Find a bug by its ID from the database
	 public Bug findBugById(int bugId) {
	     String sql = "SELECT * FROM bugs WHERE bug_id = ?";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement ps = conn.prepareStatement(sql)) {

	         ps.setInt(1, bugId);
	         ResultSet rs = ps.executeQuery();

	         if (rs.next()) {
	             return new Bug(
	                     rs.getInt("bug_id"),
	                     rs.getString("title"),
	                     rs.getString("description"),
	                     Priority.valueOf(rs.getString("priority")),
	                     Status.valueOf(rs.getString("status")),
	                     rs.getInt("assigned_to"),
	                     rs.getTimestamp("created_at").toLocalDateTime()
	                     
	             );
	         }

	     } catch (SQLException e) {
	         e.printStackTrace();
	     }

	     return null; // bug not found
	 }

	
//update status of a bug 	
	public void updateStatus(int bugId, Status status) {
        String sql = "UPDATE bugs SET status = ? WHERE bug_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status.name());
            ps.setInt(2, bugId);

            int updated = ps.executeUpdate();
            if (updated > 0) {
                System.out.println("Status updated successfully!");
            } else {
                System.out.println("Bug not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
//assign bug to a developer (user_id) 	
	 public void assignBug(int bugId, int userId) {
	        String sql = "UPDATE bugs SET assigned_to = ? WHERE bug_id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, userId);
	            ps.setInt(2, bugId);

	            int updated = ps.executeUpdate();
	            if (updated > 0) {
	                System.out.println("Bug assigned successfully!");
	            } else {
	                System.out.println("Bug not found.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}