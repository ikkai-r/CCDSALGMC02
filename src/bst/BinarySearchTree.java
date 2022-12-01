package bst;

public class BinarySearchTree {

    private Node root;

    /*
    * Implement an ordinary (i.e. does not need to be balanced) Binary Search Tree data-structure from scratch.
    * Your implementation needs to support the following operations:

    create() – produces an empty BST
    search() – determines if a search key exists in the BST
    insert() – adds a new node in the BST
    destroy() – For languages without automatic garbage collection, this function will free up the memory space. The BST will become empty after calling destroy().
    * */

    public void create() {
        this.root = null;
    }

    //TODO: tinatamad pa ako kumpletuhin, pero essentialli,
    //eto na yon HAHAHAHA, yung search nalang talaga
    public boolean searchCall(String key) {

        root = search(this.root, key);

        return root != null;
    }

    public Node search(Node current, String key) {
        if (current == null) {
            return null;
        } else if (current.getKey().equals(key)) {
            return current;
        } else if(current.getKey().compareTo(key) < 0) {
            return search(current.getLeft(), key);
        }

        return search(current.getRight(), key);
    }

    public void update(String key) {
        root = search(this.root, key);
        root.setRecord(root.getRecord()+1);
    }

    public void insertCall(String key) {
        this.root = insert(this.root, key);
    }

    public Node insert(Node current, String key) {

        //if current is null,
        //at the end of the tree, then insert
        if (current == null) {
            current = new Node(key, 1);
            return current;
        }

        if (current.getKey().compareTo(key) < 0) {
            //if there is root, check if less than,
            //add to left subtree
            current.setLeft(insert(current.getLeft(), key));
        } else if (current.getKey().compareTo(key) > 0) {
            //if there is root, check if more than,
            //add to right subtree
            current.setRight(insert(current.getRight(), key));
        }

        return current;

    }

    public void destroy() {
        this.root = null;
    }

    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getKey() + " " + root.getRecord());
        preorder(root.getLeft());
        preorder(root.getRight());

    }

    public void printKMerDistribution() {

    }
}