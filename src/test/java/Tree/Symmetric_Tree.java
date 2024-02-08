package Tree;

// leetcode 101
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree
{
    public boolean isSymmetric_recursion(TreeNode root)
    {
        return isSymmetric_recursion(root.left, root.right);
    }

    public boolean isSymmetric_BFS(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while (q.size() > 0)
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if((left != null && right != null) && (left.val == right.val))
            {
                q.offer(left.left);
                q.offer(right.right);

                q.offer(left.right);
                q.offer(right.left);
            }
            else if(left == null && right == null)
            {
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    public boolean isSymmetric_recursion(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if(left.val == right.val)
        {
            return isSymmetric_recursion(left.left, right.right) && isSymmetric_recursion(left.right, right.left);
        }

        return false;
    }

    @Test
    public void test()
    {
        TreeNode t1 = TreeNode.fromValues(1,2,2,3,4,4,3);
        t1.print();

        TreeNode t2 = TreeNode.fromValues(1,2,2,null,3,null,3);
        t2.print();

        //System.out.println(isSymmetric(t1));
        assert(isSymmetric_recursion(t1));
        assert(!isSymmetric_recursion(t2));

        assert(isSymmetric_BFS(t1));
        assert(!isSymmetric_BFS(t2));
    }
}
