package Tree.QuestionBank;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        if (root == null) {
            return arr;
        }

        while (!q.isEmpty()) {

            int length = q.size();
            List<Integer> aList = new ArrayList<>();
            for (int i = 0; i < length; i++) {

                TreeNode p = q.poll();
                aList.add(p.val);
                System.out.println(p.val);
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }

            arr.add(aList);

        }

        return arr;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrderTree obj = new LevelOrderTree();
        List<List<Integer>> arr = new ArrayList<>();

        System.out.println(obj.levelOrder(root));
    }
}
