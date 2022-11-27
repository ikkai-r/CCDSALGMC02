package main;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String dnaString;
        int sizeOfSubstrings;

        Scanner input = new Scanner(System.in);

        //Get input of DNA String and size k of substrings,
        System.out.println("Input DNA sequence with alphabet {a, c, g, t}:");
        dnaString = input.nextLine();

        System.out.println("Input size of substrings for k-mer distribution:");
        sizeOfSubstrings = input.nextInt();

        //compute k-mer distribution using HashTable


        //compute k-mer distribution using Binary Search Tree

    }

}