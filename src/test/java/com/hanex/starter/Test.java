//package com.hanex.starter;
//
//import com.hanex.starter.common.enums.UserRole;
//import com.hanex.starter.common.util.encrypt.SimpleEncryptor;
//
//import java.util.Date;
//
//public class Test {
//    private static final int EXP = 1000 * 60 * 60* 24; // 24시간
//
//    public static void main(String[] args) {
//
//
//
//
//        String email = "test@test.com";
//        byte[] encEmail = new SimpleEncryptor().encrypt(email);
//        System.out.println(String.valueOf(encEmail));
//        String decEmail = new SimpleEncryptor().decrypt(encEmail);
//        System.out.println(decEmail);
//
//        System.out.println(UserRole.ROLE_ADMIN.getText());
//        System.out.println(UserRole.ROLE_ADMIN.getId());
//
//        System.out.println(new Date(System.currentTimeMillis() + 3600));
//        System.out.println(new Date(System.currentTimeMillis() + 604800));
//        System.out.println(new Date());
//        System.out.println(EXP);
//        System.out.println(3600/1000);
//        System.out.println(1000 * 60 * 60);
//        System.out.println(new Date(System.currentTimeMillis() + EXP));
//
//    }
//}
