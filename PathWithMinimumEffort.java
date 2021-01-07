class Solution {
    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1_000_0000;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(isPossible(heights, m))
                r = m;
            else
                l = m + 1;
        }
        
        return l;
    }
    
    private Boolean isPossible(int[][] h, int d) {
        int r = h.length, c = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        while(q.size() != 0) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            if(x == r - 1 && y == c - 1) return true;
            for(int i = 0; i < dx.length; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && Math.abs(h[x][y] - h[nx][ny]) <= d) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return false;
    }
}