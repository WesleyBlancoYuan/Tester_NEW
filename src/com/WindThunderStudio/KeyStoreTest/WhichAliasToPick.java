package com.WindThunderStudio.KeyStoreTest;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import java.security.cert.Certificate;

public class WhichAliasToPick {
    public static void main(String[] args) {
        System.out.println("OS name:         " + System.getProperty("os.name"));
        System.out.println("OS architecture: " + System.getProperty("os.arch")); //this is x64 machine so no error
        System.out.println("Java version:    " + System.getProperty("java.version"));
        System.out.println("Java vendor:     " + System.getProperty("java.vendor"));
        System.out.println("------------------------------------------------");
        
        try {
            KeyStore ks = KeyStore.getInstance("Windows-MY");
            ks.load(null, null);
            
            Enumeration<String> as = ks.aliases();
            while (as.hasMoreElements()) {
                String alias = as.nextElement();
                System.out.println("The keystore has alias: " + alias);
                Certificate ct = ks.getCertificate(alias);
                System.out.println("The certificate obtained via 'ks.getCertificate(alias)' is: " + ct.toString());
                System.out.println("");
                String alias2 = ks.getCertificateAlias(ct);
                System.out.println("For this certificate, the result of 'ks.getCertificateAlias(ct)' is: " + alias2);
                if (alias.equals(alias2)) {
                    System.out.println("These two alias are the same. ");
                    System.out.println("------------------------------------------------");
                } else {
                    System.out.println("These two alias are not the same, bug persists!");
                    break;
                }
                
            }
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }
}
