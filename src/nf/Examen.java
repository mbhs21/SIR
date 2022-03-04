/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Benhadj
 */
public class Examen {

    private String examId;
    private String patientId;
    private String proId;
    private String typeExamen;
    private String report;
    private Timestamp dateExam;
    private int status;

    public Examen(String examId, String patientId, String proId, String typeExamen, String report, Timestamp dateExam) {
        this.examId = examId;
        this.patientId = patientId;
        this.proId = proId;
        this.typeExamen = typeExamen;
        this.report = report;
        this.dateExam = dateExam;
    }

    public Examen(String patientId, String proId, String typeExamen, Timestamp dateExam) {
        this.patientId = patientId;
        this.proId = proId;
        this.typeExamen = typeExamen;

        this.dateExam = dateExam;
    }

    public boolean checkDateNumeric(String str) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        System.out.println(isNumeric);
        return isNumeric;
    }

    /**
     * Permet d'écrire les informations du patient de manière textuelle
     *
     * @return une chaîne de caractère
     */
    @Override
    public String toString() {
        String str;
        str = "examId =" + this.examId + "\n"
                + "patientId = " + this.patientId + "\n"
                + "proId = " + this.proId + "\n"
                + "typeExamen = " + this.typeExamen + "\n"
                + "dateExam = " + this.dateExam.toString() + "\n";
                
        return str;
    }

    /**
     * @return the examId
     */
    public String getExamId() {
        return examId;
    }

    /**
     * @param examId the examId to set
     */
    public void setExamId(String examId) {
        this.examId = examId;
    }

    /**
     * @return the proId
     */
    public String getProId() {
        return proId;
    }

    /**
     * @param proId the proId to set
     */
    public void setProId(String proId) {
        this.proId = proId;
    }

    /**
     * @return the typeExamen
     */
    public String getTypeExamen() {
        return typeExamen;
    }

    /**
     * @param typeExamen the typeExamen to set
     */
    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    /**
     * @return the report
     */
    public String getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * @return the d
     */
    public Timestamp getDateExam() {
        return dateExam;
    }

    /**
     * @param d the d to set
     */
    public void setDateExam(Timestamp d) {
        this.dateExam = d;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

}
