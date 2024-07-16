// We can do that question by the help of HashMap also but this is better than hashmap
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean taken[] = new boolean[nums.length];
        for(int num : nums){
            if(taken[num]){
                return num;
            }
            taken[num] = true;
        }

        return -1;
    }
}
