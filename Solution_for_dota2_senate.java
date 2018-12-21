import java.util.LinkedList;
import java.util.Queue;

public class Solution_for_dota2_senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<Integer>();
        Queue<Integer> D = new LinkedList<Integer>();
        for(int i = 0;i<senate.length();i++){
            if(senate.charAt(i) == 'R'){
                R.add(i);
            }
            else {
                D.add(i);
            }
        }
        while(!R.isEmpty() && !D.isEmpty()){
            int R_index = R.poll();
            int D_index = D.poll();
            if(R_index < D_index){
                R.add(R_index + senate.length());
            }
            else{
                D.add(D_index + senate.length());
            }
        }
        return (R.size() > D.size())?"Radiant":"Dire";
    }
    public static void main(String[] args){
        String senate = "RDD";
        Solution_for_dota2_senate solution = new Solution_for_dota2_senate();
        System.out.println(solution.predictPartyVictory(senate));

    }
}
