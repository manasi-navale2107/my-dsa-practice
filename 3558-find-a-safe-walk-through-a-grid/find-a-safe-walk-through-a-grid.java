import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        dist[0][0] = grid.get(0).get(0);
        pq.offer(new int[]{0, 0, dist[0][0]});

        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if (cost > dist[r][c]) continue;

            if (r == m - 1 && c == n - 1) {
                return cost < health;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = cost + grid.get(nr).get(nc);

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.offer(new int[]{nr, nc, newCost});
                    }
                }
            }
        }

        return false;
    }
}