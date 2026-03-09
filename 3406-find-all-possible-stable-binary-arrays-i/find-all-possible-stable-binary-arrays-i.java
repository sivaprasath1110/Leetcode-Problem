class Solution {

    int MOD = 1000000007;
    Integer[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero + 1][one + 1][2][limit + 1];
        return dfs(zero, one, limit, -1, 0);
    }

    int dfs(int z, int o, int limit, int last, int count) {

        if (z == 0 && o == 0) return 1;

        if (last != -1 && memo[z][o][last][count] != null)
            return memo[z][o][last][count];

        long ans = 0;

        // place 0
        if (z > 0) {
            if (last != 0) {
                ans += dfs(z - 1, o, limit, 0, 1);
            } else if (count < limit) {
                ans += dfs(z - 1, o, limit, 0, count + 1);
            }
        }

        // place 1
        if (o > 0) {
            if (last != 1) {
                ans += dfs(z, o - 1, limit, 1, 1);
            } else if (count < limit) {
                ans += dfs(z, o - 1, limit, 1, count + 1);
            }
        }

        ans %= MOD;

        if (last != -1)
            memo[z][o][last][count] = (int) ans;

        return (int) ans;
    }
}