class Solution {
    public int[] pathExistenceQueries(
            int n,
            int[] nums,
            int maxDiff,
            int[][] queries
    ) {
        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

       
        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] sortedNums = new int[n];

        
        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[order[i]];
            position[order[i]] = i;
        }

        
        int[] next = new int[n];
        int right = 0;

        for (int left = 0; left < n; left++) {
            if (right < left) {
                right = left;
            }

            while (
                right + 1 < n
                && (long) sortedNums[right + 1] - sortedNums[left] <= maxDiff
            ) {
                right++;
            }

            next[left] = right;
        }

       
        int[] component = new int[n];
        int componentId = 0;

        for (int i = 1; i < n; i++) {
            if ((long) sortedNums[i] - sortedNums[i - 1] > maxDiff) {
                componentId++;
            }

            component[i] = componentId;
        }

        int log = 1;

        while ((1L << log) <= n) {
            log++;
        }

        
        int[][] jump = new int[log][n];

        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];
        }

        for (int k = 1; k < log; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] answer = new int[queries.length];

        for (int queryIndex = 0; queryIndex < queries.length; queryIndex++) {
            int u = queries[queryIndex][0];
            int v = queries[queryIndex][1];

            int left = position[u];
            int target = position[v];

            if (left > target) {
                int temp = left;
                left = target;
                target = temp;
            }

         
            if (left == target) {
                answer[queryIndex] = 0;
                continue;
            }

            
            if (component[left] != component[target]) {
                answer[queryIndex] = -1;
                continue;
            }

            int current = left;
            int distance = 0;

            
            for (int k = log - 1; k >= 0; k--) {
                if (jump[k][current] < target) {
                    current = jump[k][current];
                    distance += 1 << k;
                }
            }

           
            answer[queryIndex] = distance + 1;
        }

        return answer;
    }
}