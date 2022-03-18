/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Benhadj
 */
public class ConnexionSGBD {

    private static final String configurationFile
            = "MaBD.properties.txt";

    public static void main(String args[]) throws SQLException {
        try {
            String jdbcDriver, dbUrl, username, password;
            List<String> PWList;
            DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            jdbcDriver = dap.getJdbcDriver();
            dbUrl = dap.getDatabaseUrl();
            username = dap.getUsername();
            password = dap.getPassword();

            // Load the database driver
            Class.forName(jdbcDriver);

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Nb image Ex01: "+RequetesBDPACS.returnNbImgOneExam("EX01", conn) );
            
//            String str = "02";
//            boolean isNumeric = true;
//            for (int i = 0; i < str.length(); i++) {
//                if (!Character.isDigit(str.charAt(i))) {
//                    isNumeric = false;
//                }
//            }
//            System.out.println(isNumeric);
//            System.out.println(isNumeric);
//            String monthField = "02";
//            String dayField = "01";
//
//            boolean isValid = true;
//
//            int d = Integer.parseInt(dayField);
//            int month=Integer.parseInt(monthField);
//            if (d < 1 || d > 31) {
//                isValid = false;
//            } else {
//                if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
//                    isValid = (d > 0 && d < 32);
//                } else {
//                    if (month==2) {
//                        isValid = (d > 0 && d < 29);
//                    } else {
//                        if (month==4 || month==6 || month==9 || month==11) {
//                            isValid = (d > 0 && d < 31);
//                        }else{
//                            isValid=false;
//                        }
//                    }
//                }
//            }
//            String ph = "PH02";
//            if (ph.substring(0, 2).toUpperCase().equals("PH")) {
//                System.out.println(RequetesBDLogin.returnProId(ph, conn) != null);
//            }else{
//                System.out.println("false");
//            }
            //RequetesBDLogin.returnInfoIdPro("PH01", conn);
//            ArrayList<Object[]> infosPatients=RequetesBDPatient.returnInfoPatients(conn);
//            for (Object[] infosPatient : infosPatients) {
//                for (Object infosPatient1 : infosPatient) {
//                    System.out.print(infosPatient1);
//                }
//                System.out.println("");
//            }
//            Date dte=new Date(117,7,3);           
//            System.out.println("dte= "+dte.toString());
//            //RequetesBDPatient.RechercherPatient("BRESSON", "Jade",dte ,conn);
//            System.out.println("latestPatient: " + RequetesBDPatient.latestPatientSave(conn));
//
//            System.out.println("new Id = " + RequetesBDPatient.generatePatientId(conn));
//
//            Date dte = new Date(105, 7, 3);
//            Patient pat = new Patient("SARTRE", "Bertrand", "14 boulevard Jean Jaures, Grenoble", "M", dte);
////         RequetesBDPatient.addPatientBD(pat,conn);
//
//            System.out.println("patient existe ? " + RequetesBDPatient.patientExist("SARTRE", "Bertrand", dte, conn));
//            ArrayList<Object[]> infoExamOnePatient = RequetesBDExamen.RechercherExamenPatientID("PAT01", conn);
//            for (Object[] infosPatient : infoExamOnePatient) {
//                for (Object infosPatient1 : infosPatient) {
//                    System.out.print(infosPatient1);
//                }
//                System.out.println("");
//            }
//                String dExam="2016-06-11 20:05:58.0";
//                String[] dExamSplit=dExam.split(" ");
//                String dateExamen=dExamSplit[0];
//                System.out.println("date examen split ="+dateExamen);
//                
//                String[] date=dateExamen.split("-");
//                int year=Integer.parseInt(date[0]);
//                int month=Integer.parseInt(date[1]);
//                int day=Integer.parseInt(date[2]);
//                
//                Date d=new Date(year-1900,month-1,day);
//                System.out.println(d.toString());
//            String dExam="15-10-21 08:35";
//            String[] dExamSplit=dExam.split(" ");
//            String dateExamen = dExamSplit[0];
//            String[] date=dateExamen.split("-");
//            String d=date[2]+"-"+date[1]+"-"+date[0]+" "+dExamSplit[1];
//            System.out.println("d= "+d);
//            Examen exam = RequetesBDExamen.storeOneExamInfo(d, conn);
//            System.out.println("examen: " + exam.toString());
//            RequetesBDPACS.returnPACSoneExam("EX01", conn);

//            
//            String dateTime = "2022-12-12 23:28:00";
//
//            Timestamp timestamp = Timestamp.valueOf(dateTime);
//            System.out.println(timestamp);
//
//            Examen examen = new Examen("PAT02", "PH02", "ECHO", timestamp);
//            RequetesBDExamen.addExamBD(examen, conn);
            //           RequetesBDPatient.RechercherPiD("PAT02", conn);
//            PWList=RequetesBDLogin.storeProId(conn);
//            for (String pw:PWList){
//                System.out.println("PW : "+pw);
//            }
//            System.out.println("");
//             
//            PWList=RequetesBDLogin.storePassword(conn);
//            for (String pw:PWList){
//                System.out.println("PWList : "+pw);
//            }
//            System.out.println("");
            //requetesbd.displaySpectacleRep(102, conn);
            /*Date date=new Date();
            System.out.println("date: "+date.toString());
            requetesbd.addDateRep(101,date,conn);
             */
// Print information about connection warnings
            SQLWarningsExceptions.printWarnings(conn);
            conn.close();

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }
}
