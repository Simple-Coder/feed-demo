package com.example.feeddemo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jasypt.util.text.BasicTextEncryptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    //给配置文件加密
    public static void main(String[] args) {
        Long currentUserId = 2L;
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(2L);
        userIds.add(3L);
        userIds.add(4L);
        userIds.add(null);

        List<Person> ps = new ArrayList<>();
        ps.add(Person.builder().username("zhangsan").build());
        ps.add(Person.builder().username("lisi").build());
        JSONObject json = new JSONObject();
        json.put("data",ps);
        System.out.println(json.toString());
        JSONArray data = json.getJSONArray("data");
        System.out.println(json.toString());


        List<Long> collect1 = userIds.stream().filter(id -> id != null).collect(Collectors.toList());
        boolean querySelf = false;

        if (!querySelf) {
            userIds.remove(currentUserId);
        }

        List<Long> collect = userIds.stream().filter(userId -> (userId != currentUserId)).collect(Collectors.toList());

        System.out.println();


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
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
class Person{
    private String username;
}
