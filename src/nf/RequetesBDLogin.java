/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Benhadj
 */
public class RequetesBDLogin {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    /**
     * récupère les infos d'un professionnel donné dans une liste.
     *
     * @param conn connexion a la base de donnees
     * @return
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static HashMap returnInfoIdPro(String proId, Connection conn) throws
            SQLException {
        HashMap infoId = new HashMap();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE proId='" + proId + "'");

        while (rs.next()) {
            infoId.put("login", rs.getString(1));
            infoId.put("password", rs.getString(2));
            infoId.put("lastName", rs.getString(3));
            infoId.put("firstName", rs.getString(4));
            infoId.put("function", rs.getString(5));

        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        return infoId;
    }

    /**
     * stocke les identifiants des professionnels dans une liste.
     *
     * @param proId
     * @param conn connexion a la base de donnees
     * @return
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static String returnProId(String proId, Connection conn) throws
            SQLException {
        String id = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT proId FROM login WHERE proId='" + proId + "'");
        while (rs.next()) {
            System.out.println("id des professionels : "
                    + rs.getString(1));
            id = rs.getString(1);

        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        return id;
    }

   
    public static List<String> storeProId(Connection conn) throws
            SQLException {
        List<String> listProId = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT proId FROM login");
        System.out.println("ok");
        while (rs.next()) {
            System.out.println("id des professionels : "
                    + rs.getString(1));
            listProId.add(rs.getString(1));

        }
        // Close the result set, statement and the connection 
        System.out.println("listProId=" + listProId.contains("PH01"));
        rs.close();
        stmt.close();
        return listProId;
    }

    /**
     * stocke les mots de passe des professionnels dans une liste.
     *
     * @param conn connexion a la base de donnees
     * @return liste contenant les mots de passes
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static ArrayList<String> storePassword(Connection conn) throws
            SQLException {
        ArrayList<String> listPW = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT password FROM login");
        System.out.println("ok");
        while (rs.next()) {
            System.out.println("MP professionels : "
                    + rs.getString(1));
            listPW.add(rs.getString(1));

        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return listPW;
    }

    /**
     * stocke les id et mots de passe des professionnels dans une liste.
     *
     * @param conn connexion a la base de donnees
     * @return dictionnaire {key = id ; value= MP}
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static HashMap<String, String> storeIdPassword(Connection conn) throws
            SQLException {
        HashMap<String, String> dicoIdPW = new HashMap<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT proId,password FROM login");
        System.out.println("ok");
        while (rs.next()) {
            System.out.println("id et MP professionels : "
                    + rs.getString(1) + rs.getString(2));
            dicoIdPW.put(rs.getString(1), rs.getString(2));

        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return dicoIdPW;
    }

    /**
     * retourne le mot de passe d'un professionnel précis.
     *
     * @param proId identifiant du professionnel en question
     * @param conn connexion a la base de donnees
     * @return le mot de passe du professionel voulu
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static String returnPWproId(String proId, Connection conn) throws
            SQLException {
        String PWproId = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT password FROM login WHERE proId= '" + proId + "'");
        System.out.println("ok");
        while (rs.next()) {
            System.out.println("MP de " + proId + " : " + rs.getString(1));
            PWproId = rs.getString(1);

        }
        // Close the result set, statement and the connection 
        rs.close();
        stmt.close();
        return PWproId;
    }

    /**
     * met à jour le mot de passe crypté d'un professionnel précis.
     *
     * @param proId identifiant du professionnel en question
     * @param encryptPW le mot de passe crypté à mettre à jour
     * @param conn connexion a la base de donnees
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static void updatePWproId(String proId, String encryptPW, Connection conn) throws
            SQLException {
        String PWproId;

        // Get a statement from the connection
        Statement st = conn.createStatement();
//        PreparedStatement st = conn.prepareStatement("UPDATE login SET password=? WHERE proId=?");
//                
//        System.out.println("ok");
//        st.setString(1,encryptPW);
//        st.setString(2,proId);
        int count = st.executeUpdate("UPDATE login SET password= '" + encryptPW + "' WHERE proId= '" + proId + "'");
        System.out.println("count=" + count);

        // Close the result set, statement and the connection 
        st.close();

    }

}
