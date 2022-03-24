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

    /**
     *
     */
    private String login;

    /**
     *
     */
    private String passeword;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String function;

    /**
     *
     */
    Connection conn;
        
    /**
     * 
     * Constructeur Login
     * 
     * 
     * @param login Identifiant du professionel
     * @param passeword Mot de passe du pro
     * @param lastName nom du pro
     * @param firstName prénom du pro
     * @param function fonction du pro 
     */
    public Login(String login, String passeword,String lastName,String firstName,String function){
        this.login=login;
        this.passeword=passeword;
        this.lastName=lastName;
        this.firstName=firstName;
        this.function=function;
    }
    
    /**
     * 
     * Constructeur Login
     * 
     * 
     * @param login Identifiant du professionel
     * @param lastName nom du pro
     * @param firstName prénom du pro
     * @param function fonction du pro 
     */
    public Login(String login,String lastName,String firstName, String function){
        this.login=login;
        this.passeword=null;
        this.lastName=lastName;
        this.firstName=firstName;
        this.function=function;
    }
    
    /**
     * 
     * Constructeur Login
     * 
     * 
     * @param login Identifiant du professionel
     * @param lastName nom du pro
     * @param function fonction du pro 
     */
    public Login(String login,String lastName,String function){
        this.login=login;
        this.passeword=null;
        this.lastName=lastName;
        this.function=function;
    }
    
    /**
     * 
     * Permet de savoir si un pro identifiable par son id est contenu dans la liste de professionnels existante
     *  
     * @param proIdList Liste contenant tous les identifiants des professionnels
     * @param id Identifiant du professionnel en question
     * @return vrai s'il est contenu dans la liste et faux sinon
     */
    public static boolean containsId (List<String> proIdList,String id){
        int i=0;
        boolean cont=false;
        while (i<proIdList.size() && !proIdList.get(i).equals("PH01")){
            i++;
        }
        
        return i!=proIdList.size();
    }

    /**
     * 
     * Met en format textuel les informations d'un médecin
     * 
     * 
     * @param medPrescripteur
     * @return une chaine de caractères avec les infos du médecin en question
     */
    public static String infoMedCR(Login medPrescripteur){
        String str="Médecin prescripteur : "+medPrescripteur.login+"-"+medPrescripteur.lastName.toUpperCase()+" "+medPrescripteur.firstName;
                
        return str;
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
