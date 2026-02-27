class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        
        if (zeros == 0) return 0;

        if (k == n) {
            if (zeros == n) return 1;
            return -1;
        }
        
        if (k == 1) return zeros;
        
        int ones = n - zeros;
        
        int t = (zeros + k - 1) / k;

        for (; t <= 2 * n; t++) {
            
            int total = t * k;

            if ((total - zeros) % 2 != 0) continue;
            
            int maxOdd = (t % 2 == 1) ? t : t - 1;
            int maxEven = (t % 2 == 0) ? t : t - 1;
            
            long minSum = zeros;
            long maxSum = (long) zeros * maxOdd + (long) ones * maxEven;
            
            if (total >= minSum && total <= maxSum) {
                return t;
            }
        }
        
        return -1;
    }
}