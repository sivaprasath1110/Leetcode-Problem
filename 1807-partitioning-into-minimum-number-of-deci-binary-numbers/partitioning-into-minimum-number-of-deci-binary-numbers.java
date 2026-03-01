class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (char c : n.toCharArray()) {
            int digit = c - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            
            // Early stop if we already reached 9
            if (maxDigit == 9) {
                return 9;
            }
        }
        
        return maxDigit;
    }
}