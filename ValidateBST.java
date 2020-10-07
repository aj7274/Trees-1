import java.util.*;

//Iterative Solution 
// Time Complexity : O(n) where n is the number of nodes in Tree
// Space Complexity : O(max depth of tree) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// 1. Define a stack
// 2. Define prev pointer to keep track of previously popped element
// 3. Do inorder traversal on Tree
// 4. While Popping from stack check if previous value is more return false else
// continue

class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (prev != null && prev.val >= root.val)
                return false;
            prev = root;
            root = root.right;

        }

        return true;

    }
}