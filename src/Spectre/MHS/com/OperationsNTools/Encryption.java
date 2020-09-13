package Spectre.MHS.com.OperationsNTools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

/*
    public String Encrypt(String message) {
        return  Hash(message);
    }
*/
    public String encrypt(String message){

        String output = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = md.digest(message.getBytes());
            StringBuilder s = new StringBuilder();
            for (byte aByte : bytes) {
                s.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            output = s.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return output;
    }
}

class UnitTestEncryption {
    @Test
    void passwordTest(){
        Encryption encryption = new Encryption();
        Assertions.assertEquals("7110eda4d09e062aa5e4a390b0a572ac0d2c0220", encryption.encrypt("1234"));

    }
}