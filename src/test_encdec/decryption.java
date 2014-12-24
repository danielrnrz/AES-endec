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


public class decryption {
    
    private SecretKey key;
    private KeySpec keyspec;
    Cipher dcipher;
    
    public String decrypt_message(String message, String cle) throws Exception
{
        byte[] keyarray;
        BASE64Decoder dec = new BASE64Decoder();
        byte[] todecryptarray = dec.decodeBuffer(message);
        keyarray = cle.getBytes("UTF-8");
        keyspec = new SecretKeySpec(keyarray,"aes");
        key = SecretKeyFactory.getInstance("AES").generateSecret(keyspec);
        dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(new byte[16]);
        dcipher.init(Cipher.DECRYPT_MODE,key,iv);
        byte[] decrypted = dcipher.doFinal(todecryptarray);
        String decryptedMessage = new String(decrypted,"UTF-8");
        
        return decryptedMessage;
        
    
}
    
    
}
