public class Solution_for_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int s_length = s.length()-1;
        int t_length = t.length()-1;
        while(t_length >= 0 && s_length >= 0){
            if(s.charAt(s_length) == t.charAt(t_length)){
                s_length--;
                t_length--;
            }
            else t_length--;
        }
        return s_length < 0;
    }
}
