/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> pathList = new ArrayList<Integer>();

        preOrderTraverse(root, targetSum, 0, pathList, list);
        return list;
    }

    public void preOrderTraverse(TreeNode bNode, int targetSum, int sum, List<Integer> pathList, List<List<Integer>> list) {

        if(bNode == null) 
            return;
        


        sum += bNode.val;
        pathList.add(bNode.val);
        
        preOrderTraverse(bNode.left, targetSum, sum, pathList, list);
        preOrderTraverse(bNode.right, targetSum, sum, pathList, list);

        if( bNode.left == null && bNode.right == null && targetSum == sum)
            list.add(new ArrayList<Integer>(pathList));
    
        pathList.remove(pathList.size()-1);
    }
    
}