class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowbegin = 0;
        int rowend = matrix.length-1;
        int colbegin = 0;
        int colend = matrix[0].length-1;
        while(rowbegin<=rowend && colbegin<=colend){
            for(int j = colbegin;j <=colend;j++){
                res.add(matrix[rowbegin][j]);
            }
            rowbegin++;
            for(int j = rowbegin;j<=rowend;j++){
                res.add(matrix[j][colend]);
            }
            colend--;
            if(rowbegin<=rowend){
                for(int j = colend;j>=colbegin;j--){
                    res.add(matrix[rowend][j]);
                }
            }
            rowend--;
            if(colbegin<=colend){
                for(int j = rowend;j>=rowbegin;j--){
                    res.add(matrix[j][colbegin]);
                }
            }
            colbegin++;
        }
        return res;
    }
}