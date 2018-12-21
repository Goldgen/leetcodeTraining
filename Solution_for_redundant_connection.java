public class Solution_for_redundant_connection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for(int i = 0;i<edges.length;i++){
            parent[i] = i;
        }
        for(int[] edge:edges){
            int from = edge[0];
            int to = edge[1];
            if(find(parent,to) == find(parent,from)){
                return edge;
            }
            else parent[find(parent,from)] = find(parent,to);
        }
        return new int[2];
    }
    private int find(int[] parent, int f){
        if(parent[f] != f){
            parent[f] = find(parent,parent[f]);
        }
        return parent[f];

    }

}
