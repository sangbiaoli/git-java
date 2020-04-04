package com.sangbill.test.algorithm;
class Test38 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(!isSameNode(p,q))
            return false;

        boolean b =  compare(p,q);
        return b;
    }

    public boolean compare(TreeNode p,TreeNode q){
        if(isSameNode(p.left,q.left)){
            if(p.left != null){
                return compare(p.left,q.left);
            }
        }else{
            return false;
        }
        if(isSameNode(p.right,q.right)){
            if(p.right != null){
                return compare(p.right,q.right);
            }
        }else{
            return false;
        }
        return true;
    }

   public boolean isSameNode(TreeNode p, TreeNode q) {
       if(p == null || q == null){
           return p == q;
       }
       return p.val == q.val;
    }
}