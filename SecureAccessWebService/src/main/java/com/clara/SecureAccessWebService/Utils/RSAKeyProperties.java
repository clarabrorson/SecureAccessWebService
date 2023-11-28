package com.clara.SecureAccessWebService.Utils;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * This class is a utility class and can be seen as a container for the RSA key pair.
 * It provides methods for getting and setting the keys.
 * The annotation @Component makes Spring create an object of the class and store it in its context.
 * This makes it possible to inject the object in other classes.
 */
@Component
public class RSAKeyProperties {
    private RSAPublicKey publicKey;
    private RSAPrivateKey privateKey;

        public RSAKeyProperties(){
            KeyPair pair = KeyGeneratorUtility.generateRsaKey();
            this.publicKey = (RSAPublicKey) pair.getPublic();
            this.privateKey = (RSAPrivateKey) pair.getPrivate();
        }
        public RSAPublicKey getPublicKey(){
            return this.publicKey;
        }
        public void setPublicKey(RSAPublicKey publicKey){
            this.publicKey = publicKey;
        }
        public RSAPrivateKey getPrivateKey(){
            return this.privateKey;
        }
        public void setPrivateKey(RSAPrivateKey privateKey){
            this.privateKey = privateKey;
        }
}
