package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(E+Q(V+E)) -> O(Q(V+E)), E=equations.size(), V=the number of distinct variables in the input, Q=queries.size()
 * @SpaceComplexity O(V+E+Q)
 */
public class Java_399 {
    private static class Edge {
        String neighbor;
        double weight;

        private Edge(String neighbor, double weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public double[] calcEquation_google_l4(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divider = equations.get(i).get(1);
            double quotient = values[i];

            graph.computeIfAbsent(dividend, v -> new ArrayList<Edge>()).add(new Edge(divider, quotient));
            graph.computeIfAbsent(divider, v -> new ArrayList<Edge>()).add(new Edge(dividend, 1.0 / quotient));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                res[i] = -1.0;
            } else if (start.equals(end)) {
                res[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(start, end, 1.0, graph, visited);
            }
        }

        return res;
    }

    private double dfs(String curr, String target, double accProduct, Map<String, List<Edge>> graph, Set<String> visited) {
        if (curr.equals(target)) return accProduct;

        visited.add(curr);

        for (Edge edge : graph.get(curr)) {
            if (!visited.contains(edge.neighbor)) {
                double result = dfs(edge.neighbor, target, accProduct * edge.weight, graph, visited);

                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }
}