package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CollatzConjecture {
    public static void runTest(int length)  {
        String input = getRandomInput(length);
        Set<String> set = new HashSet<>();
        long count = 0;
        String filePath = "/Users/kapil.rajak/development/interview/interview/src/test/resources/ok";
        int max = input.length();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            String space = " ".repeat(length - input.length()+30);
            //fileWriter.write(input + space + Long.parseLong(input, 2) +"\t"+input.length()+"\n");
//            fileWriter.write(input + space + input.length()+"\n");
            fileWriter.write(input.length()+"\n");
            while(!set.contains(input))  {
                set.add(input);
                String nextInput = collatzStep(input);
                space = " ".repeat(length - nextInput.length()+30);
                //fileWriter.write(nextInput + space + Long.parseLong(nextInput, 2) +"\t"+ nextInput.length()+"\n");
//                fileWriter.write(nextInput + space + nextInput.length()+"\n");
                fileWriter.write(nextInput.length()+"\n");
                input = nextInput;
                max = Math.max(max, input.length());
                if(count %100000 == 0)  {
                    System.out.println(count);
                }
                if(count > 100000000) {
                    break;
                }
                count++;
            }
            fileWriter.write("initLength:"+length +"max:"+ max+"\n");
        } catch (IOException e) {
            // Handle exceptions, such as file not found or permission issues
            e.printStackTrace();
        }
    }

    private static String getRandomInput(int length) {
        Random random = new Random();
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Generate a random binary digit (0 or 1)
            int randomDigit = random.nextInt(2);
            binaryString.append(randomDigit);
        }

        return binaryString.toString().replaceAll("^0+", "");
    }

    public static String collatzStep(String input) {
        String r = (input.endsWith("0")) ? input.replaceAll("0+$", "") : threeNPlus1(input);
        return r.replaceAll("^0+", "");
    }

    public static String threeNPlus1(String input) {
        return addBinaryStrings(input, input+"1");
    }

    public static String addBinaryStrings(String binary1, String binary2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = binary1.length() - 1;
        int j = binary2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? binary1.charAt(i--) - '0' : 0;
            int bit2 = (j >= 0) ? binary2.charAt(j--) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }
}
