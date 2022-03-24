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

/**
 *
 * @author Benhadj
 */
public class RequetesBDPatient {

    /**
     * récupère les infos d'un patient donné dans une liste.
     *
     * @param conn connexion à la base de données
     * @return un HashMap contenant toutes les informations de TOUS patients
     * @throws SQLException en cas d'erreur d'acces a la base de données
     */
    public static ArrayList<Object[]> returnInfoPatients(Connection conn) throws
            SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT patientId,lastNameP,firstNameP,birthDate FROM PATIENT ORDER BY patientId ");

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            //System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            //System.out.println(rs.getString(2).toUpperCase());
            infoOnePatient[2] = rs.getString(3).trim();
            //System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getDate(4).toString().trim();
            //System.out.println(rs.getDate(4).toString());
            infoPatients.add(infoOnePatient);
        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        System.out.println("taille infopatient= " + infoPatients.size());
        return infoPatients;
    }

    /**
     * récupère les infos d'un patient à partir d'un identifiant donné dans une
     * liste.
     *
     * @param patientId identifiant du patient
     * @param conn connexion a la base de données
     * @return un HashMap contenant toutes les informations de TOUS patients
     * @throws SQLException en cas d'erreur d'acces a la base de données
     */
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
            infoOnePatient[3] = rs.getString(4).trim();
            System.out.println(rs.getString(4));
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    /**
     * récupère les infos d'un patient à partir de son nom, prénom et date de
     * naissance dans une liste.
     *
     * @param lastNameP nom du patient
     * @param firstNameP prénom du patient
     * @param birthDateP date de naissance du patient
     * @param conn connexion a la base de données
     * @return un HashMap contenant toutes les informations de TOUS patients
     * @throws SQLException en cas d'erreur d'acces a la base de données
     */
    public static ArrayList<Object[]> RechercherPatientName(String lastNameP, String firstNameP, String birthDateP, Connection conn) throws SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT patientId,  lastNameP, firstNameP, birthDate FROM PATIENT WHERE lastNameP='" + lastNameP
                + "' and firstNameP='" + firstNameP + "' and birthDate='" + birthDateP + "'");
        System.out.println("lastNameP = " + lastNameP);
        System.out.println("lastNameP = " + firstNameP);
        System.out.println("birthDateP" + birthDateP);

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            id = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getString(4).trim();
            System.out.println(rs.getString(4).trim());
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    /**
     * récupère les infos d'un patient à partir de son identifiant, nom, prénom
     * et date de naissance dans une liste.
     *
     * @param patientId identifiant du patient
     * @param lastNameP nom du patient
     * @param firstNameP prénom du patient
     * @param birthDateP date de naissance du patient
     * @param conn connexion a la base de données
     * @return un HashMap contenant toutes les informations du patient
     * @throws SQLException en cas d'erreur d'acces a la base de données
     */
    public static ArrayList<Object[]> RechercherPatient(String patientId, String lastNameP, String firstNameP, String birthDateP, Connection conn) throws SQLException {
        ArrayList<Object[]> infoPatients = new ArrayList<>();
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT patientId,  lastNameP, firstNameP, birthDate FROM PATIENT WHERE patientId='" + patientId + "' and lastNameP='" + lastNameP
                + "' and firstNameP='" + firstNameP + "' and birthDate='" + birthDateP + "'");
        System.out.println("lastNameP = " + lastNameP);
        System.out.println("lastNameP = " + firstNameP);
        System.out.println("birthDateP" + birthDateP);

        while (rs.next()) {
            Object[] infoOnePatient = new Object[4];
            infoOnePatient[0] = rs.getString(1).trim();
            id = rs.getString(1).trim();
            System.out.println(rs.getString(1));
            infoOnePatient[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2));
            infoOnePatient[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3));
            infoOnePatient[3] = rs.getString(4).trim();
            System.out.println(rs.getString(4).trim());
            infoPatients.add(infoOnePatient);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoPatients;
    }

    /**
     *
     * Stocke les données d'un patient à partir de son identifiant
     *
     * @param patientId identifiant du patient
     * @param conn Connexion à notre base de données
     * @return renvoie le patient correspondant à cet identifiant
     * @throws java.sql.SQLException
     */
    public static Patient storeOnePatientInfo(String patientId, Connection conn) throws SQLException {
        Patient pat = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT WHERE patientId='" + patientId + "'");

        while (rs.next()) {
            pat = new Patient(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(6));

        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return pat;
    }

    /**
     *
     * Renvoie l'identifiant du dernier patient enregistré
     *
     * @param conn Connexion à notre base de données
     * @return identifiant du dernier patient
     * @throws java.sql.SQLException
     */
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

    /**
     *
     * Génère un id patient
     *
     * @param conn Connexion à notre base de données
     * @return identifiant géneré
     * @throws java.sql.SQLException
     */
    public static String generatePatientId(Connection conn) throws SQLException {
        String latestIdSave = latestPatientSave(conn);
        String[] latestIdSplit = latestIdSave.split("PAT");
        String lastId = latestIdSplit[1];
        int id = Integer.parseInt(lastId);
        id++;
        if (id < 10) {
            return "PAT0" + Integer.toString(id);
        } else {
            return "PAT" + Integer.toString(id);
        }
    }

    /**
     *
     * Ajoute un patient dans la base de données
     *
     * @param patient patient à ajouter
     * @param conn Connexion à notre base de données
     * @throws java.sql.SQLException
     */
    public static void addPatientBD(Patient patient, Connection conn) throws SQLException {
        //Generate new patientId
        String newPatientId = generatePatientId(conn);
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        patient.setPatientId(newPatientId);
        System.out.println("");
        System.out.println(patient.getBirthDate());
        stmt.executeUpdate("insert into PATIENT values ('" + newPatientId + "', '" + patient.getLastNameP() + "','" + patient.getFirstNameP() + "','" + patient.getAdress() + "','" + patient.getGender() + "','" + patient.getBirthDate() + "')");

        // Close the resultset, statement and the connection 
        //rs.close();
        stmt.close();

    }

    /**
     *
     * Ajoute un patient dans la base de données
     *
     * @param patient patient à ajouter
     * @param conn Connexion à notre base de données
     * @return un patient avec mise à jour se l'identifiant
     * @throws java.sql.SQLException
     */
    public static Patient addPatBD(Patient patient, Connection conn) throws SQLException {
        //Generate new patientId
        String newPatientId = generatePatientId(conn);
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        patient.setPatientId(newPatientId);
        System.out.println("");
        System.out.println(patient.getBirthDate());

        stmt.executeUpdate("insert into PATIENT values ('" + newPatientId + "', '" + patient.getLastNameP() + "','" + patient.getFirstNameP() + "','" + patient.getAdress() + "','" + patient.getGender() + "','" + patient.getBirthDate() + "')");

// Close the resultset, statement and the connection 
        //rs.close();
        stmt.close();
        return patient;

    }

    /**
     *
     * Ajoute idSIH d'un patient dans notre de base de données
     *
     * @param idSIH identifiant du patient dans SIH
     * @param patient patient à ajouter
     * @param conn Connexion à notre base de données
     * @throws java.sql.SQLException
     */
    public static void MAJid(String idSIH, Patient patient, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        System.out.println("");
        System.out.println(patient.getBirthDate());

        stmt.executeUpdate("insert into SIR_SIH values ('" + patient.getPatientId() + "', '" + idSIH + "')");

// Close the resultset, statement and the connection 
        //rs.close();
        stmt.close();

    }

    /**
     *
     * Vérifie que le patient existe ou non dans notre base de données
     *
     * @param lastName nom du patient
     * @param firstName prénom du patient
     * @param birthDate date de naissance du patient
     * @param conn Connexion à notre base de données
     * @return vrai si le patient existre et faux sinon
     * @throws java.sql.SQLException
     */
    public static boolean patientExist(String lastName, String firstName, String birthDate, Connection conn) throws SQLException {
        String id = null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT WHERE lastNameP='" + lastName + "'  AND firstNameP='" + firstName + "' AND birthDate='" + birthDate + "'");

        while (rs.next()) {
            id = rs.getString(1).trim();

        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return !(id == null);

    }

}
