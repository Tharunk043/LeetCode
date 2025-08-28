class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowbeg =0;
        int rowend = matrix.length-1;
        int colbeg = 0;
        int colend = matrix[0].length-1;
        while(rowbeg<=rowend && colbeg<=colend){
            //to traverse left to right
            for(int j = colbeg;j<=colend;j++){
                res.add(matrix[rowbeg][j]);
            }
            //to traverse up to down
            rowbeg++;
            for(int j = rowbeg;j<=rowend;j++){
                res.add(matrix[j][colend]);
            }
            colend--;
            //to traverse right to left
            if(rowbeg<=rowend){
                for(int j = colend;j>=colbeg;j--){
                    res.add(matrix[rowend][j]);
                }
            }
            rowend--;
            //to travers from down to up
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