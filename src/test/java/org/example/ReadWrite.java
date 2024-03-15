package org.example;

import java.io.*;

/**
 * Read write example
 */
public class ReadWrite {
    public static void readWrite()  {
        try {
            // Create BufferedReader to read from stdin
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Create BufferedWriter to write to stdout
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            // Read input from stdin and write it to stdout
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add newline character after each line
            }

            // Flush the BufferedWriter to ensure all data is written to stdout
            writer.flush();

            // Close the BufferedReader and BufferedWriter
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void readWriteFile()  {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            // Open input file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Open output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Read lines from input file and write them to output file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add newline character after each line
            }

            // Close input and output streams
            reader.close();
            writer.close();

            System.out.println("File read and write successful.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
