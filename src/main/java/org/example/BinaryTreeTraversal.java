package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.example.util.TreeNode;

public class BinaryTreeTraversal {

    // Breadth First Search (BFS) for a binary tree
    public static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    // Depth First Search (DFS) using recursion for a binary tree (Inorder traversal)
    public static void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        System.out.print(root.val + " ");
        dfs(root.right);
    }

    // Depth First Search (DFS) using iterative approach for a binary tree (Inorder traversal)
    public static void dfsIterative(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");

            current = current.right;
        }
    }
}

