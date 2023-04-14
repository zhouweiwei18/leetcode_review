package com.nuaa.main.binarytree;

import com.nuaa.main.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {

    //方法1： 采用List记录路径
//    List<String> ans = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        getPath(root, new ArrayList<>());
//        return ans;
//    }
//    public void getPath(TreeNode root, List<Integer> path) {
//        if (root != null) {
//            path.add(root.val);
//            if (root.left == null && root.right == null) {
//                StringBuilder sb = new StringBuilder("");
//                for (int i = 0; i < path.size(); i++) {
//                    if (i != path.size() - 1) {
//                        sb.append(path.get(i));
//                        sb.append("->");
//                    } else {
//                        sb.append(path.get(i));
//                    }
//                }
//                ans.add(sb.toString());
//            } else {
//                getPath(root.left, new ArrayList<>(path));
//                getPath(root.right, new ArrayList<>(path));
//            }
//        }
//    }

    //方法2： 采用String记录路径
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        getPath(root, "");
        return ans;
    }

    public void getPath(TreeNode root, String path) {
        if (root != null) {
            StringBuilder ss = new StringBuilder(path);
            ss.append(root.val);
            if (root.left == null && root.right == null) {
                ans.add(ss.toString());
            } else {
                ss.append("->");
                getPath(root.left, ss.toString());
                getPath(root.right, ss.toString());
            }
        }
    }

}
