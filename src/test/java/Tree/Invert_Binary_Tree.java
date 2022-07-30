package Tree;

import org.junit.Test;
import java.util.*;

// leetcode 226
// Given the root of a binary tree, invert the tree, and return its root.

public class Invert_Binary_Tree
{
    public TreeNode invertTree_recursion(TreeNode root)
    {
        invertTree_recursion(root.left, root.right);
        return root;
    }

    public void invertTree_recursion(TreeNode left, TreeNode right)
    {
        if (left != null && right != null)
        {
            int leftVal = left.val;
            left.val = right.val;
            right.val = leftVal;

            invertTree_recursion(left.left, right.right);
            invertTree_recursion(left.right, right.left);
        }
    }

    @Test
    public void test()
    {
        TreeNode t1 = TreeNode.fromValues(4,2,7,1,3,6,9);
        t1.print();
        invertTree_recursion(t1);
        t1.print();

        TreeNode t2 = TreeNode.fromValues(2,1,3);
        t2.print();
        invertTree_recursion(t2);
        t2.print();
    }
}
