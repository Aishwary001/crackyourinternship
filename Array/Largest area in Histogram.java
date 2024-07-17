// https://leetcode.com/u/aishwarylifeline/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];

        //nsl
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<heights.length; i++){
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        s= new Stack<>();
        // nsr
        for(int i=heights.length-1; i>=0; i--){
            while(!s.isEmpty() && heights[i]<=heights[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = heights.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        int max = 0;
        for(int i=0; i<heights.length; i++){
            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;
             max = Math.max(area,max);
        }
        return max;
    }
}
