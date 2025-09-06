class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i =0;i<mat.length;i++){
            sum+=mat[i][i];
            sum+=mat[i][mat.length-i-1];
        }
        int n = mat.length;
        if(mat.length%2!=0){
            sum-=mat[n/2][n/2];
        }
        return sum;
    }
}