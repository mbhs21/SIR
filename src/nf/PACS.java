/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Benhadj
 */
public class PACS {
    
    private String pacsId;
    private String examId;
    private byte[] image;
    private String comments;

    public PACS (String pacsId, String examId, String comments){
        this.pacsId=pacsId;
        this.examId=examId;
        this.comments=comments;
    }
    
    /**
     * @return the pacsId
     */
    public String getPacsId() {
        return pacsId;
    }

    /**
     * @param pacsId the pacsId to set
     */
    public void setPacsId(String pacsId) {
        this.pacsId = pacsId;
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
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
   

}
