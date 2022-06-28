package com.example.feeddemo;

import org.jasypt.util.text.BasicTextEncryptor;

public class Test {
    //给配置文件加密
    public static void main(String[] args) {

        // 加密
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //自己设置的秘钥
        textEncryptor.setPassword("feeddemo");

        String userName = textEncryptor.encrypt("root");
        System.out.println(userName);
        String password = textEncryptor.encrypt("1234567");
        System.out.println(password);

//        // 解密
        BasicTextEncryptor textEncryptor2 = new BasicTextEncryptor();
        textEncryptor2.setPassword("as12AS!@0.");
        String oldPassword = textEncryptor2.decrypt("PWincCp/1W7AmXeoVVJbNg==");
        System.out.println(oldPassword);
        System.out.println("--------------------------");

    }
}
