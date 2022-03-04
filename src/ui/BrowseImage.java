/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author sosso
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import nf.DatabaseAccessProperties;

public class BrowseImage extends JFrame {

    Connection conn;
    JLabel l;

    public BrowseImage(Connection conn) {
        super("Afficher une image à partir d'un JFileChooser");
        JButton btn = new JButton("Parcourir");
        btn.setBounds(150, 310, 100, 40);
        l = new JLabel();
        l.setBounds(10, 10, 365, 290);
        add(btn);
        add(l);
        this.conn = conn;

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filtrer les fichiers
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
                file.addChoosableFileFilter(filter);
                int res = file.showSaveDialog(null);
                //si l'utilisateur clique sur enregistrer dans Jfilechooser
                if (res == JFileChooser.APPROVE_OPTION) {
                    File selFile = file.getSelectedFile();

                    FileInputStream input = null;
                    try {
                        input = new FileInputStream(selFile);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    PreparedStatement ps = null;
                    try {
                        ps = conn.prepareStatement("insert into PACS values(?,?,?)");
                    } catch (SQLException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        //id

                        ps.setInt(1, 1);
                        ps.setString(2, "EX01");
                        ps.setBinaryStream(3, (InputStream) input, (int) selFile.length());
                       

                    } catch (SQLException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    try {
                        //exécution de la requête
                        ps.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Image insérée avec succès!");
                    try {
                        //fermer le preparedStatement
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        //fermer la connexion
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BrowseImage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String path = selFile.getAbsolutePath();
                    l.setIcon(resize(path));
                }
            }
        }
        );

        setLayout(
                null);
        setLocationRelativeTo(
                null);
        setSize(
                400, 400);
        setVisible(
                true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

// Méthode pour redimensionner l'image avec la même taille du Jlabel
    public ImageIcon resize(String imgPath) {
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String jdbcDriver, dbUrl, username, password;
        String configurationFile
            = "MaBD.properties.txt";
        DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
        jdbcDriver = dap.getJdbcDriver();
        dbUrl = dap.getDatabaseUrl();
        username = dap.getUsername();
        password = dap.getPassword();

        // Load the database driver
        Class.forName(jdbcDriver);

        // Get a connection to the database
        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        new BrowseImage(conn);
    }
}
