/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import java.io.IOException;
import javax.swing.ImageIcon;
import nf.Login;
import nf.Patient;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nf.Examen;
import nf.RequetesBDExamen;
import nf.RequetesBDLogin;

/**
 *
 * @author em
 */
public class AccesListeExamen extends javax.swing.JFrame {

    Connection conn;
    Login login;
    Patient pat;

    /**
     * Creates new form AccesListeExamen
     *
     * @param login
     * @param pat
     * @param conn
     */
    public AccesListeExamen(Login login, Patient pat, Connection conn) throws SQLException {
        this.login = login;
        this.pat = pat;
        this.conn = conn;

        initComponents();

        this.setResizable(false);

        proDetails.setText(login.getLogin().strip()
                + " - " + login.getLastName().strip()
                + " " + login.getFirstName().strip()
        );

        examOnePatientTable.setModel(this.setModelJTable(this.pat));
        examOnePatientTable.setRowHeight(30);
        examOnePatientTable.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));

        ImageIcon icone = new ImageIcon("src/img_icon/user_1.png");
        java.awt.Image img = icone.getImage();
        java.awt.Image newImg = img.getScaledInstance(userIcon.getWidth(), userIcon.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImg);
        userIcon.setIcon(icone);

        ImageIcon iconeLogo = new ImageIcon("src/img_icon/logo.png");
        java.awt.Image imgLogo = iconeLogo.getImage();
        java.awt.Image newImgLogo = imgLogo.getScaledInstance(logoIcon.getWidth(), logoIcon.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeLogo = new ImageIcon(newImgLogo);
        logoIcon.setIcon(iconeLogo);

        ImageIcon iconeDeconnection = new ImageIcon("src/img_icon/deconnexion.png");
        java.awt.Image imgDeconnection = iconeDeconnection.getImage();
        java.awt.Image newImgDeconnection = imgDeconnection.getScaledInstance(deconnexionButton.getHeight(), deconnexionButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeDeconnection = new ImageIcon(newImgDeconnection);
        deconnexionButton.setIcon(iconeDeconnection);

        ImageIcon iconeRetour = new ImageIcon("src/img_icon/retour.png");
        java.awt.Image imgRetour = iconeRetour.getImage();
        java.awt.Image newImgRetour = imgRetour.getScaledInstance(retourButton.getHeight(), retourButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeRetour = new ImageIcon(newImgRetour);
        retourButton.setIcon(iconeRetour);

        ImageIcon iconeFiltre = new ImageIcon("src/img_icon/filtre.png");
        java.awt.Image imgFiltre = iconeFiltre.getImage();
        java.awt.Image newImgFiltre = imgFiltre.getScaledInstance(filtreIconLabel.getHeight(), filtreIconLabel.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeFiltre = new ImageIcon(newImgFiltre);
        filtreIconLabel.setIcon(iconeFiltre);

        idPField.setText(pat.getPatientId());
        lastNamePField.setText(pat.getLastNameP());
        firstNamePField.setText(pat.getFirstNameP());
        adressField.setText(pat.getAdress());
        genderField.setText(pat.getGender());
        birthDateField.setText(pat.getBirthDate().toString());

        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idMR(login.getLogin(), conn)) {
                accesExamenButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idPR(login.getLogin(), conn)) {
                addExamenButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idPH(login.getLogin(), conn)) {
                addExamenButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DefaultTableModel setModelJTable(Patient pat) throws SQLException {
        ArrayList<Object[]> infoExamOnePatient = RequetesBDExamen.RechercherExamenPatientID(pat.getPatientId(), conn);
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();

        model.addColumn("Date d'examen");
        model.addColumn("Type");
        model.addColumn("Praticien responsable");

        for (Object[] infoExam : infoExamOnePatient) {
            model.addRow(infoExam);

        }

        return model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        examOnePatientTable = new javax.swing.JTable();
        addExamenButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        proDetails = new javax.swing.JTextField();
        retourButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deconnexionButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idPField = new javax.swing.JTextField();
        lastNamePField = new javax.swing.JTextField();
        firstNamePField = new javax.swing.JTextField();
        adressField = new javax.swing.JTextField();
        genderField = new javax.swing.JTextField();
        birthDateField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        accesExamenButton = new javax.swing.JButton();
        filtreExamCombo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        filtreIconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1490, 794));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1490, 794));
        jPanel2.setMinimumSize(new java.awt.Dimension(1490, 794));
        jPanel2.setPreferredSize(new java.awt.Dimension(1490, 794));

        examOnePatientTable.setBackground(new java.awt.Color(255, 255, 255));
        examOnePatientTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray));
        examOnePatientTable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        examOnePatientTable.setForeground(new java.awt.Color(0, 102, 255));
        examOnePatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date de l'examen", "Type de l'examen", "PH responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        examOnePatientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        examOnePatientTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        examOnePatientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        examOnePatientTable.setShowGrid(true);
        jScrollPane1.setViewportView(examOnePatientTable);
        examOnePatientTable.getAccessibleContext().setAccessibleDescription("");

        addExamenButton.setBackground(new java.awt.Color(255, 255, 255));
        addExamenButton.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        addExamenButton.setForeground(new java.awt.Color(102, 102, 102));
        addExamenButton.setText("Ajouter un examen");
        addExamenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExamenButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Imprimer");

        jPanel1.setBackground(new java.awt.Color(242, 236, 234));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));

        proDetails.setEditable(false);
        proDetails.setBackground(new java.awt.Color(255, 255, 255));
        proDetails.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        proDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, java.awt.Color.white));
        proDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proDetailsActionPerformed(evt);
            }
        });

        retourButton.setBackground(new java.awt.Color(255, 255, 255));
        retourButton.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        retourButton.setForeground(new java.awt.Color(51, 153, 255));
        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(242, 236, 234));
        jLabel1.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Health IT");

        jLabel5.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Dossier Médical Radiologique");

        deconnexionButton.setBackground(new java.awt.Color(255, 255, 255));
        deconnexionButton.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        deconnexionButton.setForeground(new java.awt.Color(0, 153, 255));
        deconnexionButton.setText("Se déconnecter");
        deconnexionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionButtonActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(242, 236, 234));

        logoIcon.setBackground(new java.awt.Color(242, 236, 234));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(242, 236, 234));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(96, 96, 96)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deconnexionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(retourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(proDetails))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(proDetails)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deconnexionButton)
                                        .addComponent(retourButton))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jTextField4.setText("Adresse :");
        jTextField4.setBorder(null);

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jTextField7.setText("Date de naissance :");
        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jTextField5.setText("Nom:");
        jTextField5.setBorder(null);

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jTextField8.setText("Sexe :");
        jTextField8.setBorder(null);

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jTextField6.setText("Prénom :");
        jTextField6.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel3.setText("Identifiant :");

        idPField.setEditable(false);
        idPField.setBackground(new java.awt.Color(255, 255, 255));
        idPField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        idPField.setForeground(new java.awt.Color(51, 51, 51));
        idPField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lastNamePField.setEditable(false);
        lastNamePField.setBackground(new java.awt.Color(255, 255, 255));
        lastNamePField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        lastNamePField.setForeground(new java.awt.Color(51, 51, 51));
        lastNamePField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        firstNamePField.setEditable(false);
        firstNamePField.setBackground(new java.awt.Color(255, 255, 255));
        firstNamePField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        firstNamePField.setForeground(new java.awt.Color(51, 51, 51));
        firstNamePField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adressField.setEditable(false);
        adressField.setBackground(new java.awt.Color(255, 255, 255));
        adressField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        adressField.setForeground(new java.awt.Color(51, 51, 51));
        adressField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        genderField.setEditable(false);
        genderField.setBackground(new java.awt.Color(255, 255, 255));
        genderField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        genderField.setForeground(new java.awt.Color(51, 51, 51));
        genderField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        birthDateField.setEditable(false);
        birthDateField.setBackground(new java.awt.Color(255, 255, 255));
        birthDateField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        birthDateField.setForeground(new java.awt.Color(51, 51, 51));
        birthDateField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNamePField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lastNamePField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 98, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(idPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNamePField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(firstNamePField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 236, 234));
        jLabel6.setText("Liste des examens ");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.cyan, null, java.awt.Color.cyan));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 236, 234));
        jLabel4.setText("Informations du patient");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.cyan, null, java.awt.Color.cyan));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        accesExamenButton.setBackground(new java.awt.Color(255, 255, 255));
        accesExamenButton.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        accesExamenButton.setForeground(new java.awt.Color(102, 102, 102));
        accesExamenButton.setText("Consulter Examen");
        accesExamenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesExamenButtonActionPerformed(evt);
            }
        });

        filtreExamCombo.setBackground(new java.awt.Color(255, 255, 255));
        filtreExamCombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        filtreExamCombo.setForeground(new java.awt.Color(51, 51, 51));
        filtreExamCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aucun", "Examens en cours", "Examens finis" }));
        filtreExamCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtreExamComboActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(242, 236, 234));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan));
        jPanel4.setPreferredSize(new java.awt.Dimension(49, 49));

        filtreIconLabel.setBackground(new java.awt.Color(255, 255, 255));
        filtreIconLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filtreIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filtreIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(addExamenButton)
                        .addGap(81, 81, 81)
                        .addComponent(accesExamenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtreExamCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(filtreExamCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addExamenButton)
                            .addComponent(jButton2)
                            .addComponent(accesExamenButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        // TODO add your handling code here:
        PageAccueil pgAccueil = null;
        try {
            pgAccueil = new PageAccueil(this.login, conn);
        } catch (SQLException ex) {
            Logger.getLogger(CreationDMR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        pgAccueil.setVisible(true);
        pgAccueil.setLocationRelativeTo(null);
    }//GEN-LAST:event_retourButtonActionPerformed

    private void proDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proDetailsActionPerformed
//    public Examen selectPatTable() throws SQLException {
//        Object ob = examOnePatientTable.getValueAt(examOnePatientTable.getSelectedRow(), examOnePatientTable.getSelectedColumn());
//        Patient pat = null;
//        for (int i=0;i< examOnePatientTable.getColumnCount();i++){
//            pat=RequetesBDExamen.storeOnePatientInfo(examOnePatientTable.getValueAt(examOnePatientTable.getSelectedRow(),0).toString(), conn);
//        }
//        System.out.println(pat.toString());
//        return pat;
//
//    }
    private void deconnexionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionButtonActionPerformed
        // TODO add your handling code here:        
        int retour = JOptionPane.showConfirmDialog(this, "Etes-vous sur de vouloir vous déconnecter ? ", "", JOptionPane.YES_NO_OPTION);
        System.out.println("retour= " + retour);
        if (retour == 0) {
            Connexion connexion = null;
            try {
                connexion = new Connexion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
            connexion.setVisible(true);
            connexion.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_deconnexionButtonActionPerformed

    private void accesExamenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesExamenButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Examen exam = selectExamTable();
            AffichageExamen affichageExamen = new AffichageExamen(exam, pat, login, conn);
            this.setVisible(false);
            affichageExamen.setVisible(true);
            affichageExamen.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_accesExamenButtonActionPerformed

    private void addExamenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExamenButtonActionPerformed
        // TODO add your handling code here:
        AjouterExamen addExamen = null;
        addExamen = new AjouterExamen(login, pat, conn);
        this.setVisible(false);
        addExamen.setVisible(true);
        addExamen.setLocationRelativeTo(null);

    }//GEN-LAST:event_addExamenButtonActionPerformed

    public DefaultTableModel setModelJTableCurrent(Patient pat) throws SQLException {
        ArrayList<Object[]> infoExamOnePatient = RequetesBDExamen.RechercherExamenPatientCurrent(pat.getPatientId(), conn);
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();

        model.addColumn("Date d'examen");
        model.addColumn("Type");
        model.addColumn("Praticien responsable");

        for (Object[] infoExam : infoExamOnePatient) {
            model.addRow(infoExam);

        }

        return model;
    }

    public DefaultTableModel setModelJTableCompleted(Patient pat) throws SQLException {
        ArrayList<Object[]> infoExamOnePatient = RequetesBDExamen.RechercherExamenPatientCompleted(pat.getPatientId(), conn);
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();

        model.addColumn("Date d'examen");
        model.addColumn("Type");
        model.addColumn("Praticien responsable");

        for (Object[] infoExam : infoExamOnePatient) {
            model.addRow(infoExam);

        }

        return model;
    }

    private void filtreExamComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtreExamComboActionPerformed
        // TODO add your handling code here:
        if (filtreExamCombo.getSelectedItem().equals("Examens en cours")) {
            try {
                examOnePatientTable.setModel(this.setModelJTableCurrent(this.pat));
                examOnePatientTable.setRowHeight(30);
                examOnePatientTable.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));
            } catch (SQLException ex) {
                Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            if (filtreExamCombo.getSelectedItem().equals("Examens finis")) {
                try {
                    examOnePatientTable.setModel(this.setModelJTableCompleted(this.pat));
                } catch (SQLException ex) {
                    Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
                }
                examOnePatientTable.setRowHeight(30);
                examOnePatientTable.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));
            } else {
                try {
                    examOnePatientTable.setModel(this.setModelJTable(this.pat));
                } catch (SQLException ex) {
                    Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
                }
                examOnePatientTable.setRowHeight(30);
                examOnePatientTable.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));
            }
        }


    }//GEN-LAST:event_filtreExamComboActionPerformed

    public Examen selectExamTable() throws SQLException {
        Object ob = examOnePatientTable.getValueAt(examOnePatientTable.getSelectedRow(), examOnePatientTable.getSelectedColumn());
        System.out.println("examOnePatientTable.getSelectedColumn()= " + examOnePatientTable.getSelectedColumn());
        Examen exam = null;
        //for (int i = 0; i < examOnePatientTable.getColumnCount(); i++) {
        System.out.println("YEP");
        String dExam = examOnePatientTable.getValueAt(examOnePatientTable.getSelectedRow(), 0).toString().substring(2, 16);
        System.out.println("dexam= " + dExam);
        String[] dExamSplit = dExam.split(" ");
        String dateExamen = dExamSplit[0];
        String[] date = dateExamen.split("-");
        String dselect = date[2] + "-" + date[1] + "-" + date[0] + " " + dExamSplit[1];
        System.out.println("dselect= " + dselect);
        System.out.println("");
        exam = RequetesBDExamen.storeOneExamInfo(dselect, conn);

        //}
        //System.out.println(exam.toString());
        return exam;

    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AccesListeExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AccesListeExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AccesListeExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AccesListeExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AccesListeExamen().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accesExamenButton;
    private javax.swing.JButton addExamenButton;
    private javax.swing.JTextField adressField;
    private javax.swing.JTextField birthDateField;
    private javax.swing.JButton deconnexionButton;
    private javax.swing.JTable examOnePatientTable;
    private javax.swing.JComboBox<String> filtreExamCombo;
    private javax.swing.JLabel filtreIconLabel;
    private javax.swing.JTextField firstNamePField;
    private javax.swing.JTextField genderField;
    private javax.swing.JTextField idPField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField lastNamePField;
    private javax.swing.JLabel logoIcon;
    private javax.swing.JTextField proDetails;
    private javax.swing.JButton retourButton;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
