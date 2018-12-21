import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_for_increasing_subsequences {
    public ArrayList findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        dfs(result,new ArrayList<>(),nums,0);
        return new ArrayList(result);
    }

    private void dfs(Set<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        if(temp.size()>1) result.add(new ArrayList<>(temp));
        for(int i = start; i<nums.length;i++){
            if(temp.size() == 0 || temp.get(temp.size()-1)<=nums[i]){
                temp.add(nums[i]);
                dfs(result,temp,nums,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
