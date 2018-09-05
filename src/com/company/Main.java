package com.company;
import java.security.SecureRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

public class Main {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
    private final static String numbers = "0123456789";
    private final static String specials = "!@#$%^&*()";

    public static void main(String[] args) {
        String siteName;
        String finalPassword;
        String runAgain;
        Boolean tryAgain = true;
        int passwordLength = 14;
        int index;
        char temp;
        char[] passChar = new char[passwordLength];
        SecureRandom r = new SecureRandom();
        Scanner scan = new Scanner(System.in);

        try {
                FileWriter writer = new FileWriter("passKeep.txt", true);
                BufferedWriter bw = new BufferedWriter(writer);
            while (tryAgain) {

                //populate char array for password
                for (int i = 0; i < passChar.length - 2; i++) {
                    passChar[i] = (alphabet.charAt(r.nextInt(alphabet.length())));
                }

                passChar[passChar.length - 2] = (numbers.charAt(r.nextInt(numbers.length())));
                passChar[passChar.length - 1] = (specials.charAt(r.nextInt(specials.length())));

                //Durstfeld shuffle
                for (int i = 0; i < passChar.length; i++) {
                    index = r.nextInt(passChar.length);
                    temp = passChar[i];
                    passChar[i] = passChar[index];
                    passChar[index] = temp;
                }

                finalPassword = new String(passChar);

                System.out.println("Enter the name of the site that you need a password for:");
                siteName = scan.nextLine();
                bw.write("Password for " + siteName + ":");
                bw.newLine();
                bw.write(finalPassword);
                bw.newLine();

                System.out.println("The password was written to PassKeep.txt\n\n" +
                        "Would you like to generate another password? (Y/N)");

                runAgain = scan.nextLine();
                if (!(runAgain.equals("Y")) && !(runAgain.equals("y"))) {
                    tryAgain = false;
                }

            }
                bw.close();
                writer.close();


        }
        catch (IOException e) {
            System.out.println("Could not write to file.");
        }

    }
}
