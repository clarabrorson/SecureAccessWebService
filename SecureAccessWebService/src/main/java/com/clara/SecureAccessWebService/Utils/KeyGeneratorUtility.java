package com.clara.SecureAccessWebService.Utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * This class is a utility class that generates a RSA key pair
 * RSA is an asymmetric encryption algorithm
 * RSA is used to encrypt the JWT token
 */
public class KeyGeneratorUtility {
    public static KeyPair generateRsaKey(){

        KeyPair keyPair;

        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch(Exception e){
            throw new IllegalStateException();
        }

        return keyPair;
    }
}
