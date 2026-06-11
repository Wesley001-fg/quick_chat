/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act.quickchat;

/**
 *
 * @author mnisi
 */
public class login {
    static String username;
    static String password;
    
    static boolean checkUserName(String username){
    return username.length() == 5 && username.contains("_");
        }

    static boolean checkPasswordComplexity(String password) { 
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d+.*") && password.matches(".*[^a-zA-Z0-9].*");
        }
    
    static boolean checkCellPhoneNumber(String cellnum) {
            return cellnum.startsWith("+27") && cellnum.substring(3).length() == 9;
        }
    
    static String registerUser(String username, String password) {
            if (checkUserName(username) && checkPasswordComplexity(password)) {
                return "";
            } else {
                return "Username or password incorrect format";
            }
        }
    
    static boolean loginUser(String loginUsername, String loginPassword) {
            return loginUsername.equals(username) && loginPassword.equals(password);
        } 
    
     static String returnLoginStatus(String loginUsername, String loginPassword) {
            if (loginUser(username, password)) {
                return "A successful login";
            } else {
                return "A failed login";
            }
     }}



