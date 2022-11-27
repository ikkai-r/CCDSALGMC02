package dstructs;

public class DNASequence {
    private String dnaString;
    private int sizeOfSubstrings;

    HashTableHC htHC = new HashTableHC();
    HashTableHF htHF = new HashTableHF();

    public DNASequence(String dnaString, int sizeOfSubstrings) {
        this.dnaString = dnaString;
        this.sizeOfSubstrings = sizeOfSubstrings;
    }

    //TODO: Make function to separate string into k-length substrings

    public void separateDNASequence() {

        String dnaStringHT = dnaString;
        String dnaStringBST = dnaString;

        int length = dnaString.length();
        String substring;
        boolean found;

        while (length >= sizeOfSubstrings) {

            substring = dnaStringHT.substring(0, sizeOfSubstrings);
            found = htHC.searchElement(substring);

            if (found) {
                //update hashtable
                htHC.updateElement(substring);
            } else {
                //add element
                htHC.addElement(substring, 1);
            }

            dnaStringHT = dnaStringHT.substring(1);
            length--;
        }

        //TODO: Call BST and store

    }

    public void printComputedKMerDist() {

        HashTableHC hashHC = new HashTableHC();
        HashTableHF hashHF = new HashTableHF();
        BinarySearchTree bst = new BinarySearchTree();

        //for hashtable
        //print first implementation
        hashHC.printKMerDistribution();
        //print second implementation
        hashHF.printKMerDistribution();

        //print bst
        bst.printKMerDistribution();

    }

}
