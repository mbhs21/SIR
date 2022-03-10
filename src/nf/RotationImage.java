/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Benhadj
 */
public class RotationImage {

    public static BufferedImage rotateImage(BufferedImage imageToRotate) {
        int widthOfImage = imageToRotate.getWidth();
        int heightOfImage = imageToRotate.getHeight();
        int typeOfImage = imageToRotate.getType();

        BufferedImage newImageFromBuffer = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);

        Graphics2D graphics2D = newImageFromBuffer.createGraphics();

        graphics2D.rotate(Math.toRadians(90), widthOfImage / 2, heightOfImage / 2);
        graphics2D.drawImage(imageToRotate, null, 0, 0);

        return newImageFromBuffer;
    }

    public static void writeRotateImage(BufferedImage originalImage, String nameOriginalImage) throws IOException {
        
        BufferedImage subImage = rotateImage(originalImage);

        File rotatedImageFile = new File(nameOriginalImage);

        ImageIO.write(subImage, "jpg", rotatedImageFile);

        System.out.println("New Rotated Image File Path: " + rotatedImageFile.getPath());
    }

    public static void main(String[] args) {

        try {

            BufferedImage originalImage = ImageIO.read(new File("./src/img_numerisees_jpg/sinus/sinus1_0000.jpg"));

            writeRotateImage(originalImage,"./src/img_numerisees_jpg/sinus/sinus1_0000.jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
