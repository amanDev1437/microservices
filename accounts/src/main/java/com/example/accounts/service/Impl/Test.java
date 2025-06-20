package com.example.accounts.service.Impl;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("name","Aman");
        map.put("age","25");

        for(Map.Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
