package org.example;

import java.util.*;

public class BinaryMatrix {

    public static int shortestPath(int[][] matrix)   {
        List<Integer> levelChildren = new ArrayList<>();
        levelChildren.add(0);
        levelChildren.add(0);
        int length = 0;
        while(!levelChildren.isEmpty()) {
            markVisited(levelChildren, matrix);
            if(destinationPresent(levelChildren, matrix.length, matrix[0].length))   {
                return length;
            }
            length++;
            levelChildren = children(levelChildren, matrix);
        }
        return -1;
    }

    private static boolean destinationPresent(List<Integer> levelChildren, int lengthX, int lengthY) {
        for(int i=0; i<levelChildren.size(); i=i+2) {
            if(levelChildren.get(i) == lengthX && levelChildren.get(i+1) == lengthY)
                return true;
        }
        return false;
    }

    private static void markVisited(List<Integer> levelChildren, int[][] matrix) {
        for(int i=0; i<levelChildren.size(); i=i+2) {
            matrix[levelChildren.get(i)][levelChildren.get(i+1)] = 2;
        }
    }

    private static List<Integer> children(List<Integer> levelChildren, int[][] matrix) {
        List<Integer> children = new ArrayList<>();
        for(int i=0; i<levelChildren.size(); i=i+2) {
            List<Integer> fourNeighbour = getFourNeighbour(levelChildren.get(i), levelChildren.get(i+1), matrix);
            fourNeighbour.forEach(ii -> children.add(ii));
        }
        return children;
    }

    private static List<Integer> getFourNeighbour(Integer x, Integer y, int[][] matrix) {
        int[] list = {x+1, y, x-1, y, x, y+1, x, y-1};
        List<Integer> filtered = new ArrayList<>();
        for(int i=0; i<list.length; i=i+2) {
            if((list[i] >=0 && list[i+1] >=0) && (list[i] < matrix.length && list[i+1] <matrix[0].length) && matrix[list[i]][list[i+1]] == 1) {
                filtered.add(list[i]);
                filtered.add(list[i+1]);
            }
        }
        return filtered;
    }

    public static int sizeOfBiggestIsland(int[][] matrix)   {
        int maxIslandSize = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int islandSize = dfs(matrix, i, j, visited);
                    maxIslandSize = Math.max(maxIslandSize, islandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private static int dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Array to represent 8 possible directions (neighbours)
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][col] = true;
        int islandSize = 1;

        // Explore all 8 neighbours
        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                islandSize += dfs(matrix, newRow, newCol, visited);
            }
        }

        return islandSize;
    }

}
