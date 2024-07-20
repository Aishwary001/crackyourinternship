class Solution {
    static int t[]; // Recursion + Memoization
    public static int solve(int nums[], int i){
        if(i == nums.length - 1){
            return 1;
        }
        if(t[i] != -1){
            return t[i];
        }
        for(int idx=1; idx<=nums[i]; idx++){
            if(solve(nums,i+idx) == 1){
                return t[i] = 1;
            }
        }

        return t[i] = 0;
    }
    public boolean canJump(int[] nums) {
        t = new int[nums.length];
        Arrays.fill(t,-1);
        return solve(nums,0) == 1 ? true : false;
    }
}
