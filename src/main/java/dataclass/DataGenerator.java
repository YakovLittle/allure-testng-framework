package dataclass;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class DataGenerator {

    public static String getCurrentDate() {
        int i = 0;
        Date j = new Date();
        j.getTime();
        i++;
        DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        return df.format(j);
    }

    public static String getMyInternalIp() {
        try {
            InetAddress i = InetAddress.getLocalHost();
            String ip = (i.getHostAddress());
            return ip;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getRandomIntNumber(int min,int max) {
        Random rand = new Random();
        return Integer.toString(rand.nextInt((max - min)));

    }

    public static String getRandomIcqNumber() {
        Random rand = new Random();
        int min = 146776456;
        int max = 346776456;
        return Integer.toString(rand.nextInt((max - min)));

    }

    public static String getRandomPhoneNumber() {
        Random rand = new Random();
        int min = 1234567891;
        int max = 1934567891;
        return Integer.toString(rand.nextInt((max - min))) + "99999";
    }

    public static String getRandomString() {
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] text = new char[10];
        for (int i = 0; i < 10; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static String getRandomStringForMonkey() {
        Random rng = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int min = 9;
        int max = 15;
        Random rand2 = new Random();
        int stringLenght = rand2.nextInt((max - min) + 1) + min;
        char[] text = new char[stringLenght];
        for (int i = 0; i < stringLenght; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public static String getRandomNameWithDate() {
        return getCurrentDate() + " " + getRandomIntNumber(100,1000);
    }
}
