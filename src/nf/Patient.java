/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Benhadj
 */
public class Patient {

    /**
     *
     */
    private String patientId;

    /**
     *
     */
    private String lastNameP;

    /**
     *
     */
    private String firstNameP;

    /**
     *
     */
    private String adress;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private String birthDate;

    
    /**
     * 
     * Constructeur Patient
     * Initialise le patient à null
     * 
     */
    public Patient() {
        this.patientId = null;
        this.lastNameP = null;
        this.firstNameP = null;
        this.adress = null;
        this.gender = null;
        this.birthDate = null;
    }

    /**
     * 
     * Constructeur Patient
     * Initiale le patient à null
     * 
     * @param patientId identifiant du patient
     * @param lastNameP nom du patient
     * @param firstNameP prénom du patient
     * @param adress adresse du patient
     * @param gender sexe du patient
     * @param birthDate date de naissance du patient YYYY-MM-DD
     */
    public Patient(String patientId, String lastNameP, String firstNameP, String adress, String gender, String birthDate) {
        this.patientId = patientId;
        this.lastNameP = lastNameP;
        this.firstNameP = firstNameP;
        this.adress = adress;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    
    /**
     * 
     * Constructeur Patient
     * Initiale le patient à null
     * 
     * @param patientId identifiant du patient
     * @param lastNameP nom du patient
     * @param firstNameP prénom du patient
     * @param birthDate date de naissance du patient YYYY-MM-DD
     */
    public Patient(String patientId, String lastNameP, String firstNameP, String birthDate) {
        this.patientId = patientId;
        this.lastNameP = lastNameP;
        this.firstNameP = firstNameP;
        this.birthDate = birthDate;
    }

    
    /**
     * 
     * Constructeur Patient
     * Initiale le patient à null
     * 
     * @param lastNameP nom du patient
     * @param firstNameP prénom du patient
     * @param adress adresse du patient
     * @param gender sexe du patient
     * @param birthDate date de naissance du patient YYYY-MM-DD
     */
    public Patient(String lastNameP, String firstNameP, String adress, String gender, String birthDate) {
        this.lastNameP = lastNameP;
        this.firstNameP = firstNameP;
        this.adress = adress;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    /**
     * Permet d'écrire les informations du patient de manière textuelle
     *
     * @return une chaîne de caractère
     */
    @Override
    public String toString() {
        String str;
        str = "patientId =" + this.patientId + "\n"
                + "lastNameP = " + this.lastNameP + "\n"
                + "firstNameP = " + this.firstNameP + "\n"
                + "adress = " + this.adress + "\n"
                + "gender = " + this.gender + "\n"
                + "birthDate = " + this.birthDate.toString();
        return str;
    }

    /**
     * Permet d'obtenir les informations du patient sous la forme [[id du
     * patient, nom du patient, prénom du patient, date de naissance]]
     *
     * @return une liste contenant un tableau comportant les informations d'un
     * patient
     */
    public ArrayList<Object[]> ArrayOnePatient() {
        ArrayList<Object[]> infoOnePatient = new ArrayList<>();
        Object[] info = new Object[4];
        info[0] = this.patientId;
        info[1] = this.lastNameP;
        info[2] = this.firstNameP;
        info[4] = this.birthDate;
        infoOnePatient.set(0, info);
        return infoOnePatient;
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

    /**
     * @return the lastNameP
     */
    public String getLastNameP() {
        return lastNameP;
    }

    /**
     * @param lastNameP the lastNameP to set
     */
    public void setLastNameP(String lastNameP) {
        this.lastNameP = lastNameP;
    }

    /**
     * @return the firstNameP
     */
    public String getFirstNameP() {
        return firstNameP;
    }

    /**
     * @param firstNameP the firstNameP to set
     */
    public void setFirstNameP(String firstNameP) {
        this.firstNameP = firstNameP;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

}
