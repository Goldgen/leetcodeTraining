public class Solution_for_friend_circle {
    public int findCircleNum(int[][] M) {
        int count = M.length;
        int[] root = new int[M.length];
        for(int i=0;i<M.length;i++){
            root[i] =i;
        }
        for(int i=0;i<M.length;i++){
            for(int j=i;j<M[0].length;j++){
                if(M[i][j]==1){
                    int rooti = findRoot(root,i);
                    int rootj = findRoot(root,j);
                    if(rooti!=rootj){
                        root[rooti] = rootj;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    private int findRoot(int[] roots, int id){
        while(roots[id]!=id){
            roots[id] = roots[roots[id]];
            id = roots[id];

        }
        return roots[id];
    }
}
