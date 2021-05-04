//package com.company;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PreOrderTraversal {
//    List<Integer> res = new ArrayList<>();
//    class TreeNode {
//        int val;
//        PreOrderTraversal.TreeNode left;
//        PreOrderTraversal.TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, PreOrderTraversal.TreeNode left, PreOrderTraversal.TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public List<Integer> preOrder(TreeNode root) {
//        //Print -> Left -> Right
//            return helper(root);
//    }
//
//    public List<Integer> helper(TreeNode root) {
//        if(root == null) return new ArrayList<>();
//
//        res.add(root.val);
//        helper(root.left);
//        helper(root.right);
//        return res;
//    }
//
//
//}
