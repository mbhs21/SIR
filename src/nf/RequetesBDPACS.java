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

    public void insertImage(String examId,File file,String comments,Connection conn) {
        try {
            
            int newPacsId=generatePACSId(conn);
            
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
            ps.setString(4,comments);
            
            
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
}
