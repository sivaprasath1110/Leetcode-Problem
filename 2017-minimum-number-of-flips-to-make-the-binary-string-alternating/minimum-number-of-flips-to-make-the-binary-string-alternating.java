class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < ss.length(); right++) {

            char c = ss.charAt(right);

            if (c != (right % 2 == 0 ? '0' : '1')) diff1++;
            if (c != (right % 2 == 0 ? '1' : '0')) diff2++;

            if (right - left + 1 > n) {
                char lc = ss.charAt(left);

                if (lc != (left % 2 == 0 ? '0' : '1')) diff1--;
                if (lc != (left % 2 == 0 ? '1' : '0')) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}