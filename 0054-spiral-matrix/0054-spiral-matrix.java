class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowbeg = 0;
        int rowend = matrix.length-1;
        int colbeg = 0;
        int colend = matrix[0].length-1;
        while(rowbeg<=rowend && colbeg<=colend ){
            for(int j = colbeg;j<=colend;j++){
                res.add(matrix[rowbeg][j]);
            }
            rowbeg++;
            for(int i = rowbeg;i<=rowend;i++){
                res.add(matrix[i][colend]);
            }
            colend--;
            if(rowbeg<=rowend){
                for(int j = colend;j>=colbeg;j--){
                    res.add(matrix[rowend][j]);
                }
            }
            rowend--;
            if(colbeg<=colend){
                for(int i = rowend;i>=rowbeg;i--){
                    res.add(matrix[i][colbeg]);
                }
            }
            colbeg++;
        }
        return res;
    }
}