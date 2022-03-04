/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.BrowseImage;

/**
 *
 * @author Benhadj
 */
public class RequetesBDExamen {

    public static ArrayList<Object[]> RechercherExamenPatientID(String patientId, Connection conn) throws SQLException {
        ArrayList<Object[]> infoExamensOnePatient = new ArrayList<>();

        // Get a statement from the connection
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT d, type, proId FROM Exam WHERE patientId='" + patientId + "' ORDER BY d");

        while (rs.next()) {
            System.out.println("OK");
            Object[] infoOneExam = new Object[3];
            System.out.println(rs.getTimestamp(1).toString().trim());
            infoOneExam[0] = rs.getTimestamp(1).toString().trim();
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

    public static Examen storeOneExamInfo(String dateExamen, Connection conn) throws SQLException {
        Examen exam = null;
        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        String id = null;
        // Execute the query
        System.out.println("d= "+dateExamen);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Exam WHERE d=TO_TIMESTAMP('" + dateExamen + "')");

        while (rs.next()) {
            System.out.println("d= "+dateExamen);
            
            exam = new Examen(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim(), rs.getTimestamp(6));

        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return exam;
    }

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

    public static void addExamBD(Examen examen, Connection conn) throws SQLException {
        //Generate new patientId
        String newExamenId = generateExamenId(conn);
        examen.setReport(null);
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
            ps.setTimestamp(6, examen.getDateExam());
            ps.setInt(7, 1);

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
    }
    
   

}
//    public static void addExamenBD(Examen examen, Connection conn) throws SQLException {
//        //Generate new patientId
//        String newExamenId = generateExamenId(conn);
//        // Get a statement from the connection
//        Statement stmt = conn.createStatement();
//        examen.setExamId(newExamenId);
//        System.out.println("");
//        System.out.println(examen.getDateExam().toString());
//        // Execute the query
//        ResultSet rs = stmt.executeQuery("insert into EXAM values ('" + newExamenId + "','" + examen.getPatientId() + "','" + examen.getProId() + "','" + examen.getTypeExamen() + "','" + examen.getReport() + "',to_TIMESTAMP('" + examen.getDateExam().getTime() + "'),'" + examen.getStatus() + "')");
//        // Close the resultset, statement and the connection 
//
//        stmt.close();
//    }
