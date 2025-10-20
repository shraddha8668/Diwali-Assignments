package com.demo.binarysearchtree;

public class BinarySearchTree1 {

	    Node root;


	    class Node {
	        int data;
	        Node left, right;

	        public Node(int value) {
	            this.data = value;
	            this.left = null;
	            this.right = null;
	        }
	    }

	    // Constructor
	    public BinarySearchTree1() {
	        root = null;
	    }

	    // a) Add node
	    public void insertNode(int key) {
	        root = insertData(root, key);
	    }

	    private Node insertData(Node root, int key) {
	        if (root == null) {
	            return new Node(key);
	        }

	        if (key < root.data)
	            root.left = insertData(root.left, key);
	        else if (key > root.data)
	            root.right = insertData(root.right, key);
	        else
	            System.out.println("Duplicate value " + key + " not allowed.");

	        return root;
	    }

	    // b) Remove node
	    public void deleteNode(int key) {
	        root = deleteRec(root, key);
	    }

	    private Node deleteRec(Node root, int key) {
	        if (root == null) {
	            System.out.println("Node " + key + " not found.");
	            return null;
	        }

	        // Traverse to correct node
	        if (key < root.data)
	            root.left = deleteRec(root.left, key);
	        else if (key > root.data)
	            root.right = deleteRec(root.right, key);
	        else {
	           
	            if (root.left == null && root.right == null)
	                return null;

	         
	            else if (root.left == null)
	                return root.right;
	            else if (root.right == null)
	                return root.left;

	          
	            root.data = minValue(root.right);

	           
	            root.right = deleteRec(root.right, root.data);
	        }

	        return root;
	    }

	    private int minValue(Node root) {
	        int minVal = root.data;
	        while (root.left != null) {
	            minVal = root.left.data;
	            root = root.left;
	        }
	        return minVal;
	    }

	    // c) Display tree with traversals
	    public void inorder() {
	        System.out.print("Inorder Traversal: ");
	        inorderTraversal(root);
	        System.out.println();
	    }

	    private void inorderTraversal(Node root) {
	        if (root != null) {
	            inorderTraversal(root.left);
	            System.out.print(root.data + " ");
	            inorderTraversal(root.right);
	        }
	    }

	    public void preorder() {
	        System.out.print("Preorder Traversal: ");
	        preorderTraversal(root);
	        System.out.println();
	    }

	    private void preorderTraversal(Node root) {
	        if (root != null) {
	            System.out.print(root.data + " ");
	            preorderTraversal(root.left);
	            preorderTraversal(root.right);
	        }
	    }

	    public void postorder() {
	        System.out.print("Postorder Traversal: ");
	        postorderTraversal(root);
	        System.out.println();
	    }

	    private void postorderTraversal(Node root) {
	        if (root != null) {
	            postorderTraversal(root.left);
	            postorderTraversal(root.right);
	            System.out.print(root.data + " ");
	        }
	    }
}
