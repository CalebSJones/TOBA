/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import customer.User;

/**
 *
 * @author Caleb Jones
 */
public class UserDB {
    
    public static int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO Users (firstName, lastName, phone, address, city, state, zip, email, username, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getState());
            ps.setString(7, user.getZip());
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getUsername());
            ps.setString(10, user.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
           System.out.println(e);
           return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Users SET FirstName = ?, LastName = ?, "
                + "Phone = ?, Address = ?, City = ?, State = ?, Zip = ?, "
                + "Username = ?, Password = ? "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getCity());
            ps.setString(6, user.getState());
            ps.setString(7, user.getZip());
            ps.setString(8, user.getUsername());
            ps.setString(9, user.getPassword());
            ps.setString(10, user.getEmail());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
