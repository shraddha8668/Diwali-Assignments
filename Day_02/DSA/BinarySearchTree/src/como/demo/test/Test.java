package como.demo.test;

import com.demo.binarysearchtree.BinarySearchTree1;

public class Test {


    public static void main(String[] args) {
       BinarySearchTree1 bst = new BinarySearchTree1();

        // Add nodes
        bst.insertNode(50);
        bst.insertNode(30);
        bst.insertNode(70);
        bst.insertNode(20);
        bst.insertNode(40);
        bst.insertNode(60);
        bst.insertNode(80);

        System.out.println("\nTree Traversals:");
        bst.inorder();
        bst.preorder();
        bst.postorder();

        // Delete node examples
        System.out.println("\nDeleting node 20 leaf:");
        bst.deleteNode(20);
        bst.inorder();

        System.out.println("\nDeleting node 30 one child:");
        bst.deleteNode(30);
        bst.inorder();

        System.out.println("\nDeleting node 50 two children:");
        bst.deleteNode(50);
        bst.inorder();
    }
}

