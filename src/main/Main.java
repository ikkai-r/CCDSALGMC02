package main;

import dnaseq.DNASequence;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String dnaString;
        int sizeOfSubstrings;
        DNASequence dnaSequence;

        Scanner input = new Scanner(System.in);

        //Get input of DNA String and size k of substrings,
        System.out.println("Input DNA sequence with alphabet {a, c, g, t}:");
        //dnaString = input.nextLine();
        dnaString = "taccaccaccatag";

        System.out.println("Input size of substrings for k-mer distribution:");
        sizeOfSubstrings = 6;
        //sizeOfSubstrings = input.nextInt();

        dnaSequence = new DNASequence(dnaString, sizeOfSubstrings);

        dnaSequence.separateDNASequence();


    }

}