import java.util.*;

public class Solution_for_evaluate_division {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // build graph, use adjacent list
        map = new HashMap();
        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if(!map.containsKey(equation[0])) map.put(equation[0], new ArrayList());
            map.get(equation[0]).add(new Info(equation[1], values[i]));

            if(!map.containsKey(equation[1])) map.put(equation[1], new ArrayList());
            map.get(equation[1]).add(new Info(equation[0], 1 / values[i]));
        }

        double[] result = new double[queries.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = find(queries[i][0], queries[i][1], 1, new HashSet());
        }
        return result;
    }
    HashMap<String, List<Info>> map;

    private double find(String start, String end, double value, Set<String> visited) {
        if(visited.contains(start)) return -1;
        if(!map.containsKey(start)) return -1;

        if(start.equals(end)) return value;
        visited.add(start);
        for(Info next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if(sub != -1.0) return sub;
        }

        visited.remove(start);
        return -1;
    }

    class Info {
        String den;
        double val;
        Info(String den, double val) { this.den = den; this.val = val; }
    }
}
