package Tree.QuestionBank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserialize {

    public String serialize(TreeNode root) {
        List<String> serializeList = new ArrayList<>();
        serializeDFS(root, serializeList);
        return String.join("", serializeList);
    }

    public void serializeDFS(TreeNode root, List<String> stringList) {
        if (root == null) {
            stringList.add("N");
            return;
        }
        stringList.add(String.valueOf(root.val));
        serializeDFS(root.left, stringList);
        serializeDFS(root.right, stringList);
    }

    public TreeNode deserialize(String data) {
        String[] add = data.split("");
        List<String> list = new ArrayList<>(Arrays.asList(add));
        return deserializeDFS(list);

    }

    public TreeNode deserializeDFS(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String value = list.remove(0);
        if (value.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeDFS(list);
        node.right = deserializeDFS(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        SerializeAndDeserialize sd = new SerializeAndDeserialize();
        sd.serialize(root);
        String result = sd.serialize(root);
        System.out.println(sd.serialize(root));
        System.out.println(sd.deserialize(result));

    }
}
