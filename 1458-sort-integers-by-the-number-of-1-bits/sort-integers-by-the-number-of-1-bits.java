import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(nums, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            
            if (bitA == bitB) {
                return a - b;
            }
            return bitA - bitB;
        });
        
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}