class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        // For n = 1, any value is valid
        if (n == 1) return m;

        int size = 2 * m;

        long[] vec = new long[size];

        // length = 2 initial states
        // up[v] = previous value is smaller than v
        // down[v] = previous value is greater than v
        for (int v = 0; v < m; v++) {
            vec[v] = v;                 // UP
            vec[m + v] = m - 1 - v;     // DOWN
        }

        long[][] trans = new long[size][size];

        for (int v = 0; v < m; v++) {
            // If last direction was UP, next must be DOWN
            for (int u = 0; u < v; u++) {
                trans[m + u][v] = 1;
            }

            // If last direction was DOWN, next must be UP
            for (int u = v + 1; u < m; u++) {
                trans[u][m + v] = 1;
            }
        }

        long power = n - 2;

        while (power > 0) {
            if ((power & 1) == 1) {
                vec = multiplyMatrixVector(trans, vec);
            }

            trans = multiplyMatrix(trans, trans);
            power >>= 1;
        }

        long ans = 0;
        for (long val : vec) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }

    private long[] multiplyMatrixVector(long[][] mat, long[] vec) {
        int n = vec.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    private long[][] multiplyMatrix(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                for (int j = 0; j < n; j++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}