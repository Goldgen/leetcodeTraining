public class Solution_for_count_numbers_with_unique_digits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int cursum = 10;
        int curmult = 9;
        int unique = 9;
        for(int i = 0;i< n;i++){
           if(curmult > 0){
               unique *= curmult;
               curmult--;
               cursum += unique;

           }
           else break;
        }
        return cursum;
    }

}
