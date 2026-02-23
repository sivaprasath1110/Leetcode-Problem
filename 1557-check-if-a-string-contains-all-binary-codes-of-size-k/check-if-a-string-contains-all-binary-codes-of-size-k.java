import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k; 
        
        if (s.length() - k + 1 < need) return false;
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
            
            if (set.size() == need) {
                return true;
            }
        }
        
        return false;
    }
}