import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Cost implements Comparable<Cost> {
    public int r, v;

    public Cost(int cost, int vertex) {
        r = cost;
        v = vertex;
    }

    @Override
    public int compareTo(Cost c) {
        if (r < c.r) return -1;
        if (r > c.r) return 1;
        if (v < c.v) return -1;
        if (v > c.v) return 1;
        return 0;
    }

}

public class Solution {
    public static int prims(int n, ArrayList<ArrayList<Cost>> edges, int start) {
        // Write your code here
        int result = 0;
        boolean[] visited = new boolean[edges.size()];
        PriorityQueue<Cost> pr = new PriorityQueue<>();
        n = n - 1;
        visited[start] = true;
        while (n-- != 0) {
            for (Cost x : edges.get(start)) {
                if (!visited[x.v]) {
                    pr.add(x);
                }
            }
            Cost cost = pr.remove();
            while (visited[cost.v] && visited[start]) {
                cost = pr.remove();
            }
            result += cost.r;
            System.out.println("Start: " + start + "     " + "result: " + result);
            System.out.println();
            visited[cost.v] = true;
            start = cost.v;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, start;
        N = scanner.nextInt();
        M = scanner.nextInt();
        ArrayList<ArrayList<Cost>> edges = new ArrayList<ArrayList<Cost>>();
        for (int i = 0; i <= N; ++i) {
            edges.add(new ArrayList<Cost>());
        }

        for (int i = 0; i < M; ++i) {
            int n1, n2, n3;
            n1 = scanner.nextInt();
            n2 = scanner.nextInt();
            n3 = scanner.nextInt();
            Cost cost = new Cost(n3, n2);
            Cost cost1 = new Cost(n3, n1);
            edges.get(n1).add(cost);
            edges.get(n2).add(cost1);
        }
        start = scanner.nextInt();

        int result = prims(N, edges, start);

        System.out.println(result);

    }
}
