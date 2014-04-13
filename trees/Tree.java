import java.util.ArrayList;

public class Tree {
  
    public TreeNode root = null;
    
    
    public Tree(int[] sequence) {
        /*
         * The constructor method
        */
        
        build(sequence);
    }
    
    public void build(int[] sequence) {
        /*
         * Builds a Binary Search Tree from given sequence of integers
        */
    
        for (int i=0; i<sequence.length; i++) {
            int number = sequence[i];
            TreeNode newNode = new TreeNode(number);
            if (root == null) {root = newNode;}
            insert(root, newNode);
        }
    }
    
   
    public void insert(TreeNode t, TreeNode nodeToAdd) {
        /*
         * Determines where in the BST to add the new node and adds it
        */

        if ((int) nodeToAdd.data < (int) t.data) {
            if (t.left == null) {t.left = nodeToAdd;}
            else {insert(t.left, nodeToAdd);}
        
        } else if ((int) nodeToAdd.data > (int) t.data) {
            if (t.right == null) {t.right = nodeToAdd;}
            else {insert(t.right, nodeToAdd);}      
        }
    }
    
    
    public TreeNode delete(TreeNode t, int k) {
    
        if (t == null) {return null;}
        if (k < (int) t.data) {t.left = delete(t.left, k);}
        else if (k > (int) t.data) {t.right = delete(t.right, k);}
        else {
            if (t.right == null) {return t.left;}
            if (t.left == null) {return t.right;}
            TreeNode tmp = t;
            t.data = minData(tmp.right);
            t.right = deleteMin(t.right);
            t.left = tmp.left;
        }
    
        return t;
    }
   
  
    public TreeNode find(TreeNode t, int k) {
    
        while (t.data != k) {
            if (k < (int) t.data) {
                t = t.left;
            } else {
                t = t.right;
            }
            
            if (t == null) {return null;}
        }
        
        return t;
      
    }
    
    
    public void inorder(TreeNode t) {

        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }
    
    
    public void postorder(TreeNode t) {
      
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            System.out.print(t.data + " ");
        }
    }
    
    
    private int minData(TreeNode t) {
    
        if (t.left == null) {return (int) t.data;}
        else {return minData(t.left);}
    }
    
    
    private TreeNode deleteMin(TreeNode t) {
      
        if (t.left == null) {return t.right;}
        t.left = deleteMin(t.left);
        return t;
    }
}