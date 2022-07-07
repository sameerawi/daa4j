package Tree;

import org.testng.annotations.Test;

public class leetcode_226_Invert_Binary_Tree
{
    public TreeNode invertTree(TreeNode root)
    {
        return null;
    }

    @Test
    void test()
    {
        Integer [] tree1 = { 2,1,3 };

        Integer [] tree2 = {4,2,7,1,3,6,9};

        TreeNode t1 = TreeNode.fromArray(tree1);
        TreeNode t2 = TreeNode.fromArray(tree2);

        t1.print();
        t2.print();
    }
}
