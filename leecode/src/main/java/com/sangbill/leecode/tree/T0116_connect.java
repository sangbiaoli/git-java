package com.sangbill.leecode.tree;

import java.util.HashMap;
import java.util.Map;

class T0116_connect {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Map<Integer,Node> map = new HashMap<Integer,Node>();
        connect(root,0,map);
        return root;
    }

    public void connect(Node root,int dept,Map<Integer,Node> map){
        if(root == null)
            return;

        Node cur = map.get(dept);
        if(cur == null){
            cur = root;
        }else{
            cur.next = root;
            cur = cur.next;
        }
        map.put(dept,cur);

        connect(root.left,dept+1,map);
        connect(root.right,dept+1,map);
    }
}