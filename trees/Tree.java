public class Tree {
  
    public TreeNode root = null;
    public int count = 0;
    
   
    public void insert(TreeNode t, TreeNode nodeToAdd) {

        if ((int) nodeToAdd.data < (int) t.data) {
            if (t.left == null) {t.left = nodeToAdd;}
            else {insert(t.left, nodeToAdd);}
        
        } else if ((int) nodeToAdd.data > (int) t.data) {
            if (t.right == null) {t.right = nodeToAdd;}
            else {insert(t.right, nodeToAdd);}      
        }
    }
   
  
    public void find(TreeNode t, int n) {
    
        if (t != null) {
            find(t.left, n);
            count++;
            if (count == n) {System.out.println(t.data);}
            find(t.right, n);
        }
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
}