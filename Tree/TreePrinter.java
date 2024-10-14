class TreePrinter {
    protected static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    protected static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    protected static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static void printIndented(Node root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        StringBuilder sb = new StringBuilder();
        printIndentedHelper(root, sb, "", "");
        System.out.println(sb.toString());
    }

    protected static void printVisual(Node root) {
        int height = getHeight(root);
        int width = (1 << height) - 1;
        String[][] grid = new String[height * 2 - 1][width];
        fillGrid(grid, root, 0, 0, width - 1);
        printGrid(grid);
    }

    private static void printIndentedHelper(Node node, StringBuilder sb, String padding, String pointer) {
        if (node == null) {
            sb.append(padding).append(pointer).append("null\n");
            return;
        }

        sb.append(padding).append(pointer).append(node.val).append("\n");

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (pointer.equals("├── ")) {
            paddingBuilder.append("│   ");
        } else {
            paddingBuilder.append("    ");
        }

        String paddingForBoth = paddingBuilder.toString();
        String pointerForRight = "└── ";
        String pointerForLeft = (node.right != null) ? "├── " : "└── ";

        printIndentedHelper(node.left, sb, paddingForBoth, pointerForLeft);
        printIndentedHelper(node.right, sb, paddingForBoth, pointerForRight);
    }

    private static int getHeight(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static void fillGrid(String[][] grid, Node node, int row, int left, int right) {
        if (node == null)
            return;

        int mid = (left + right) / 2;
        grid[row][mid] = String.valueOf(node.val);

        if (node.left != null) {
            grid[row + 1][mid - 1] = "/";
            fillGrid(grid, node.left, row + 2, left, mid - 1);
        }
        if (node.right != null) {
            grid[row + 1][mid + 1] = "\\";
            fillGrid(grid, node.right, row + 2, mid + 1, right);
        }
    }

    private static void printGrid(String[][] grid) {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell == null ? " " : cell);
            }
            System.out.println();
        }
    }

}