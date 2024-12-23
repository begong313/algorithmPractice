import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ14940 {
    public static int[][] map;
    public static int[][] answer;
    public static boolean[][] visited;
    public static int startX, startY;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer= new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M; j++){
                int token = Integer.parseInt(st.nextToken());
                map[i][j] = token;
                answer[i][j] = -1;
                if(token == 2){
                    startY = i;
                    startX = j;
                }
                if(token==0){
                    answer[i][j] = 0;
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startY, startX, 0));
        visited[startY][startX] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            answer[p.y][p.x] = p.dist;
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextY][nextX] || map[nextY][nextX] == 0) {
                    continue;
                }
                q.add(new Point(nextY, nextX, p.dist + 1));
                visited[nextY][nextX] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j<M ; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Point {
        int x, y, dist;
        Point(int y, int x, int dist){
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}