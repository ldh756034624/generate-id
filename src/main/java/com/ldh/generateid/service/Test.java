package com.ldh.generateid.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ln
 * @create 2018-09-14:1:29 PM
 **/
public class Test {
    public static void main(String[] args) {
        GenerateIdService generateIdService = new GenerateIdService();
        long getsequence = generateIdService.getsequence(1152933653717714442L);
        System.out.println(getsequence);

    }
}
