/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import customer.User;

/**
 *
 * @author Caleb Jones
 */
public class Account {

    public enum Type {
        Checking, Savings;
    }
    
    private Type type;
    private double balance;
    private User user;
    
    public Account() {

    }
    
    public Account(double balance, User user) {
        this.balance = balance;
        this.user = user;
    }
    
    public Type getAccountType() {
        return type;
    }
    
    public void setAccountType(String type) {
        switch (type) {
            case "Savings": this.type = Type.Savings;
            case "Checking": this.type = Type.Checking;
        }
    }
    
    public void credit(double credit) {
        this.balance += credit;
    }
    
    public void debit(double debit) {
        this.balance += debit;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
