public class Solution_for_recognise_string {
    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] count = new int[26];
        int[] validIndex = new int[26];

        for (char c : s.toCharArray()) count[c - 'a']++;

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int index = find(count, validIndex, i);
            if (index == -1) return "";
            else {
                count[index]--;
                validIndex[index] = i + 2;
                newString.append((char)(index + 'a'));
            }
        }
        return newString.toString();
    }
    private int find(int[] count, int[] validIndex, int curr) {
        int res = -1;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max && validIndex[i] <= curr) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }
}
