import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    String data;
    Node left, right;

    Node(String d) {
        data = d;
        left = null;
        right = null;
    }
}

/**
 * Input:
 * The first line of input contains an integer T denoting the no of test cases .
 * Then T test cases follow. Each test case contains an integer N denoting the no of nodes.
 * Then in the next line are N space separated values of the nodes of the Binary tree filled in continous way from the left to the right.
 * <p>
 * <p>
 * <p>
 * At first enter count of tests, for one use 1
 *
 * Next enter the number of Nodes, example 3
 * after enter Nodes values, example: + 3 4
 * Its means 3 + 4. Output will be 7
 *
 * Tty input:
 * 2
 * 7
 * + * - 5 4 100 20
 * <p>
 * 3
 * - 4 7
 */
class ExpressionTree {
    static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++)
                s[i] = sc.next();
            GfG g = new GfG();

            root = null;
            makeTree(s, n);
            System.out.println(g.evalTree(root));
        }
    }


    public static void makeTree(String[] s, int n) {
        Queue<Node> queue = new LinkedList<Node>();
        root = new Node(s[0]);
        queue.add(root);
        int p = 1;
        try {
            while (n > 0) {
                Node proot = queue.poll();
                proot.left = new Node(s[p]);
                queue.add(proot.left);
                p++;
                n--;
                if (n > 0) {
                    proot.right = new Node(s[p]);
                    queue.add(proot.right);
                    p++;
                    n--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }
}