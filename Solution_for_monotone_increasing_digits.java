public class Solution_for_monotone_increasing_digits {
    public int monotoneIncreasingDigits(int N) {
        char[] num = String.valueOf(N).toCharArray();
        int i = 0;
        for(;i<num.length-1;i++){
            if(num[i] > num[i+1]){
                break;
            }
        }
        if(i == num.length-1){
            return N;
        }
        while (i>0&&num[i] == num[i-1])
            i--;
        num[i++] -= 1;
        while (i<num.length){
            num[i] = '9';
            i++;
        }
        return Integer.parseInt(new String(num));
    }
}
