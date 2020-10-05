package org.rldevelopement.paladecrypter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Decrypter {

    public static byte[] decrypt(File input) {
        try {
            Key secretKey = new SecretKeySpec("dK5rcm5RuMBETH5C".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKey);
            FileInputStream inputStream = new FileInputStream(input);
            byte[] inpBytes = new byte[(int) input.length()];
            inputStream.read(inpBytes);
            byte[] outputBytes = cipher.doFinal(inpBytes);
            inputStream.close();
            return outputBytes;
        } catch (IllegalBlockSizeException | IOException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

}
