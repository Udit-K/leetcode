package com.company;

import java.util.Stack;

public class SymmetricTree {


    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }



    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack();
        Stack<TreeNode> rightStack = new Stack();
        boolean result = false;
        if(root == null) return false;

        if(root.left != null && root.right != null) {
            leftStack.push(root.left);
            rightStack.push(root.right);

            while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
                TreeNode tempLeft = leftStack.pop();
                TreeNode tempRight = rightStack.pop();
                if(tempLeft == tempRight) {
                    result = true;
                    if(tempLeft.left != null && tempRight.right != null) {
                        leftStack.push(tempLeft.left);
                        rightStack.push(tempRight.right);
                    }
                    if(tempLeft.right != null && tempRight.left != null) {
                        rightStack.push(tempLeft.right);
                        leftStack.push(tempRight.left);
                    }
                    if(tempLeft.left != null && tempRight.left != null) {
                        rightStack.push(tempLeft.left);
                        leftStack.push(tempRight.left);
                    }
                    if(tempLeft.right != null && tempRight.right != null) {
                        rightStack.push(tempLeft.right);
                        leftStack.push(tempRight.right);
                    }


                }else {
                    result = false;
                }

            }

        }
        return result;

    }

}
