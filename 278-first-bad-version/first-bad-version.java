public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2; // avoid overflow
            
            if (isBadVersion(mid)) {
                right = mid; // possible answer
            } else {
                left = mid + 1;
            }
        }
        
        return left; // or right (both same)
    }
}