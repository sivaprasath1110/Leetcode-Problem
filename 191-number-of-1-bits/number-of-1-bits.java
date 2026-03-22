public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            n = n & (n - 1); // remove last set bit
            count++;
        }
        
        return count;
    }
}