package bms.utils;

import jakarta.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class Base64Decoder {

    public static String decode(String encryptedString)
    {
        byte[] decoded = Base64.getDecoder().decode(encryptedString);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
