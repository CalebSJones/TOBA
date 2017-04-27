/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.io.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import customer.Account;
import customer.User;

/**
 *
 * @author Caleb Jones
 */
public class AccountDB {

    public static int insert(Account account) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "INSERT INTO Accounts (user, type, balance) "
                + "VALUES (?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, account.getUser().toString());
            ps.setString(2, account.getAccountType().toString());
            ps.setDouble(3, account.getBalance());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(Account account) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Accounts SET Balance = ? WHERE User = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getUser().toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Account> getAccount(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Accounts WHERE User = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.toString());
            rs = ps.executeQuery();
            ArrayList<Account> accounts = new ArrayList<Account>();
            while (rs.next()) {
                Account account = new Account();
                account.setUser(user);
                account.setAccountType(rs.getString("Type"));
                account.setBalance(rs.getDouble("Balance"));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
