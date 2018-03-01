import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Dijkstra {
    public static class Node implements Comparable{
        public List<Integer> edgesTo   = new ArrayList<Integer>();
        public List<Integer> edgesCost = new ArrayList<Integer>();
        public boolean done;
        public int cost = Integer.MAX_VALUE;

        @Override
        public int compareTo(Object arg1) {
            Node x = this;
            Node y = (Node) arg1;
            if (x.cost > y.cost) {
                return 1;
            } else if (x.cost < y.cost) {
                return -1;
            } else{
                return 0;
            }
        }
    }

    public static void search(List<Node> nodeList, Node start) {
        PriorityQueue q = new PriorityQueue();
        q.add(start);
        while (!q.isEmpty()) {
            System.out.println(q.size());
            Node node = (Node)q.poll();
            node.done = true;
            for (int i = 0; i < node.edgesTo.size(); i++) {
                Node to = nodeList.get(node.edgesTo.get(i));
                int cost = node.cost + node.edgesCost.get(i);
                if (cost < to.cost) {
                    to.cost = cost;
                    if (!q.contains(to)) {
                        q.add(to);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<Node>();
        Node startNode = new Node();
        startNode.cost = 0;
        startNode.edgesTo.add(1);
        startNode.edgesCost.add(5);
        startNode.edgesTo.add(2);
        startNode.edgesCost.add(4);
        startNode.edgesTo.add(3);
        startNode.edgesCost.add(2);
        list.add(startNode);
        Node node = new Node();
        node.edgesTo.add(2);
        node.edgesCost.add(2);
        node.edgesTo.add(4);
        node.edgesCost.add(6);
        list.add(node);

        node = new Node();
        node.edgesTo.add(1);
        node.edgesCost.add(2);
        node.edgesTo.add(0);
        node.edgesCost.add(4);
        node.edgesTo.add(3);
        node.edgesCost.add(3);
        node.edgesTo.add(5);
        node.edgesCost.add(2);
        list.add(node);

        node = new Node();
        node.edgesTo.add(0);
        node.edgesCost.add(2);
        node.edgesTo.add(2);
        node.edgesCost.add(3);
        node.edgesTo.add(5);
        node.edgesCost.add(6);
        list.add(node);

        node = new Node();
        node.edgesTo.add(1);
        node.edgesCost.add(6);
        node.edgesTo.add(5);
        node.edgesCost.add(6);
        list.add(node);
        Node goal = node;

        node = new Node();
        node.edgesTo.add(2);
        node.edgesCost.add(2);
        node.edgesTo.add(3);
        node.edgesCost.add(6);
        node.edgesTo.add(4);
        node.edgesCost.add(4);
        list.add(node);

        search(list, startNode);
        System.out.println("ゴールまで"+goal.cost);
    }
}


