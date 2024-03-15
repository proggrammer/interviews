package org.example;

import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTraversalTest {

    @Test
    void bfsDfs() {
        // Creating a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Perform BFS
        System.out.println("BFS traversal:");
        BinaryTreeTraversal.bfs(root);
        System.out.println();

        // Perform DFS (recursive)
        System.out.println("DFS traversal (recursive):");
        BinaryTreeTraversal.dfs(root);
        System.out.println();

        // Perform DFS (iterative)
        System.out.println("DFS traversal (iterative):");
        BinaryTreeTraversal.dfsIterative(root);
        System.out.println();
    }
}