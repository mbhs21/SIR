/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Optional;

/**
 *
 * @author Benhadj
 */
public class Encryption {

    
    private static final SecureRandom RAND = new SecureRandom();
    private static final int ITERATIONS = 100;
    private static final int KEY_LENGTH = 128;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512";

    
     /**
     * encrypt the password 
     * @param length
     * @return a random data very often used in cryptography as additional input to a hash function.
    */
    public static Optional<String> generateSalt(final int length) {

        if (length < 1) {
            System.err.println("error in generateSalt: length must be > 0");
            return Optional.empty();
        }

        byte[] salt = new byte[length];
        RAND.nextBytes(salt);

        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }
    
    
    /**
     * encrypt the password 
     * @param password
     * @param salt is a random data very often used in cryptography as additional input to a hash function.
     * @return the password
    */
    public static Optional<String> hashPassword(String password, String salt) {

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));

        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            return Optional.empty();

        } finally {
            spec.clearPassword();
        }
    }

    
    /**
     * verify if the password equals the the password decrypted
     * @param password
     * @param key is the password crypted
     * @param salt is a random data very often used in cryptography as additional input to a hash function.
     * @return the password
    */
    public static boolean verifyPassword(String password, String key, String salt) {
        Optional<String> optEncrypted = hashPassword(password, salt);
        if (!optEncrypted.isPresent()) {
            return false;
        }
        return optEncrypted.get().equals(key);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        String salt = generateSalt(512).get();
//        String pw = "PR01test";
//        String key = hashPassword(pw, Salt.SALT).get();
//        System.out.println(key);
////        System.out.println(verifyPassword("toto", key, Salt.SALT));
////        System.out.println(verifyPassword("dqlkdkql", key, Salt.SALT));
////        System.out.println(verifyPassword("lala", key, Salt.SALT));
//
//        String jdbcDriver, dbUrl, username, password;
//        HashMap<String, String> dicoIdMP;
//        DatabaseAccessProperties dap = new DatabaseAccessProperties("MaBD.properties.txt");
//        jdbcDriver = dap.getJdbcDriver();
//        dbUrl = dap.getDatabaseUrl();
//        username = dap.getUsername();
//        password = dap.getPassword();
//
//        // Load the database driver
//        Class.forName(jdbcDriver);
//
//        // Get a connection to the database
//        Connection conn = DriverManager.getConnection(dbUrl, username, password);
//
//        dicoIdMP = RequetesBDLogin.storeIdPassword(conn);
//        //idList = RequetesBDLogin.storeProId(conn);
//        for (HashMap.Entry<String, String> entry : dicoIdMP.entrySet()) {
//            String id = entry.getKey();
//            String mp = entry.getValue();
//            System.out.println(id + " " + mp);
//        }
//        System.out.println("");
//
//        RequetesBDLogin.updatePWproId("PR01", key, conn);
//
//        String PWencrypt = RequetesBDLogin.returnPWproId("PR01", conn);
//        System.out.println("PW encrypt =" + PWencrypt);
//        System.out.println(verifyPassword(pw, key, Salt.SALT));
//
//    }

}
