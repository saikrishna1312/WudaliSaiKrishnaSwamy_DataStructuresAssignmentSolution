package com.GL.model;

import java.io.*;

public class BstToRightSkewed {

	static class Node {
		int key;
		Node left, right;
	};

	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;

		while (x != null) {
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {System.out.println("Value already exists!!!");
			return newnode;
			}
		}

		if (current_parent == null)
			current_parent = newnode;

		else if (key < current_parent.key)
			current_parent.left = newnode;

		else
			current_parent.right = newnode;
		return current_parent;
	}
	
	    
	static void flattenBTToSkewed(Node root, int order)
	{

		
		if(root == null)
		{
			return;
		}

		
		if(order > 0)
		{
			flattenBTToSkewed(root.right, order);
		}
		else
		{
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		
		
		if (order > 0)
		{
			flattenBTToSkewed(leftNode, order);
		}
		else
		{
			flattenBTToSkewed(rightNode, order);
		}
	}

	
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.key + " ");
		traverseRightSkewed(root.right);       
	}


	public static void main (String[] args)
	{
   
		Node tree = new Node(50);
		tree.left = new Node(30);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(40);

		int order = 0;
		flattenBTToSkewed(node, order);
		traverseRightSkewed(headNode);
	}
    
}


