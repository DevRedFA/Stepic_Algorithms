package algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_4_2_5 {

    static class Node implements Comparable<Node> {
        final int sum;
        String code;

        public Node(int freq) {
            sum = freq;
        }

        void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    static class LeafNode extends Node {
        char aChar;

        public LeafNode(char aChar, int freq) {
            super(freq);
            this.aChar = aChar;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(aChar + ": " + code);
        }
    }

    static class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        PriorityQueue<Node> result = new PriorityQueue<>();
        Map<Character, Node> nodeMap = new HashMap<>();
        Map<Character, Long> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(c -> c.charAt(0), Collectors.counting()));
        collect.forEach((ch, freq) -> {
            LeafNode leafNode = new LeafNode(ch, freq.intValue());
            nodeMap.put(ch, leafNode);
            result.add(leafNode);
        });
        int sum = 0;
        while ((result.size() > 1)) {
            InternalNode internalNode = new InternalNode(result.poll(), result.poll());
            sum += internalNode.sum;
            result.add(internalNode);
        }
        if (collect.size() == 1) {
            sum = input.length();
        }
        System.out.println(collect.size() + " " + sum);
        if (collect.size() == 1) {
            result.poll().buildCode("0");
        } else {
            result.poll().buildCode("");
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            sb.append(nodeMap.get(ch).code);
        }
        String s1 = sb.toString();
        System.out.println(s1);
    }
}
