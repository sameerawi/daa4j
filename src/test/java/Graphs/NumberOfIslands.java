package Graphs;

// leetcode 200 - Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.

import org.junit.Test;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfIslands
{
    protected int islands = 0;
    protected boolean [][] visited;

    public int numIslands_bfs(char[][] grid)
    {
        islands = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int r=0; r<grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == '1' && !visited[r][c])
                {
                    bfs(r,c, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(int r, int c, char[][] grid)
    {
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList() ;

        q.offer(new AbstractMap.SimpleEntry<>(r,c));

        while (q.size() > 0)
        {
            Map.Entry<Integer, Integer> entry = q.poll();

            int row = entry.getKey(), column = entry.getValue();

            int directions [][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            for(int xy[] : directions )
            {
                if ( row + xy[0] < grid.length && row + xy[0] >= 0
                 && column + xy[1] >= 0 && column + xy[1] < grid[row + xy[0]].length
                            && !visited[row + xy[0]][column + xy[1]] && grid[row + xy[0]][column + xy[1]] == '1' )
                {
                    q.offer(new AbstractMap.SimpleEntry<>(row + xy[0], column + xy[1]));
                    visited[row + xy[0]][column + xy[1]] = true;
                }
            }
        }
    }

    public int numIslands_dfs(char[][] grid)
    {
        visited = new boolean[grid.length][grid[0].length];
        islands = 0;

        for (int r=0; r<grid.length; r++)
        {
            for (int c=0; c<grid[r].length; c++)
            {
                islands +=visit(r,c,grid);
            }
        }

        return islands;
    }

    public int visit(int r, int c, char[][] grid)
    {
        if (r >= grid.length || r < 0 || c >= grid[r].length || c < 0 || visited[r][c] || grid[r][c] == '0')
            return 0;

        visited[r][c] = true;

        visit(r-1, c, grid);
        visit(r, c-1, grid);
        visit(r+1, c, grid);
        visit(r, c+1, grid);

        return 1;
    }

    @Test
    public void test()
    {
        char [][] grid1 = {  {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                        };

        assert (1 == numIslands_dfs(grid1));
        assert (1 == numIslands_bfs(grid1));

        char [][] grid2 = {
                            {'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}
                        };

        assert (3 == numIslands_dfs(grid2));
        assert (3 == numIslands_bfs(grid2));
    }
}
