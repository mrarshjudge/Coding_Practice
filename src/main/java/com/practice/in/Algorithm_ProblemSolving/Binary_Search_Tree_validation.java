package com.practice.in.Algorithm_ProblemSolving;

//Binary Search Tree Validation
public class Binary_Search_Tree_validation {
	
	public static void main(String[]args) {
		TreeNode tn = new TreeNode(15);
		tn.left = new TreeNode(12);
		tn.right = new TreeNode(16);
		tn.left.left = new TreeNode(10);
		tn.left.right = new TreeNode(15);
		tn.right.left = new TreeNode(16);
		tn.right.right = new TreeNode(19);
		
		
		System.out.println(validateBST(tn));
	}
	public static boolean validateBST(TreeNode root) {
		return isValidate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean isValidate(TreeNode node, long min, long max) {
		if(node==null) return true;
		
		if(node.value<=min || node.value>=max) {
			return false;
		}
		return isValidate(node.left, min, node.value) && isValidate(node.right, node.value, max);
	}
}
class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int value){
		this.value = value;
	}
}