/*
 Implement depth first search algorithm and Breadth First Search algorithm, Use an undirected
 graph and develop a recursive algorithm for searching all the vertices of a graph or tree data
 structure.
*/ 


/*
Time Complexity of BFS = O(V+E) where V is vertices and E is edges.
 Time Complexity of DFS is also O(V+E) where V is vertices and E is edges.
 BFS requires more memory space. DFS requires less memory
 */

import java.io.*;
import java.util.*;


class A1 {

    private HashMap<String, LinkedList<String>> adj;

    /*This line declares a private variable called adj of type HashMap<String, LinkedList<String>>.
     This variable will be used to store the adjacency list representation of the graph.
     */ 

    private boolean isDirected = true; 

    // variable name "isDirected" 

    A1() {
        adj = new HashMap<String, LinkedList<String>>();
    }

    void addEdge(String v, String w) {
        if (!adj.containsKey(v))
            adj.put(v, new LinkedList<String>());

        adj.get(v).add(w);

        if (!isDirected) {
            if (!adj.containsKey(w))
                adj.put(w, new LinkedList<String>());

            adj.get(w).add(v);
        }
    }

    boolean DFS(String v, String d, HashSet<String> visitSet) {
        HashSet<String> visited = visitSet == null ? new HashSet<String>() : visitSet;
        visited.add(v);
        System.out.print(v + " ");

        if (v.equals(d)) {
            return true;
        }

        Iterator<String> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            String n = i.next();
            if (!visited.contains(n))
                if (DFS(n, d, visited))
                    return true;
        }
        return false;
    }

    void BFS(String s, String d) {
        HashSet<String> visited = new HashSet<String>();

        LinkedList<String> queue = new LinkedList<String>();

        visited.add(s);
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");

            if (s.equals(d))
                return;

            Iterator<String> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                String n = i.next();
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        A1 g = new A1();

        g.addEdge("H", "A");
        g.addEdge("A", "D");
        g.addEdge("A", "B");
        g.addEdge("B", "F");
        g.addEdge("B", "C");
        g.addEdge("C", "E");
        g.addEdge("C", "G");
        g.addEdge("C", "H");
        g.addEdge("G", "H");
        g.addEdge("G", "E");
        g.addEdge("E", "F");
        g.addEdge("E", "B");
        g.addEdge("F", "A");
        g.addEdge("D", "F");

        System.out.println("Following is Depth First Traversal H -> E:");
        g.DFS("A", "H", null);

        System.out.println("\n\nFollowing is Breadth First Traversal H -> E:");
        g.BFS("H", "E");
    }
}