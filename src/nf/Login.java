/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Benhadj
 */
public class Login {
    private String login;
    private String passeword;
    private String lastName;
    private String firstName;
    private String function;
    Connection conn;
        
    
    public Login(String login, String passeword,String lastName,String firstName,String function){
        this.login=login;
        this.passeword=passeword;
        this.lastName=lastName;
        this.firstName=firstName;
        this.function=function;
    }
    
    public Login(String login,String lastName,String function){
        this.login=login;
        this.passeword=null;
        this.lastName=lastName;
        this.firstName=firstName;
        this.function=function;
    }
    
    public static boolean containsId (List<String> proIdList,String id){
        int i=0;
        boolean cont=false;
        while (i<proIdList.size() && !proIdList.get(i).equals("PH01")){
            i++;
        }
        
        return i!=proIdList.size();
    }
   
         
    /**
     * if id already exists return false else true
     * @return a boolean
     */
    public boolean verifyId (String id){
        return false;
    }
    
    /**
     * if passeword already exists return false else true
     * @return a boolean
     */
    public boolean verifyPW (String passeword){
        return false;
    }
        
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the passeword
     */
    public String getPasseword() {
        return passeword;
    }

    /**
     * @param passeword the passeword to set
     */
    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the function
     */
    public String getFunction() {
        return function;
    }

    /**
     * @param function the function to set
     */
    public void setFunction(String function) {
        this.function = function;
    }
    
    
    
}
