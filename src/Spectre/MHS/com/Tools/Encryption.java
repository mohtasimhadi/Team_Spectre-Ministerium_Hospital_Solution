package Spectre.MHS.com.Tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    public String encrypt(String message){

        String output = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

            byte[] bytes = messageDigest.digest(message.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            output = stringBuilder.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return output;
    }
}