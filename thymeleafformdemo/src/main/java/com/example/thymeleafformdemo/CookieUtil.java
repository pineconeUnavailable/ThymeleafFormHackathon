package com.example.thymeleafformdemo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;

public class CookieUtil {
    static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static void setupSession(EphemeralPeristanceStore peristanceStore, String username, HttpServletResponse resp) {
        int len = chars.length() - 1;
        SecureRandom rand = new SecureRandom();

        StringBuilder randomToken = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            randomToken.append(chars.charAt(rand.nextInt(len)));
        }

        peristanceStore.setSession(username, randomToken.toString());
        resp.addCookie(new Cookie("session", randomToken.toString()));
        resp.addCookie(new Cookie("user", username));
    }

    public static boolean validateSession(EphemeralPeristanceStore peristanceStore, String username, String session) {
        String existing = peristanceStore.getSession(username);
        return existing != null && existing.equals(session);
    }
}
