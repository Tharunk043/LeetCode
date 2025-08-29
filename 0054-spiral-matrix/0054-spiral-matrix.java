class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowbeg = 0;
        int colbeg =0;
        int rowend = matrix.length-1;
        int colend = matrix[0].length-1;
        while(rowbeg<=rowend && colbeg<=colend){
            for(int j = colbeg;j<=colend;j++){
                res.add(matrix[rowbeg][j]);
            }
            rowbeg++;
            for(int j = rowbeg;j<=rowend;j++){
                res.add(matrix[j][colend]);
            }
            colend--;
            if(rowbeg<=rowend){
                for(int j = colend;j>=colbeg;j--){
                    res.add(matrix[rowend][j]);
                }
            }
            rowend--;
            if(colbeg<=colend){
                for(int j = rowend;j>=rowbeg;j--){
                    res.add(matrix[j][colbeg]);
                }
            }
            colbeg++;
        }
        return res;
    }
}