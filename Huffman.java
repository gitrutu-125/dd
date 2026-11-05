
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}

public class Huffman {

    // Generate Huffman Codes
    static void printCodes(Node root, String code) {

        if (root == null)
            return;

        // Leaf node contains a character
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        // Left = 0, Right = 1
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        // Input characters and frequencies
        for (int i = 0; i < n; i++) {

            System.out.print("Enter character: ");
            char ch = sc.next().charAt(0);

            System.out.print("Enter frequency: ");
            int freq = sc.nextInt();

            pq.add(new Node(ch, freq));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            // Remove two minimum frequency nodes
            Node left = pq.poll();
            Node right = pq.poll();

            // Create new parent node
            Node parent = new Node(
                '-', left.freq + right.freq
            );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        // Print Huffman Codes
        System.out.println("\nHuffman Codes:");

        Node root = pq.poll();

        printCodes(root, "");
        
        sc.close();
    }
}
/*Character	Frequency	Huffman Code
A	5	1100
B	9	1101
C	12	100
D	13	101
E	16	111
F	45	0
*/