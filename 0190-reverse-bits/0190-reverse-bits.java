class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // shift result left to make room
            result <<= 1;
            // take the last bit of n and add to result
            result |= (n & 1);
            // shift n right to process the next bit
            n >>>= 1;  // unsigned right shift
        }
        return result;
    }
}
