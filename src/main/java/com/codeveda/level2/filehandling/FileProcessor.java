package com.codeveda.level2.filehandling;

import java.io.*;

public class FileProcessor {

    public void processFile(String inputFile, String outputFile){

        int lineCount=0;
        int wordCount=0;



            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer=new BufferedWriter(new FileWriter(outputFile))) {

                String line;

                while((line =reader.readLine()) !=null){
                    lineCount++;

                        if (!line.trim().isEmpty()) {
                            String[] words = line.trim().split("\\s+");
                            wordCount += words.length;
                    }
                }

                writer.write("File Processing result is ");

                writer.newLine();
               writer.write("Total lines: "+ lineCount);
                writer.newLine();
                writer.write("Total words: "+ wordCount);

                System.out.println("File process successfully!!");
                System.out.println("Output data: "+outputFile);
            } catch (FileNotFoundException e) {
                System.out.println("Input file is not found ");
            } catch (IOException e) {
                System.out.println("Error in writing/reading file");
            }

    }
}
