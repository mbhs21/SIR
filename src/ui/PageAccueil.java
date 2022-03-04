/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;
import nf.Login;
import nf.Patient;
import nf.RequetesBDLogin;
import nf.RequetesBDPatient;

/**
 *
 * @author em
 */
public class PageAccueil extends javax.swing.JFrame {

    Login login;
    Connection conn;
    Patient pat;

    /**
     * Creates new form PageAccueil
     *
     *
     * @param login
     * @param conn
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public PageAccueil(Login login, Connection conn) throws IOException, SQLException {
        this.login = login;
        this.conn = conn;

        initComponents();

//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        this.pack();
//        this.setSize(screenSize.width - 100, screenSize.height - 50);
//        jPanel2.setSize(screenSize.width - 100, screenSize.height - 50);
        this.setResizable(false);

        proDetails.setText(login.getLogin().strip()
                + " - " + login.getLastName().strip()
                + " " + login.getFirstName().strip()
        );
//        System.out.println("pgConnexion.login.getLastName().strip() " + pgConnexion.login.getLastName().strip());
//        System.out.println("pgConnexion.login.getFirstName().strip() " + pgConnexion.login.getFirstName().strip());
//        FirstNameLogin.setText("Prénom: " + pgConnexion.login.getFirstName().strip());
//        IdLogin.setText("identifiant: " + pgConnexion.login.getLogin().strip());

        tableAllPatient.setModel(this.setModelJTable());
        tableAllPatient.setRowHeight(30);
        tableAllPatient.setPreferredSize(new java.awt.Dimension(300, 30 * tableAllPatient.getRowCount()));

        ImageIcon icone = new ImageIcon("src/img_icon/user_1.png");
        java.awt.Image img = icone.getImage();
        java.awt.Image newImg = img.getScaledInstance(jLabel17.getWidth(), jLabel17.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(newImg);
        jLabel17.setIcon(icone);

        ImageIcon iconeSearch = new ImageIcon("src/img_icon/loupe_1.png");
        java.awt.Image imgSearch = iconeSearch.getImage();
        java.awt.Image newImgSearch = imgSearch.getScaledInstance(ResearchButton.getHeight(), ResearchButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeSearch = new ImageIcon(newImgSearch);
        ResearchButton.setIcon(iconeSearch);

        ImageIcon iconeAddPat = new ImageIcon("src/img_icon/add.png");
        java.awt.Image imgAddPat = iconeAddPat.getImage();
        java.awt.Image newImgAddPat = imgAddPat.getScaledInstance(AddPatientButton.getHeight(), AddPatientButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeAddPat = new ImageIcon(newImgAddPat);
        AddPatientButton.setIcon(iconeAddPat);

        ImageIcon iconeDeconnection = new ImageIcon("src/img_icon/deconnexion.png");
        java.awt.Image imgDeconnection = iconeDeconnection.getImage();
        java.awt.Image newImgDeconnection = imgDeconnection.getScaledInstance(deconnectionButton.getHeight(), deconnectionButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeDeconnection = new ImageIcon(newImgDeconnection);
        deconnectionButton.setIcon(iconeDeconnection);

        ImageIcon iconeLogo = new ImageIcon("src/img_icon/logo.png");
        java.awt.Image imgLogo = iconeLogo.getImage();
        java.awt.Image newImgLogo = imgLogo.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeLogo = new ImageIcon(newImgLogo);
        jLabel1.setIcon(iconeLogo);

        ImageIcon iconeValidate = new ImageIcon("src/img_icon/check.png");
        java.awt.Image imgValidate = iconeValidate.getImage();
        java.awt.Image newImgValidate = imgValidate.getScaledInstance(validateButton.getWidth(), validateButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeValidate = new ImageIcon(newImgValidate);
        validateButton.setIcon(iconeValidate);

        ImageIcon iconeReset = new ImageIcon("src/img_icon/loading.png");
        java.awt.Image imgReset = iconeReset.getImage();
        java.awt.Image newImgReset = imgReset.getScaledInstance(resetButton.getWidth(), resetButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeReset = new ImageIcon(newImgReset);
        resetButton.setIcon(iconeReset);

        ImageIcon iconeAccessDMR = new ImageIcon("src/img_icon/file.png");
        java.awt.Image imgAccessDMR = iconeAccessDMR.getImage();
        java.awt.Image newImgAccessDMR = imgAccessDMR.getScaledInstance(accessDMRButton.getHeight(), accessDMRButton.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconeAccessDMR = new ImageIcon(newImgAccessDMR);
        accessDMRButton.setIcon(iconeAccessDMR);

        tableAllPatient.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));

        lastNamePField.setEditable(false);
        lastNamePLabel.setForeground(new Color(225, 201, 176));
        firstNamePField.setEditable(false);
        firstNamePLabel.setForeground(new Color(225, 201, 176));
        dayField.setEditable(false);
        monthField.setEditable(false);
        yearField.setEditable(false);
        birthDateLabel.setForeground(new Color(225, 201, 176));
        idPField.setEditable(false);
        idPLabel.setForeground(new Color(225, 201, 176));
        modeSearchComboBox.setEditable(false);
        modeSearchComboBox.setEnabled(false);
        modeSearchLabel.setForeground(new Color(225, 201, 176));
        
        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idSE(login.getLogin(), conn)){
                ResearchButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idPH(login.getLogin(), conn)){
                AddPatientButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // TODO add your handling code here:
            if (RequetesBDLogin.idPR(login.getLogin(), conn)){
                AddPatientButton.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesListeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AddPatientButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllPatient = new javax.swing.JTable();
        ResearchButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        idPLabel = new javax.swing.JLabel();
        firstNamePLabel = new javax.swing.JLabel();
        lastNamePLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        modeSearchLabel = new javax.swing.JLabel();
        modeSearchComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        validateButton = new javax.swing.JButton();
        idPField = new javax.swing.JTextField();
        lastNamePField = new javax.swing.JTextField();
        firstNamePField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        proDetails = new javax.swing.JTextField();
        deconnectionButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        accessDMRButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(1600, 1080));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1502, 748));
        jPanel2.setMinimumSize(new java.awt.Dimension(1502, 748));
        jPanel2.setPreferredSize(new java.awt.Dimension(1490, 794));

        AddPatientButton.setBackground(new java.awt.Color(255, 255, 255));
        AddPatientButton.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        AddPatientButton.setForeground(new java.awt.Color(51, 51, 51));
        AddPatientButton.setText("Ajouter un nouveau patient");
        AddPatientButton.setBorder(null);
        AddPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPatientButtonActionPerformed(evt);
            }
        });

        tableAllPatient.setBackground(new java.awt.Color(255, 255, 255));
        tableAllPatient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray));
        tableAllPatient.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableAllPatient.setForeground(new java.awt.Color(0, 102, 255));
        tableAllPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identifiant", "Nom", "Prénom", "Date de naissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAllPatient.setCellEditor(null);
        tableAllPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableAllPatient.setName(""); // NOI18N
        tableAllPatient.setPreferredSize(new java.awt.Dimension(300, 300));
        tableAllPatient.setSelectionBackground(new java.awt.Color(0, 204, 204));
        tableAllPatient.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAllPatient.setShowHorizontalLines(true);
        tableAllPatient.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableAllPatient);
        tableAllPatient.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        ResearchButton.setBackground(new java.awt.Color(255, 255, 255));
        ResearchButton.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        ResearchButton.setForeground(new java.awt.Color(51, 51, 51));
        ResearchButton.setText("Rechercher");
        ResearchButton.setBorder(null);
        ResearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResearchButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        idPLabel.setBackground(new java.awt.Color(153, 204, 255));
        idPLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        idPLabel.setForeground(new java.awt.Color(102, 102, 102));
        idPLabel.setText("Identifiant :");

        firstNamePLabel.setBackground(new java.awt.Color(153, 204, 255));
        firstNamePLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        firstNamePLabel.setForeground(new java.awt.Color(102, 102, 102));
        firstNamePLabel.setText("Prénom :");

        lastNamePLabel.setBackground(new java.awt.Color(153, 204, 255));
        lastNamePLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lastNamePLabel.setForeground(new java.awt.Color(102, 102, 102));
        lastNamePLabel.setText("NOM :");

        birthDateLabel.setBackground(new java.awt.Color(153, 204, 255));
        birthDateLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        birthDateLabel.setForeground(new java.awt.Color(102, 102, 102));
        birthDateLabel.setText("Date de Naissance :");

        modeSearchLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        modeSearchLabel.setForeground(new java.awt.Color(102, 102, 102));
        modeSearchLabel.setText("Rechercher par ...");

        modeSearchComboBox.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N
        modeSearchComboBox.setForeground(new java.awt.Color(0, 0, 0));
        modeSearchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Identifiant", "Nom / prénom et date de Naissance", "Tout" }));
        modeSearchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeSearchComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("/");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("/");

        validateButton.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        idPField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        lastNamePField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        firstNamePField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        dayField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        monthField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        yearField.setFont(new java.awt.Font("Candara", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(modeSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(modeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(idPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(idPField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lastNamePLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(firstNamePLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lastNamePField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                                .addComponent(firstNamePField)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(birthDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeSearchLabel)
                    .addComponent(modeSearchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPLabel))
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNamePLabel)
                    .addComponent(lastNamePField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNamePField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNamePLabel))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthDateLabel)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(242, 236, 234));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.cyan));

        jLabel16.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Health IT");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Big John", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Accueil");

        jPanel1.setBackground(new java.awt.Color(242, 236, 234));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        proDetails.setEditable(false);
        proDetails.setBackground(new java.awt.Color(255, 255, 255));
        proDetails.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        proDetails.setForeground(new java.awt.Color(0, 0, 0));
        proDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, java.awt.Color.white));
        proDetails.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        proDetails.setName(""); // NOI18N
        proDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proDetailsActionPerformed(evt);
            }
        });

        deconnectionButton.setBackground(new java.awt.Color(255, 255, 255));
        deconnectionButton.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        deconnectionButton.setForeground(new java.awt.Color(102, 153, 255));
        deconnectionButton.setText("Se déconnecter");
        deconnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnectionButtonActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(225, 201, 176));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(320, 320, 320)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(proDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deconnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(proDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(deconnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel16))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        proDetails.getAccessibleContext().setAccessibleName("");

        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        accessDMRButton.setBackground(new java.awt.Color(255, 255, 255));
        accessDMRButton.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        accessDMRButton.setForeground(new java.awt.Color(51, 51, 51));
        accessDMRButton.setText("Accès DMR");
        accessDMRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessDMRButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ResearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(517, 517, 517)
                                .addComponent(accessDMRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jLabel2))
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ResearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(557, 557, 557))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(accessDMRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1502, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResearchButtonActionPerformed
        // TODO add your handling code here:
        modeSearchComboBox.setEnabled(true);
        modeSearchLabel.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_ResearchButtonActionPerformed

    private void deconnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnectionButtonActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_deconnectionButtonActionPerformed

    private void proDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proDetailsActionPerformed
        // TODO add your handling code here:
        //NameLogin.setText(login.getLastName());
    }//GEN-LAST:event_proDetailsActionPerformed

    private void modeSearchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeSearchComboBoxActionPerformed
        // TODO add your handling code here:
        if (modeSearchComboBox.getSelectedItem().equals("Identifiant")) {
            lastNamePField.setEditable(false);
            lastNamePLabel.setForeground(new Color(225, 201, 176));
            firstNamePField.setEditable(false);
            firstNamePLabel.setForeground(new Color(225, 201, 176));
            dayField.setEditable(false);
            monthField.setEditable(false);
            yearField.setEditable(false);
            birthDateLabel.setForeground(new Color(225, 201, 176));
            idPField.setEditable(true);
            idPLabel.setForeground(new Color(102, 102, 102));
        } else {
            if (modeSearchComboBox.getSelectedItem().equals("Nom / prénom et date de Naissance")) {
                idPField.setEditable(false);
                idPLabel.setForeground(new Color(225, 201, 176));
                lastNamePField.setEditable(true);
                lastNamePLabel.setForeground(new Color(102, 102, 102));
                firstNamePField.setEditable(true);
                firstNamePLabel.setForeground(new Color(102, 102, 102));
                dayField.setEditable(true);
                monthField.setEditable(true);
                yearField.setEditable(true);
                birthDateLabel.setForeground(new Color(102, 102, 102));
            } else {
                if (modeSearchComboBox.getSelectedItem().equals("Tout")) {
                    idPField.setEditable(true);
                    idPLabel.setForeground(new Color(102, 102, 102));
                    lastNamePField.setEditable(true);
                    lastNamePLabel.setForeground(new Color(102, 102, 102));
                    firstNamePField.setEditable(true);
                    firstNamePLabel.setForeground(new Color(102, 102, 102));
                    dayField.setEditable(true);
                    monthField.setEditable(true);
                    yearField.setEditable(true);
                    birthDateLabel.setForeground(new Color(102, 102, 102));
                } else {
                    lastNamePField.setEditable(false);
                    lastNamePLabel.setForeground(new Color(225, 201, 176));
                    firstNamePField.setEditable(false);
                    firstNamePLabel.setForeground(new Color(225, 201, 176));
                    dayField.setEditable(false);
                    monthField.setEditable(false);
                    yearField.setEditable(false);
                    birthDateLabel.setForeground(new Color(225, 201, 176));
                    idPField.setEditable(true);
                    idPLabel.setForeground(new Color(225, 201, 176));
                }
            }
        }
    }//GEN-LAST:event_modeSearchComboBoxActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<Object[]> infoPatient = new ArrayList<>();
        if (modeSearchComboBox.getSelectedItem().equals("Identifiant")) {
            if (!idPField.getText().isEmpty()) {

                try {

                    infoPatient = RequetesBDPatient.RechercherPatientID(idPField.getText(), conn);
                } catch (SQLException ex) {
                    Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
                }
                DefaultTableModel model = new javax.swing.table.DefaultTableModel();

                model.addColumn("Identifiant");
                model.addColumn("Nom");
                model.addColumn("Prénom");
                model.addColumn("Date de naissance");

                for (Object[] infoPat : infoPatient) {
                    model.addRow(infoPat);

                }
                tableAllPatient.setModel(model);
                tableAllPatient.setRowHeight(30);
                tableAllPatient.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));

            } else {
                JOptionPane.showMessageDialog(null, "Le champ identifiant doit être complété", "", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            if (modeSearchComboBox.getSelectedItem().equals("Nom / prénom et date de Naissance")) {
                if (!lastNamePField.getText().isEmpty() & !firstNamePField.getText().isEmpty() & !dayField.getText().isEmpty() & !monthField.getText().isEmpty() & !yearField.getText().isEmpty()) {
                    int day = Integer.parseInt(dayField.getText());
                    int month = Integer.parseInt(monthField.getText());
                    int year = Integer.parseInt(yearField.getText());

                    Date birthDate = new Date(year - 1900, month - 1, day);
                    try {
                        infoPatient = RequetesBDPatient.RechercherPatientName(lastNamePField.getText().toUpperCase(), firstNamePField.getText(), birthDate, conn);
                    } catch (SQLException ex) {
                        Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    DefaultTableModel model = new javax.swing.table.DefaultTableModel();

                    model.addColumn("Identifiant");
                    model.addColumn("Nom");
                    model.addColumn("Prénom");
                    model.addColumn("Date de naissance");

                    for (Object[] infoPat : infoPatient) {
                        model.addRow(infoPat);

                    }
                    tableAllPatient.setModel(model);
                    tableAllPatient.setRowHeight(30);
                    tableAllPatient.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));
                } else {
                    JOptionPane.showMessageDialog(null, "Les champs Nom, Prénom et date de naissance doivent être complétés", "", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                if (modeSearchComboBox.getSelectedItem().equals("Tout")) {
                    if (!idPField.getText().isEmpty() & !lastNamePField.getText().isEmpty() & !firstNamePField.getText().isEmpty() & !dayField.getText().isEmpty() & !monthField.getText().isEmpty() & !yearField.getText().isEmpty()) {
                        int day = Integer.parseInt(dayField.getText());
                        int month = Integer.parseInt(monthField.getText());
                        int year = Integer.parseInt(yearField.getText());

                        Date birthDate = new Date(year - 1900, month - 1, day);
                        try {
                            infoPatient = RequetesBDPatient.RechercherPatient(idPField.getText(), lastNamePField.getText(), firstNamePField.getText(), birthDate, conn);
                        } catch (SQLException ex) {
                            Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        DefaultTableModel model = new javax.swing.table.DefaultTableModel();

                        model.addColumn("Identifiant");
                        model.addColumn("Nom");
                        model.addColumn("Prénom");
                        model.addColumn("Date de naissance");

                        for (Object[] infoPat : infoPatient) {
                            model.addRow(infoPat);

                        }
                        tableAllPatient.setModel(model);
                        tableAllPatient.setRowHeight(30);
                        tableAllPatient.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));
                    } else {
                        JOptionPane.showMessageDialog(null, "Tous les champs doivent être complétés", "", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        }
        lastNamePField.setText("");
        lastNamePField.setEditable(false);
        lastNamePLabel.setForeground(new Color(225, 201, 176));
        firstNamePField.setText("");
        firstNamePField.setEditable(false);
        firstNamePLabel.setForeground(new Color(225, 201, 176));
        dayField.setText("");
        dayField.setEditable(false);
        monthField.setText("");
        monthField.setEditable(false);
        yearField.setText("");
        yearField.setEditable(false);
        birthDateLabel.setForeground(new Color(225, 201, 176));
        idPField.setText("");
        idPField.setEditable(false);
        idPLabel.setForeground(new Color(225, 201, 176));
        modeSearchComboBox.setEditable(false);
        modeSearchComboBox.setEnabled(false);
        modeSearchLabel.setForeground(new Color(225, 201, 176));


    }//GEN-LAST:event_validateButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        try {
            // TODO add your handling code here:
            tableAllPatient.setModel(this.setModelJTable());
        } catch (SQLException ex) {
            Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableAllPatient.getTableHeader().setFont(new Font("Candara", Font.PLAIN, 18));

    }//GEN-LAST:event_resetButtonActionPerformed

    private void AddPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPatientButtonActionPerformed
        // TODO add your handling code here:
         
        CreationDMR dmr = null;
        dmr = new CreationDMR(login, this.conn);
        this.setVisible(false);
        dmr.setVisible(true);
        dmr.setLocationRelativeTo(null);
    }//GEN-LAST:event_AddPatientButtonActionPerformed

    private void accessDMRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessDMRButtonActionPerformed
        try {
            // TODO add your handling code here:
            Patient pat = selectPatTable();
            AccesListeExamen accesListeExamen = new AccesListeExamen(login, pat, conn);
            this.setVisible(false);
            accesListeExamen.setVisible(true);
            accesListeExamen.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(PageAccueil.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_accessDMRButtonActionPerformed

    public Patient selectPatTable() throws SQLException {
        Object ob = tableAllPatient.getValueAt(tableAllPatient.getSelectedRow(), tableAllPatient.getSelectedColumn());
        Patient pat = null;
        for (int i = 0; i < tableAllPatient.getColumnCount(); i++) {
            pat = RequetesBDPatient.storeOnePatientInfo(tableAllPatient.getValueAt(tableAllPatient.getSelectedRow(), 0).toString(), conn);
        }
        System.out.println(pat.toString());
        return pat;

    }

    public DefaultTableModel setModelJTable() throws SQLException {
        ArrayList<Object[]> infosPatients = RequetesBDPatient.returnInfoPatients(conn);
        DefaultTableModel model = new javax.swing.table.DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;

            }
        
        };

        model.addColumn("Identifiant");
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Date de naissance");

        for (Object[] infoPat : infosPatients) {

            model.addRow(infoPat);

        }
        System.out.println("model size=" + model.getRowCount());
        return model;
    }

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(PageAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PageAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PageAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PageAccueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                PageAccueil pgAcc=new PageAccueil();
//                pgAcc.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPatientButton;
    private javax.swing.JButton ResearchButton;
    private javax.swing.JButton accessDMRButton;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JTextField dayField;
    private javax.swing.JButton deconnectionButton;
    private javax.swing.JTextField firstNamePField;
    private javax.swing.JLabel firstNamePLabel;
    private javax.swing.JTextField idPField;
    private javax.swing.JLabel idPLabel;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNamePField;
    private javax.swing.JLabel lastNamePLabel;
    private javax.swing.JComboBox<String> modeSearchComboBox;
    private javax.swing.JLabel modeSearchLabel;
    private javax.swing.JTextField monthField;
    private javax.swing.JTextField proDetails;
    private javax.swing.JButton resetButton;
    private javax.swing.JTable tableAllPatient;
    private javax.swing.JButton validateButton;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
