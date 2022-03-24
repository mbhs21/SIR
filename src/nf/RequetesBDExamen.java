/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.BrowseImage;

/**
 *
 * @author Benhadj
 */
public class RequetesBDExamen {

    /**
     * 
     * Recherche tous les examens d'un patient identifié par son id
     * 
     * @param patientId identifiant du patient
     * @param conn connexion à notre base de données
     * @return un tableau d'objet contanant les infos de chaque examen (date, type, id_professionel)
     * @throws java.sql.SQLException
     */
    public static ArrayList<Object[]> RechercherExamenPatientID(String patientId, Connection conn) throws SQLException {
        ArrayList<Object[]> infoExamensOnePatient = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT d, type, proId FROM EXAM WHERE patientId='" + patientId + "' ORDER BY d DESC");

        while (rs.next()) {
            System.out.println("OK");
            Object[] infoOneExam = new Object[3];
            System.out.println(rs.getString(1).trim());
            infoOneExam[0] = rs.getString(1).trim();
            infoOneExam[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2).trim());
            infoOneExam[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3).trim());

            infoExamensOnePatient.add(infoOneExam);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoExamensOnePatient;
    }
    /**
     * 
     * Recherche les examens en cours d'un patient identifié par son id
     * 
     * @param patientId identifiant du patient
     * @param conn connexion à notre base de données
     * @return un tableau d'objet contanant les infos de chaque examen (date, type, id_professionel)
     * @throws java.sql.SQLException
     */
    public static ArrayList<Object[]> RechercherExamenPatientCurrent(String patientId, Connection conn) throws SQLException {
        ArrayList<Object[]> infoExamensOnePatient = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT d, type, proId FROM EXAM WHERE patientId='" + patientId + "' and status=0 ORDER BY d");

        while (rs.next()) {
            System.out.println("OK");
            Object[] infoOneExam = new Object[3];
            System.out.println(rs.getString(1).trim());
            infoOneExam[0] = rs.getString(1).trim();
            infoOneExam[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2).trim());
            infoOneExam[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3).trim());

            infoExamensOnePatient.add(infoOneExam);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoExamensOnePatient;
    }
    
    /**
     * 
     * Recherche les examens complets d'un patient identifié par son id
     * Un examen complet = Images + Compte-rendu
     * 
     * @param patientId identifiant du patient
     * @param conn Connexion à notre base de données
     * @return un tableau d'objet contanant les infos de chaque examen (date, type, id_professionel)
     * @throws java.sql.SQLException
     */
    public static ArrayList<Object[]> RechercherExamenPatientCompleted(String patientId, Connection conn) throws SQLException {
        ArrayList<Object[]> infoExamensOnePatient = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT d, type, proId FROM EXAM WHERE patientId='" + patientId + "' and status=1 ORDER BY d");

        while (rs.next()) {
            System.out.println("OK");
            Object[] infoOneExam = new Object[3];
            System.out.println(rs.getString(1).trim());
            infoOneExam[0] = rs.getString(1).trim();
            infoOneExam[1] = rs.getString(2).trim();
            System.out.println(rs.getString(2).trim());
            infoOneExam[2] = rs.getString(3).trim();
            System.out.println(rs.getString(3).trim());

            infoExamensOnePatient.add(infoOneExam);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return infoExamensOnePatient;
    }

    
    /**
     * 
     * Stocke les données d'un examen à partir de la date d'examen
     * 
     * @param dateExamen date de l'examen YYYY-MM-DD HH:mm
     * @param conn Connexion à notre base de données
     * @return renvoie l'examen correspondant à la date en question
     * @throws java.sql.SQLException
     */
    public static Examen storeOneExamInfo(String dateExamen, Connection conn) throws SQLException {
        Examen exam = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        System.out.println("d= " + dateExamen);
        ResultSet rs = stmt.executeQuery("SELECT * FROM EXAM WHERE d='" + dateExamen + "'");

        while (rs.next()) {
            System.out.println("d= " + dateExamen);
            if (rs.getString(5) == null) {
                exam = new Examen(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), "", rs.getString(6));
                System.out.println("OK");
            } else {
                exam = new Examen(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim(), rs.getString(6));
                System.out.println("NOP");

            }
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return exam;
    }

    /**
     * 
     * Renvoie l'identifiant du dernier examen enregistré
     * 
     * @param conn Connexion à notre base de données
     * @return identifiant du dernier examen
     * @throws java.sql.SQLException
     */
    public static String latestExamSave(Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM EXAM ORDER BY examID");

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
     * Génère un id d'examen
     * 
     * @param conn Connexion à notre base de données
     * @return identifiant géneré
     * @throws java.sql.SQLException
     */
    public static String generateExamenId(Connection conn) throws SQLException {
        String latestIdSave = latestExamSave(conn);
        String[] latestIdSplit = latestIdSave.split("EX");
        String lastId = latestIdSplit[1];
        int id = Integer.parseInt(lastId);
        id++;
        if (id < 10) {
            return "EX0" + Integer.toString(id);
        } else {
            return "EX" + Integer.toString(id);
        }
    }

    /**
     * 
     * Ajoute un examen dans la base de données
     * 
     * @param examen examen à ajouter dans notre base de données
     * @param conn Connexion à notre base de donnés
     * @return examen avec mise à jour de l'identifiant 
     * @throws java.sql.SQLException
     */
    public static Examen addExamBD(Examen examen, Connection conn) throws SQLException {
        //Generate new patientId
        String newExamenId = generateExamenId(conn);
        System.out.println("new examId=" + newExamenId);
        Examen exam = new Examen(newExamenId, examen.getPatientId(), examen.getProId(), examen.getTypeExamen(), "", examen.getDateExam());
        // Get a statement from the connection
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into EXAM values(?,?,?,?,?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //id

            ps.setString(1, newExamenId);
            ps.setString(2, examen.getPatientId());
            ps.setString(3, examen.getProId());
            ps.setString(4, examen.getTypeExamen());
            ps.setString(5, examen.getReport());
            ps.setString(6, examen.getDateExam());
            ps.setInt(7, 0);

        } catch (SQLException ex) {
            Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //exécution de la requête
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Examen inséré avec succès!");
        try {
            //fermer le preparedStatement
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exam;
    }

   
    /**
     * 
     * Met à jour notre base de données afin d'ajouter un compte-rendu 
     * 
     * @param examId identifiant d'un examen
     * @param report compte-rendu associé à l'examen
     * @param conn Connexion à notre base de données
     * @throws java.sql.SQLException
     */
    public static void updateCR(String examId, String report, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        System.out.println("query=" + "UPDATE EXAM SET report='" + report.replaceAll("'", "''") + "' WHERE examId='" + examId + "'");
        stmt.executeUpdate("UPDATE EXAM SET report='" + report.replaceAll("'", "''") + "' WHERE examId='" + examId + "'");
        // Close the resultset, statement and the connection         
        stmt.close();

    }
    
    /**
     * 
     * Met à jour notre base de données afin de passer le statut de l'exam à 1 (=complet)
     * 
     * @param examId identifiant d'un examen
     * @param conn Connexion à notre base de données
     * @throws java.sql.SQLException
     */
    public static void updateStatusExam(String examId, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        System.out.println("query=" + "UPDATE EXAM SET status=1 WHERE examId='" + examId + "'");
        stmt.executeUpdate("UPDATE EXAM SET status=1 WHERE examId='" + examId + "'");
        // Close the resultset, statement and the connection        
        stmt.close();

    }
    
    /**
     * 
     * Renvoie l'identifiant SIR d'un patient 
     * 
     * @param patientId identification d'un patient
     * @param conn Connexion à notre base de données
     * @return l'identifiant SIR d'un patient 
     * @throws java.sql.SQLException
     */
    public static String returnIdSIR(String patientId,Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM SIR_SIH WHERE idSIR='"+patientId+"'");

        while (rs.next()) {
            id = rs.getString(2).trim().split("/")[0];
            System.out.println("id= " + id);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return id;
    }
    
    /**
     * 
     * Renvoie l'identifiant SIH d'un patient
     * 
     * @param patientId identifiant d'un patient
     * @param conn Connexion à notre base de données
     * @return identifiant SIH
     * @throws java.sql.SQLException
     */
    public static String returnIdSIH(String patientId,Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM SIR_SIH WHERE idSIR='"+patientId+"'");

        while (rs.next()) {
            id = rs.getString(2).trim();
            System.out.println("id= " + id);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return id;
    }
    
    /**
     * 
     *Vérifie que le patient figure dans le SIH ou non
     * 
     * @param patientId identifiant d'un patient
     * @param conn Connexion à notre base de données
     * @return vrai si le patient est dans le SIH sinon faux
     * @throws java.sql.SQLException
     */
    public static boolean isPatientSIH(String patientId,Connection conn) throws SQLException {
        boolean isSIH=false;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM SIR_SIH WHERE idSIR='"+patientId+"'");

        while (rs.next()) {
            id = rs.getString(1).trim();
            System.out.println("id= " + id);
            isSIH=true;
        }

        
        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return isSIH;
    }

}
