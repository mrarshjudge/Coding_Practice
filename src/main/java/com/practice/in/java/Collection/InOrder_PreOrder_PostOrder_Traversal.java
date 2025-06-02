package com.practice.in.java.Collection;

import java.util.ArrayDeque;
import java.util.Stack;

public class InOrder_PreOrder_PostOrder_Traversal {
	Node root;
	
	public static void main(String[]args) {
		InOrder_PreOrder_PostOrder_Traversal is = new InOrder_PreOrder_PostOrder_Traversal();
		is.insert(13);
		is.insert(12);
		is.insert(19);
		
		is.insert(21);
		is.inOrder(is.root);
		System.out.println("-------------------------------");
		is.preOrder(is.root);
		System.out.println("-------------------------------");
		is.postOrder(is.root);
		is.binarySearch(21);
		System.out.println("-------------------------------");

		is.levelOrderTraversal();
	}
	
	public void insert(int value) {
		Node newNode  = new Node(value);
		if(root ==null) 
			root = newNode;
		
		Node temp = root;
		Node parent = temp;
		while (temp != null) {
          parent = temp;
          if(temp.value>value) {
        	  temp = temp.left;
          }
          else if(temp.value<value) {
        	  temp = temp.right;
          }else {
        	  return;
          }
        }

        
        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

	}
	
	//Left->Node->right
	
	public void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.value);
		inOrder(node.right);
	}
	
	public void inOrderIterative() {
		if(root==null) return;
		
		Node temp = root;
		ArrayDeque<Node> stack = new ArrayDeque<>();
		while(!stack.isEmpty() || temp!=null) {
			while(temp!=null) {
					stack.push(temp);
					temp = temp.left;
			}
			
		temp = stack.pop();
		System.out.println(temp.value);
		temp = temp.right;	
		}
	}
	
	//Node->left->right
	public void preOrder(Node node) {
		if(node==null) {
			return;
		}
		
		System.out.println(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void preOrderInterative() {
		if(root==null) return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.value);
			if(node.right!=null)stack.push(node.right);
			if(node.left!=null) stack.push(node.left);
			
			
			
		}
		
	}
	public void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
	
	public void postOrderIterative() {
	    if (root == null) return;

	    Stack<Node> stack1 = new Stack<>();
	    Stack<Node> stack2 = new Stack<>();

	    stack1.push(root);

	    while (!stack1.isEmpty()) {
	        Node node = stack1.pop();
	        stack2.push(node);

	        if (node.left != null) stack1.push(node.left);
	        if (node.right != null) stack1.push(node.right);
	    }

	    while (!stack2.isEmpty()) {
	        System.out.println(stack2.pop().value);
	    }
	}
	
	public Node binarySearch(int value) {
		Node temp = root;
		while(temp!=null) {
			if(temp.value>value) {
				temp = temp.left;
			}else if(temp.value<value) {
				temp = temp.right;
			}else {
				System.out.println("Found Value "+temp.value);
				break;
			}
		}
		return temp;
	}
	public Node binaryRecurssion(Node node, int value) {
		if(node ==null) {
			return null;
		}
		if(node.value==value) {
			return node;
		}
		if(node.value>value) { return binaryRecurssion(node.left, value);}
		else { return binaryRecurssion(node.right, value);}
	}
	
	public void levelOrderTraversal() {
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.value);
			if(temp.left!=null) queue.offer(temp.left);
			if(temp.right!=null)queue.offer(temp.right);
		}
		
	}
	
		
}


class Node{
	int value;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
	}
}