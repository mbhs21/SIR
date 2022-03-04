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

/**
 *
 * @author Benhadj
 */
public class RequetesBDPatient {

    /**
     * récupère les infos d'un professionnel donné dans une liste.
     *
     * @param conn connexion a la base de donnees
     * @return un HashMap contenant toutes les informations de TOUS patients
     * @throws SQLException en cas d'erreur d'acces a la base de donnees
     */
    public static ArrayList<Object[]> returnInfoPatients(Connection conn) throws
            SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT patientId,lastNameP,firstNameP,birthDate FROM patient ORDER BY patientId ");

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getDate(4).toString().trim();
            System.out.println(rs.getDate(4).toString());
            infoPatients.add(infoOnePatient);
        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        System.out.println("taille infopatient= "+infoPatients.size());
        return infoPatients;
    }

    public static ArrayList<Object[]> RechercherPatientID(String patientId, Connection conn) throws SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT patientId,  lastNameP, firstNameP, birthDate FROM PATIENT WHERE patientId='" + patientId
                + "'");

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getDate(4).toString().trim();
            System.out.println(rs.getDate(4).toString());
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    public static ArrayList<Object[]> RechercherPatientName(String lastNameP, String firstNameP, Date birthDateP, Connection conn) throws SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT patientId,  lastNameP, firstNameP, birthDate FROM PATIENT WHERE lastNameP='" + lastNameP
                + "' and firstNameP='" + firstNameP + "' and birthDate=to_date('" + new java.sql.Date(birthDateP.getTime()) + "','YYYY-MM-DD')");
        System.out.println("lastNameP = " + lastNameP);
        System.out.println("lastNameP = " + firstNameP);
        System.out.println("birthDateP" + birthDateP.toString());
        //System.out.println("SQL birthDateP = "+new java.sql.Date( birthDateP.getTime()));

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            id = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getDate(4).toString().trim();
            System.out.println(rs.getDate(4).toString());
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    public static ArrayList<Object[]> RechercherPatient(String patientId, String lastNameP, String firstNameP, Date birthDateP, Connection conn) throws SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT patientId,  lastNameP, firstNameP, birthDate FROM PATIENT WHERE patientId='" + patientId + "' and lastNameP='" + lastNameP
                + "' and firstNameP='" + firstNameP + "' and birthDate=to_date('" + new java.sql.Date(birthDateP.getTime()) + "','YYYY-MM-DD')");
        System.out.println("lastNameP = " + lastNameP);
        System.out.println("lastNameP = " + firstNameP);
        System.out.println("birthDateP" + birthDateP.toString());
        //System.out.println("SQL birthDateP = "+new java.sql.Date( birthDateP.getTime()));

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            id = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getDate(4).toString().trim();
            System.out.println(rs.getDate(4).toString());
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    public static Patient storeOnePatientInfo(String patientId, Connection conn) throws SQLException {
        Patient pat = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT WHERE patientId='" + patientId + "'");

        while (rs.next()) {
            pat = new Patient(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim(), rs.getDate(6));

        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return pat;
    }

    public static String latestPatientSave(Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT ORDER BY patientID");

        while (rs.next()) {
            id = rs.getString(1).trim();
            System.out.println("id= " + id);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return id;
    }
    
    public static String generatePatientId(Connection conn) throws SQLException{
        String latestIdSave = latestPatientSave(conn);
        String[] latestIdSplit=latestIdSave.split("PAT");
        String lastId=latestIdSplit[1];
        int id=Integer.parseInt(lastId);
        id++;
        if (id<10){
            return "PAT0"+Integer.toString(id);
        }
        else{
           return "PAT"+Integer.toString(id); 
        }
    }

    public static void addPatientBD(Patient patient, Connection conn) throws SQLException {
        //Generate new patientId
        String newPatientId=generatePatientId(conn);        
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        patient.setPatientId(newPatientId);
        System.out.println("");
        System.out.println(patient.getBirthDate().toString());
        // Execute the query
        ResultSet rs = stmt.executeQuery("insert into PATIENT values ('" + newPatientId + "', '" + patient.getLastNameP() + "','" + patient.getFirstNameP() + "','" + patient.getAdress() + "','" + patient.getGender() + "',to_date('" + new java.sql.Date(patient.getBirthDate().getTime()) + "','YYYY-MM-DD'))");
        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();

    }
    
    public static boolean patientExist(String lastName,String firstName,Date birthDate, Connection conn) throws SQLException {
        String id=null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT WHERE lastNameP='" + lastName + "'  AND firstNameP='"+firstName+"' AND birthDate=to_date('" + new java.sql.Date(birthDate.getTime()) + "','YYYY-MM-DD') ");

        while (rs.next()) {
            id = rs.getString(1).trim();
            
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return !(id == null);

    }

    static void RechercherPiD(String paT02, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
