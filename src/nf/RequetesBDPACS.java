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

    /**
     * 
     * Renvoie le dernier identifiant PACS enregistré
     * 
     * @param conn Connexion à notre base de données
     * @return le dernier identifiant PACS enregistré
     * @throws java.sql.SQLException exception
     */
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

    /**
     * 
     * Renvoie l'identifiant PACS géneré
     * 
     * @param conn Connexion à notre base de données
     * @return identifiant PACS géneré
     * @throws java.sql.SQLException exception
     */
    public static int generatePACSId(Connection conn) throws SQLException {
        int latestIdSave = latestPACSSave(conn);
        latestIdSave++;
        return latestIdSave;
    }

    
    /**
     * 
     * Renvoie l'identifiant SIH d'un patient
     * 
     * @param examen un examen
     * @param file le fichier de l'image à affecter à l'examen
     * @param comments les commentaires associés à l'image
     * @param conn Connexion à notre base de données
     */
    public static void insertImage(Examen examen, File file, String comments, Connection conn) {
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
            ps.setString(2, examen.getExamId());
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * récupère les infos d'un professionnel donné dans une liste.
     *
     * @param examId identifiant d'un examen
     * @param conn connexion a la base de données
     * @return une liste contenant les images (id) correspondant à un examen
     * @throws java.sql.SQLException exception
     */
    public static String[] returnPACSoneExam(String examId, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        Statement stmtCount = conn.createStatement();
        int sizeTab = 0;
        // Execute the query
        ResultSet rsCount = stmtCount.executeQuery("SELECT count(*) FROM PACS WHERE examId = '" + examId + "' ORDER BY pacsId ");
        ResultSet rs = stmt.executeQuery("SELECT pacsId FROM PACS WHERE examId = '" + examId + "' ORDER BY pacsId ");

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
    
    /**
     * 
     * Renvoie un tableau contanant les identifiants PACS associés à un examen
     * 
     * @param examId identifiant d'un examen
     * @param conn Connexion à notre base de données
     * @return Un tableau contenant les identifiants pacs associés à un examen
     * @throws java.sql.SQLException exception
     */
    public static String[] returnPACSoneExamBis(String examId, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        Statement stmtCount = conn.createStatement();
        int sizeTab = 0;
        // Execute the query
        ResultSet rsCount = stmtCount.executeQuery("SELECT count(*) FROM PACS WHERE examId = '" + examId + "' ORDER BY pacsId ");
        ResultSet rs = stmt.executeQuery("SELECT pacsId FROM PACS WHERE examId = '" + examId + "' ORDER BY pacsId ");

        while (rsCount.next()) {
            sizeTab = rsCount.getInt(1);
            System.out.println("rsCount()= " + sizeTab);
        }

        String[] id = new String[sizeTab];

        int count = 0;
        while (rs.next()) {
            Integer i = rs.getInt(1);
            String is = i.toString();
            id[count] = is;
            count++;
        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        System.out.println("taille infoPACS= " + id.length);
        return id;

    }

    
    /**
     * 
     * Met l'image dans un tableau de byte
     * 
     * @param pacsId identifiant pacs
     * @param conn Connexion à notre base de données
     * @return le tableau de byte correspondant à l'image identifiée par pacsId
     * @throws java.sql.SQLException exception
     */
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

    /**
     * 
     * Renvoie le commentaire associé à une image
     * 
     * @param pacsId identifiant pacs
     * @param conn Connexion à notre base de données
     * @return le commentaire
     * @throws java.sql.SQLException exception
     */    
    public static String returnCommentsImg(int pacsId, Connection conn) throws SQLException {
        String comments = null;
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT comments FROM PACS WHERE pacsId=" + pacsId);

        while (rs.next()) {
            comments = rs.getString(1);

        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        return comments;
    }

    /**
     * 
     * Renvoie le nombre d'images associées à un examen
     * 
     * @param examId identifiant d'un examen
     * @param conn Connexion à notre base de données
     * @return le nombre d'image
     * @throws java.sql.SQLException exception
     */
    public static String returnNbImgOneExam(String examId, Connection conn) throws SQLException {
        int nbImg = 0;
        Statement stmt = conn.createStatement();

        // Execute the 
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM PACS WHERE examId='" + examId + "'");

        while (rs.next()) {
            nbImg = rs.getInt(1);

        }
        // Close the result set, statement and the connection 

        rs.close();
        stmt.close();
        return Integer.toString(nbImg);
    }

    /**
     * 
     * Initialise les commentaires
     * 
     * @param login infos du manipulateur radio
     * @param conn Connexion à la Base de données
     * @return le commentaire initialisé
     */
    public static String initComments(Login login, Connection conn) {
        String str = "Image realisée par: "+login.getLogin()+"-"+login.getLastName().toUpperCase()+" "+login.getFirstName()
                + "\n----------------------------------------------\n";
        return str;
    }

    /**
     * 
     * Met à jour le commentaire d'une image
     * 
     * @param login infos du manipulateur radio
     * @param pacsId identifiant du pacs
     * @param comments commentaires
     * @param conn Connexion à notre base de données
     * @throws java.sql.SQLException exception
     */
    public static void updateComments(Login login, int pacsId, String comments, Connection conn) throws SQLException {

        // Get a statement from the connection
        Statement stmt = conn.createStatement();
        // Execute the query
        System.out.println("query=" + "UPDATE PACS SET comments='" + initComments(login,conn).replaceAll("'", "''") + comments.replaceAll("'", "''") + "' WHERE pacsId=" + pacsId );
        stmt.executeUpdate("UPDATE PACS SET comments='" + initComments(login,conn).replaceAll("'", "''") + comments.replaceAll("'", "''")+ "' WHERE pacsId=" + pacsId );
                
        // Close the resultset, statement and the connection         
        stmt.close();

    }

}
