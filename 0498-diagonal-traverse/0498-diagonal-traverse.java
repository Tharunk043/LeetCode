class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length==0) return new int[]{};
        int m = mat.length;
        int n = mat[0].length;
        int r= 0;
        int c= 0;
        int res[] = new int [m*n];
        int ind =0;
        while(ind<res.length){
            res[ind++] = mat[r][c];
            if((r+c)%2==0){
                if(c==n-1){
                    r++;
                }else if(r==0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }else{
                if(r==m-1){
                    c++;
                }else if(c==0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}