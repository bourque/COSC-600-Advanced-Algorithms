/* 
Matthew Bourque
4/5/14
Project 5

Algorithm:
    Define two sequences to be used to create binary search tree(s)
    Build T1 (first binary search tree) using the first sequence
    Print the nodes of T1 using inorder procedure
    Count and print the number of leaf nodes in T1
    Build T2 (second binary search tree) using the second sequence
    Swap all child nodes of T2
    Print the nodes of T2 using the postorder procedure
    Compare BST T1 and T2:
        Print "true" if T1 and T2 are identical
        Print "false" if T1 and T2 are not identical
    Build T3 (third binary search tree) using the second sequence
    Compare BST T1 and T3:
        Print "true" if T1 and T3 are identical
        Print "false" if T1 and T3 are not identical
    Delete the node containing 15 from T3
    Print the nodes of T3 using the inorder procedure
    Print the 5th node of T3 using the inorder procedure

Purpose:
    This program serves to implement and manipulate binary serach trees. The
    program supports several functions, including:
        (1) Building a binary search tree from a given integer sequence
        (2) Counting the number of leaf nodes in the BST
        (3) Comparing two BST to see if they are identical
        (4) Deleting node(s) from a BST
        (5) Traversing a BST using the inorder and/or postorder procedure(s)
        (6) Swapping the children of all nodes in a BST
        
   Two different sequences are implemented amongst three different trees.
   The funcitonalities of the features just describes are then tested in
   various ways in order to manipulate the tree data structure.
*/

class Driver {

  
    public static void main(String args[]) {
        /*
         * The main method.
        */
        
        // Initialize variables
        int[] sequence1 = new int[] {60, 20, 100, 35, 15, 200, 75, 150, 6, 17, 40};
        int[] sequence2 = new int[] {60, 100, 20, 15, 35, 75, 200, 6, 17, 40, 150};
        int count = 0;
    
        // Build T1
        Tree t1 = new Tree();
        System.out.print("Building tree T1 with sequence: ");
        for (int i=0; i<sequence1.length; i++) {System.out.print(sequence1[i] + " ");}
        System.out.println("\n");
        build(t1, sequence1);
        
        // Traverse T1 using inorder
        System.out.print("Traversing tree T1 via inorder procedure: ");
        printInorder(t1);
        System.out.println("\n");
        
        // Count leaf nodes in T1
        int numLeafNodes = count(t1.root);
        System.out.println("The number of leaf nodes in T1 is " + numLeafNodes);
        System.out.println("");
        
        // Build T2
        Tree t2 = new Tree();
        System.out.print("Building tree T2 with sequence: ");
        for (int i=0; i<sequence1.length; i++) {System.out.print(sequence1[i] + " ");}
        System.out.println("\n");
        build(t2, sequence1);
        
        // Swap children of T2
        System.out.println("Swapping children of T2");
        swap(t2.root);
        System.out.println("");
        
        // Traverse T2 using postorder
        System.out.print("Traversing tree T2 via postorder procedure: ");
        printPostorder(t2);
        System.out.println("\n");
        
        // Compare T1 and T2
        System.out.print("Comparing tree T1 with tree T2: ");
        boolean comparet1t2 = compare(t1.root, t2.root);
        System.out.println(comparet1t2);
        System.out.println("");
        
        // Build T3
        Tree t3 = new Tree();
        System.out.print("Building tree T3 with sequence: ");
        for (int i=0; i<sequence2.length; i++) {System.out.print(sequence2[i] + " ");}
        System.out.println("\n");
        build(t3, sequence2);
        
        // Compare T1 and T3
        System.out.print("Comparing tree T1 with tree T3: ");
        boolean comparet1t3 = compare(t1.root, t3.root);
        System.out.println(comparet1t3);
        System.out.println("");

        // Delete node with 15
        System.out.println("Removing node 15 from T3");
        delete(t3.root, 15);
        System.out.println("");
        
        // Traverse T3 using inorder
        System.out.print("Traversing tree T3 via inorder procedure: ");
        printInorder(t3);
        System.out.println("\n");
        
        // Traverse T3 using inorder to find 5th node
        System.out.print("Traversing tree T3 via inorder procedure: ");
        printInorder(t3);
    }
    
    
    public static void build(Tree t, int[] sequence) {
        /*
         * Builds a Binary Search Tree from given sequence of integers
        */
    
        for (int i=0; i<sequence.length; i++) {
            int number = sequence[i];
            TreeNode newNode = new TreeNode(number);
            if (t.root == null) {t.root = newNode;}
            t.insert(t.root, newNode);
        }
    }
    
    
    public static int count(TreeNode t) {
        /*
         * Counts the number of leaf nodes in the tree
        */
    
        if (t == null) {
            return 0;
        } else if (t.left == null && t.right == null) {
            return 1; 
        } else {
            return count(t.left) + count(t.right);
        } 
    }
    
    
    public static boolean compare(TreeNode a, TreeNode b) {
        /*
         * Returns true if tree a is indentical to tree b
         * Returns false if tree a and tree b are different
        */
    
        if (a == b) {return true;}
        if (a == null || b == null) {return false;}
        if (!compare(a.left,b.left)) {return false;}
        if (!compare(a.right,b.right)) {return false;}
        
        return true;
    }
        
       
    public static TreeNode delete(TreeNode t, int value) {
        /*
         * Deletes any instance of 'value' from the tree
        */

        if (value < (int) t.data) {t.left = delete(t.left, value);}
        else if (value > (int) t.data) {t.right = delete(t.right, value);}
        else if (t.left != null && t.right != null) {
            t.data = minData(t.right);
            t.right = delete(t.right, (int) t.data);
        } else {
            if (t.left != null) {t = t.left;}
            else {t = t.right;}
        }
        
        return t;
    }  
        
       
    private static int minData(TreeNode t) {
        /*
         * Finds the smallest number in the tree
        */
    
        if (t.left == null) {return (int) t.data;}
        else {return minData(t.left);}
    }
        
        
    public static void printInorder(Tree t) {
        /*
         * Prints the sequence using inorder procedure
        */

        t.inorder(t.root);
    }
    
       
    public static void printPostorder(Tree t) {
        /*
         * Prints the sequence using postorder procedure
        */
      
        t.postorder(t.root);
    }
    
    
    public static void swap(TreeNode t) {
        /*
         * Exchanges the left and right children recursively
         * for every node in the tree
        */

        if (t != null) {
            TreeNode tmp;
            tmp = t.left;
            t.left = t.right;
            t.right = tmp;
            swap(t.left);
            swap(t.right);
        }
    }  
}