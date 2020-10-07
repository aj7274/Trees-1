import java.util.*;

//Itervative Solution 

// Take Care of base Case
//1. Create Root Node from Preoder first Element
//2. Find index of Root Node in inorder
//3. have preorder_left,preorder_right,inorder_leftand inorder_right list
//4. call buildTree for root/left and root.right 

// Time Complexity : O(n) where n is the number of nodes in preoder and inorder array
// Space Complexity : O(max depth of tree) Recursive Stack. Here O(n+m) is not the space complexity because at a time there will be only one side in stack either left or right
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break; // optimization
            }
        }

        int[] pre_left = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] pre_right = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] in_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);

        return root;
    }
}
