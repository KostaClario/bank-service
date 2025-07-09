package com.kosta.bankservice.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CiGenerator {

    private static final String SALT = "bank-api-secret-salt";

    public static String generateCi(String email, String phone){

        try{
            String base = email + ":" + phone + ":" + SALT;

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));

            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
