package Spectre.MHS.com;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public String Encrypt(String message) throws NoSuchAlgorithmException {
        return  Hash(message);
    }
    private String Hash(String message){

        String output = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = md.digest(message.getBytes());
            StringBuilder s = new StringBuilder();
            for(int i=0; i<bytes.length; i++){
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            output = s.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return output;
    }
}