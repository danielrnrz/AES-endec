/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_encdec;

import sun.misc.BASE64Decoder;

import java.security.MessageDigest;
import java.security.spec.KeySpec;
import sun.misc.*;
import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author daniel
 */
public class encryption {
    
private SecretKey key;
    private KeySpec keyspec;
    Cipher ecipher;
    
    
public String encrypt_message(String message, String cle) throws Exception
{
        byte[] keyarray;
        BASE64Encoder enc = new BASE64Encoder();
        byte[] toencryptarray = message.getBytes("UTF-8");
        keyarray = cle.getBytes("UTF-8");
        keyspec = new SecretKeySpec(keyarray,"aes");
        key = SecretKeyFactory.getInstance("AES").generateSecret(keyspec);
        ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[16]);
        ecipher.init(Cipher.ENCRYPT_MODE,key,iv);
        byte[] encrypted = ecipher.doFinal(toencryptarray);
        String encryptedtext = enc.encodeBuffer(encrypted);
        return encryptedtext;
        
    
}

}
