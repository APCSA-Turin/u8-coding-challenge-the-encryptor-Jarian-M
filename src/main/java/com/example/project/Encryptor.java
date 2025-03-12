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
                if(!newDecrypt[i][j].equals("=")) {
                    decrypt += newDecrypt[i][j];
                }
            }
        }
        return decrypt;
    }
    
    public static void main(String[] args) {
        int rows = 8;
        //String encryptedMessage = Encryptor.encryptMessage("Good evening fellow citizens and Avengers of the world. I am here to save the world. The world is in need of my help. Population is growing faster than the food supply. The world is becoming increasingly polluted. Many people are growing into poverty. There is too much Competition for Resources. Sacrifices are needed to sustain the world. \"I'm the only one who knows that. At least, I'm the only one with the will to act on it.\" (Avengers: Infinity War) I am doing what no one else will do. I am the only one with the courage to act on this issue. I have the power to change the world. There are not enough resources for everyone to go around. Without me, the world will collapse. “With all six stones, I could simply snap my fingers, and they would all cease to exist” I am sacrificing for the greater good. I am sacrificing for the future. I am the hero that everyone needs. Avengers don’t even think about stopping me. I am doing this for the greater good. “I know what it’s like to lose. To feel so desperately that you’re right, yet to fail nonetheless. It’s frightening. Turns the legs to jelly. I ask you, to what end? Dread it, run from it, destiny arrives all the same. And now it’s here. Or should I say... I am? -Avengers: Infinity War (2018). I can’t let this go on. It must stop with the pain, chaos, and inequality. I am aware that sacrifices must be made in order to save the universe. Resources can be distributed equally, ensuring that every being has enough to survive, by eliminating half the population. Although it may seem harsh, this is an essential step in the direction of a sustainable future. it’s a simple calculus. This universe is finite, its resources finite. If life is left unchecked, life will cease to exist. It needs correction. Going to bed hungry? Scrounging for scraps? Your planet was on the brink of collapse. I’m the one who stopped that. Do you know what’s happened since then? The children born have known nothing but full bellies and clear skies. It’s a paradise. Although you think this is too harsh, it’s “A small price to pay for salvation.” “With all six stones, I could simply snap my fingers, and they would all seize to exist. I call that mercy. I will shred this universe down to it's last atom and then, with the stones you've collected for me, create a new one. It is not what is lost but only what it is been given... a grateful universe.” It brings me joy that I can balance the universe with my power. \"Fun isn't something one considers when balancing the universe. but this... does put a smile on my face.\" Avengers and citizens, I understand where you guys are coming from. I understand human nature. \"And as long as there are those that remember what was, there will always be those that are unable to accept what can be. They will resist. \" However, if you let me fulfill my destiny, everything will be \"Perfectly Balanced, As All Things Should Be.\". “In all my years of conquest, violence, slaughter, it was never personal. But I'll tell you, now... what I'm about to do to your stubborn, annoying little planet, I'm gonna enjoy it. Very, very much.", rows);
        String encryptedMessage = "ynmiep==roywdin=cih  ro=ntrshci=Ep etst=";
        String actualDecrypted = Encryptor.decryptMessage(encryptedMessage, rows);
        System.out.println(actualDecrypted);
    }
}