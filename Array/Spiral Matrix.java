class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int firstrow = 0;
        int lastrow = matrix.length-1;
        int firstcol = 0;
        int lastCol = matrix[0].length-1;
        for(int i=0; i<lastCol; i++){
            list.add(matrix[firstrow][i]);
        }
        for(int i=0; i<lastrow; i++){
            list.add(matrix[i][lastCol]);
        }
        for(int i=lastCol; i>firstcol; i--){
           list.add(matrix[lastrow][i]); 
        }
        for(int i=lastrow; i>firstrow; i--){
            list.add(matrix[i][firstcol]);
        }
    }
}
