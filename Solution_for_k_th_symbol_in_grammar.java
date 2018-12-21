public class Solution_for_k_th_symbol_in_grammar {
    public int kthGrammar(int N, int K) {
        if(N == 1)return 0;
        int t = (K-1)/2+1;
        int sym = K%2;
        int sum = 1;
        while(--N>0){
            if(sym == 0){
                sum *= -1 ;
            }
            int temp = (t-1)/2+1;
            sym = t%2;
            t = temp;

        }
        if(sum > 0){
            return 0;
        }
        else return 1;

    }
}
