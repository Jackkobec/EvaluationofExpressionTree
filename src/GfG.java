/* A Tree node is defined as
class Node
{
    String data;
    Node left,right;

    Node(String data)
     {
	 this.data = data;
	 this.left = null;
	 this.right = null;
     }

}*/

class GfG {
    public int evalTree(Node root) {

        if (root == null) return 0;

        if (root.left == null || root.right == null) return Integer.parseInt(root.data);

        // Evaluate left subtree
        int leftValue = evalTree(root.left);

        // Evaluate right subtree
        int rightValue = evalTree(root.right);

        // Check which operator to apply
        if (root.data.equals("+"))
            return leftValue + rightValue;

        if (root.data.equals("-"))
            return leftValue - rightValue;

        if (root.data.equals("*"))
            return leftValue * rightValue;

        return leftValue / rightValue;
    }

}