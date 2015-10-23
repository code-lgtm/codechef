package com.company;

import java.util.*;

/**
 * Created by kumar_garg on 5/16/15.
 */
public class RandomGenerator {
    public static void main(String[] args)
    {
        Random r = new Random();

        String alphabet = "abcdefghijklmnopqrstuvwxyxyz";

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 98; i++) {
                System.out.print(alphabet.charAt(r.nextInt(alphabet.length())));
            }
            System.out.print("\n");
        }
    }
}
