package solution;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>>res = new ArrayList<>();
      dfs(root, 0, res);
      return res;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>>res) {
        if (node == null)
            return;
        if (depth == res.size())
            res.add(new ArrayList<>());
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1,res);
    }

    public static void main(String[] rags) {
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.createTree(str);
        List res = new _102().levelOrder(root);
        Iterator iterator = res.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
