/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Benhadj
 */
public class RequetesBDPACS {

    public static int latestPACSSave(Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        int id = -1;
        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM PACS ORDER BY pacsId");

        while (rs.next()) {
            id = rs.getInt(1);
            System.out.println("id= " + id);
        }

        // Close the resultset, statement and the connection 
        rs.close();
        stmt.close();
        return id;
    }

    public static int generatePACSId(Connection conn) throws SQLException {
        int latestIdSave = latestPACSSave(conn);
        latestIdSave++;
        return latestIdSave;
    }

    public void insertImage(String examId, File file, String comments, Connection conn) {
        try {

            int newPacsId = generatePACSId(conn);

            Statement st = conn.createStatement();
            //l'image à insérer

            FileInputStream input = new FileInputStream(file);

            //creation de la requête
            PreparedStatement ps
                    = conn.prepareStatement("insert into PACS values(?,?,?,?)");

            //pacsId
            ps.setInt(1, newPacsId);
            //examId
            ps.setString(2, examId);
            //image
            ps.setBinaryStream(3, (InputStream) input, (int) file.length());

            //comments
            ps.setString(4, comments);

            //exécution de la requête
            ps.executeUpdate();
            System.out.println("Image insérée avec succès!");
            //fermer le preparedStatement
            ps.close();
            //fermer la connexion
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * récupère les infos d'un professionnel donné dans une liste.
     *
     * @param examen
     * @param conn connexion a la base de donnees
     * @return une liste contenant les images (id) correspondant à un examen
     * @throws java.sql.SQLException
     */
    public static String[] returnPACSoneExam(String pacsId, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        Statement stmtCount = conn.createStatement();
        int sizeTab = 0;
        // Execute the query
        ResultSet rsCount = stmtCount.executeQuery("SELECT count(*) FROM pacs WHERE examId = '" + pacsId + "' ORDER BY pacsId ");
        ResultSet rs = stmt.executeQuery("SELECT pacsId FROM pacs WHERE examId = '" + pacsId + "' ORDER BY pacsId ");

        while (rsCount.next()) {
            sizeTab = rsCount.getInt(1);
            System.out.println("rsCount()= " + sizeTab);
        }

        String[] id = new String[sizeTab];

        int count = 0;
        while (rs.next()) {
            Integer i = rs.getInt(1);
            String is = "PACS " + i.toString();
            id[count] = is;
            count++;
        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        System.out.println("taille infoPACS= " + id.length);
        return id;

    }

    public static byte[] showImage(int pacsId, Connection conn) throws SQLException {
        //creation et exécution de la requête
        PreparedStatement statement = conn.prepareStatement("SELECT image FROM PACS WHERE pacsId =" + pacsId);
        ResultSet res = statement.executeQuery();

        //récupérer l'image sous forme d'octet
        byte[] image = null;
        while (res.next()) {
            image = res.getBytes("image");
        }
        statement.close();
        return image;
    }

    public static String returnCommentsImg(int pacsId, Connection conn) throws SQLException {
        String comments = null;
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT comments FROM PACS WHERE pacsId=" + pacsId);

        while (rs.next()) {
            comments=rs.getString(1);

        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        return comments;
    }

}
