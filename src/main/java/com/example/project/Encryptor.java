package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if(messageLen == 0) {
            return 1;
        }
        if((double) messageLen / rows == messageLen / rows) {
            return messageLen / rows;
        } else {
            return (messageLen / rows) + 1;
        }
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int cols = determineColumns(message.length(), rows);
        int ind = 0;
        String[][] encrypted = new String[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(ind > message.length() - 1) {
                    encrypted[i][j] = "=";
                } else {
                    encrypted[i][j] = message.substring(ind, ind + 1);
                    ind++;
                }
            }
        }
        return encrypted;
    }

    public static String encryptMessage(String message, int rows){
        int cols = determineColumns(message.length(), rows);
        String[][] newEncrypt = generateEncryptArray(message, rows);
        String encrypt = "";
        for(int i = cols - 1; i >= 0; i--) {
            for(int j = 0; j < rows; j++) {
                encrypt += newEncrypt[j][i];
            }
        }
        return encrypt;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        if(encryptedMessage.isEmpty()) {
            return "";
        }

        int cols = determineColumns(encryptedMessage.length(), rows);
        if(rows * cols != encryptedMessage.length()) {
            return "";
        }

        String[][] newDecrypt = new String[rows][cols];
        int ind = 0;

        for(int j = cols - 1; j >= 0; j--) {
            for(int i = 0; i < rows; i++) {
                newDecrypt[i][j] = String.valueOf(encryptedMessage.charAt(ind));
                ind++;
            }
        }
        String decrypt = "";
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                decrypt += newDecrypt[i][j];
            }
        }
        return decrypt;
    }
    
    public static void main(String[] args) {
        String encryptedMessage = " =?!yeaddiostt uuoo ye ceirna  ywroehv  oslil etHi";
        int rows = 2;
        String actualDecrypted = Encryptor.decryptMessage(encryptedMessage, rows);
        String[][] newDecrypt = generateEncryptArray(encryptedMessage, rows);
        for(int i = 0; i < newDecrypt.length; i++) {
            for(int j = 0; j < newDecrypt[0].length; j++) {
                System.out.print(newDecrypt[i][j]);
            }
            System.out.println();
        }
        System.out.println(actualDecrypted);
    }
}