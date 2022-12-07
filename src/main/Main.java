package main;

import dnaseq.DNASequence;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        String dnaString;
        String answer;
        int sizeOfN = 0;
        int sizeOfSubstrings;
        DNASequence dnaSequence;
        Scanner input = new Scanner(System.in);
        //Get input of DNA String and size k of substrings,
        System.out.println("Input DNA sequence with alphabet {a, c, g, t}:");
        //do this per new exponent of n
        System.out.println("Are you using a previously generated string?(Y/N):");
        answer = input.nextLine();
        while (answer.compareToIgnoreCase("y") != 0 && answer.compareToIgnoreCase("n") != 0 ){
            System.out.println("Invalid input please try again.\nAre you using a previously generated string?(Y/N):");
            answer = String.valueOf(input);
        }
        if (answer.compareToIgnoreCase("y") == 0){
            try{
                Path path = Paths.get("generatedString.txt");
                int size = (int) Files.size(path);
                char[] dnaChars = new char[size];
                FileReader fileReader= new FileReader("generatedString.txt");
                fileReader.read(dnaChars,0, size);
                fileReader.close();
                //System.out.println(dnaChars);
                dnaString = String.valueOf(dnaChars);
                System.out.println("Input size of substrings for k-mer distribution:");
                sizeOfSubstrings = input.nextInt();
                dnaSequence = new DNASequence(dnaString, sizeOfSubstrings);
                dnaSequence.separateDNASequence();
            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
       else {
            System.out.println("Are you using the example string? (Y/N)");
            answer = input.nextLine();
            while (answer.compareToIgnoreCase("y") != 0 && answer.compareToIgnoreCase("n") != 0 ){
                System.out.println("Invalid input please try again.\nAre you using a previously generated string?(Y/N):");
                answer = String.valueOf(input);
            }
            if (answer.compareToIgnoreCase("y") == 0){
                dnaString = "taccaccaccatag";
                sizeOfSubstrings = 6;
            }
            else{
                System.out.println("Please input the exponent of n");
                while (sizeOfN == 0){
                    try{
                        sizeOfN = input.nextInt();
                    }catch (Exception e){
                        System.out.println("Invalid input, please input an Integer");
                    }
                }
                dnaString = generateString(sizeOfN);
                PrintStream output = new PrintStream("generatedString.txt");
                PrintStream console = System.out;
                System.setOut(output);
                System.out.print(dnaString);
                System.setOut(console);
                System.out.println("Input size of substrings for k-mer distribution:");
                sizeOfSubstrings = input.nextInt();
            }
            dnaSequence = new DNASequence(dnaString, sizeOfSubstrings);
            dnaSequence.separateDNASequence();
        }



    }

    /**
     * This function generates a random DNA string consisting of A,C,G,T) characters.
     * @param n the exponent of 10 used to generate an n sized long String.
     * @return generated size n String consisting of (A,C,G,T) characters.
     */
    private static String generateString(int n){
        int generated;
        Random rnd = new Random();
        String test = "";
        for(int i = 0; i < Math.pow(10,n); i++){
            do {
                generated = rnd.nextInt(64,85);
            }while (generated != 65 && generated != 67 && generated != 71 && generated != 84);
            test = test.concat(String.valueOf((char) generated));
        }
        return test;
    }

}