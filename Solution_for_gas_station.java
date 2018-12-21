public class Solution_for_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int candidate = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < gas.length * 2; i++) {
            sum += gas[i % gas.length] - cost[i % gas.length];
            if (sum < 0) {
                candidate = i + 1;
                sum = 0;
                cnt = 0;
            } else {
                cnt++;
                if (cnt >= gas.length) {
                    return candidate;
                }
            }
        }
        return -1;
    }
}
