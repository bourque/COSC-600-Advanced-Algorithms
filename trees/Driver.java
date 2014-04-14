/* 
Matthew Bourque
4/5/14
Project 5

Algorithm:
        

Purpose:
*/

class Driver {

  
    public static void main(String args[]) {
        /*
         * The main method.
        */
        
        int[] sequence1 = new int[] {60, 20, 100, 35, 15, 200, 75, 150, 6, 17, 40};
        int[] sequence2 = new int[] {60, 100, 20, 15, 35, 75, 200, 6, 17, 40, 150};
    
        Tree t1 = new Tree();
        build(t1, sequence1);
        //printInorder(t1);
        int numLeafNodes = count(t1.root);
        //System.out.println(numLeafNodes);
        
        Tree t2 = new Tree();
        build(t2, sequence1);
        swap(t2.root);
        //printPostorder(t2);
        
        boolean same = compare(t1.root, t2.root);
        System.out.println(same);
        
        Tree t3 = new Tree();
        build(t3, sequence2);
        System.out.println(compare(t1.root, t3.root));
        //printInorder(t3);
        delete(t3.root, 15);
        //printInorder(t3);
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
         * Prints the sequence using inorder method
        */

        System.out.println("Inorder:");
        System.out.print("\t");
        t.inorder(t.root);
        System.out.println("");
    }
    
       
    public static void printPostorder(Tree t) {
        /*
         * Prints the sequence using postorder method
        */
      
        System.out.println("Postorder:");
        System.out.print("\t");
        t.postorder(t.root);
        System.out.println("");
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