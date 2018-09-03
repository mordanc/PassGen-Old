package com.company;
import java.security.SecureRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Main {

    final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        String siteName;
        char[] passChar = new char[14];
        SecureRandom r = new SecureRandom();
        Scanner scan = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter("passKeep.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);


            for (int i = 0; i < passChar.length; i++) {
                passChar[i] = (alphabet.charAt(r.nextInt(alphabet.length())));
            }
            String passFinal = new String(passChar);

            System.out.println("Enter the name of the site that you need a password for:");
            siteName = scan.nextLine();
            bw.write("Password for " + siteName + ":");
            bw.newLine();
            bw.write(passFinal);
            bw.newLine();

            bw.close();
            writer.close();


        }
        catch (IOException e) {
            System.out.println("IOException encountered");
        }

    }
}
