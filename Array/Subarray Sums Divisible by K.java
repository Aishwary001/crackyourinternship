class Solution {
    public int subarraysDivByK(int[] nums, int k) {
      // this is the best approach to solve this question
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int result = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int modulo = sum % k;
            if(modulo < 0){
                modulo += k;
            }
            if(map.containsKey(modulo)){
                result += map.get(modulo);
                map.put(modulo,map.get(modulo) + 1);
            }else{
                map.put(modulo,1);
            }
        }

        return result;
    }
}
