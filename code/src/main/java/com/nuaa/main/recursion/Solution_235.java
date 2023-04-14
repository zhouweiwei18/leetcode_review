package com.nuaa.main.recursion;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 首先分贝获取p,q的路径
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);

        TreeNode ancestor = null;

        // 查询最近的公共祖先
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }

        return ancestor;

    }

    private List<TreeNode> getPath(TreeNode root, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();

        TreeNode node = root;
        while (node != q) {
            path.add(node);
            if (node.val < q.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        path.add(node);

        return path;

    }


    // 方法二
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;

        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }*/
}
