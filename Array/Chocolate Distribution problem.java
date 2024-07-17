import java.util.* ;
import java.io.*; 

public class Solution {
    static int result;

    public static void determine(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
            min = Math.min(min, list.get(i));
        }

        result = Math.min(max - min, result);
    }

    public static void solve(int n, ArrayList<Integer> chocolates, int idx, ArrayList<Integer> list, int m) {
        if (m == 0) {
            determine(list);
            return; // Stop further recursion
        }
        for (int i = idx; i < n; i++) {
            list.add(chocolates.get(i));
            solve(n, chocolates, i + 1, list, m - 1);
            list.remove(list.size() - 1);
        }
    }

    static int findMinDiff(int n, int m, ArrayList<Integer> chocolates) {
        ArrayList<Integer> list = new ArrayList<>();
        result = Integer.MAX_VALUE;
        solve(n, chocolates, 0, list, m);

        return result;
    }
}
