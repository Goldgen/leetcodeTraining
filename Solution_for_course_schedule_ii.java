import java.util.ArrayList;
import java.util.List;

public class Solution_for_course_schedule_ii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        List<Integer>[] schedule = new ArrayList[numCourses];

        for(int i = 0;i < numCourses;i++){
            schedule[i] = new ArrayList<>();
        }

        for(int[] pair: prerequisites){
            schedule[pair[1]].add(pair[0]);
            inDeg[pair[0]]++;
        }

        int[] res = new int[numCourses];
        int k = 0;
        for(int i = 0;i < numCourses;i++){
            if(inDeg[i] == 0){
                res[k++] = i;
            }
        }
        if(k == 0){
            return new int[0];
        }
        int j = 0;
        List<Integer> tmp;
        while(k < numCourses){
            tmp = schedule[res[j++]];
            for(int num:tmp){
                if(--inDeg[num] == 0){
                    res[k++] = num;
                }
            }
            if(j == k){
                return new int[0];
            }
        }
        return res;
    }
}
