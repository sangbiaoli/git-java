package com.sangbill.leecode.tree;

public class T0098_isValidBST {
	
	public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        return isValidBST(root,-1,-1);
    }

    public static boolean isValidBST(TreeNode root,int left,int right){
       if(root == null)
	            return true;

        if(root.left != null){
        	int lv = root.left.val;
            if(lv >= root.val || (left != -1 && left >= lv) || (right != -1 && right <= lv)){
                return false;
            }
        }

        if(root.right != null){
        	int rv = root.right.val;
            if(rv <= root.val || (left != -1 && left >= rv) || (right != -1 && right <= rv)){
                return false;
            }
        }

	    return isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(new Integer[]{10,5,15,null,null,6,20});
    	System.out.println(isValidBST(root));
	}
}
