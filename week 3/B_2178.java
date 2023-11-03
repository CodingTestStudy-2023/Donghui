import java.util.LinkedList;
import java.util.Queue;
//이것은 BFS 넓이 우선 탐색이다
public class B_2178 {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        int[][] miro = {
            {1,0,1,1,1,1},
            {1,0,1,0,1,0},
            {1,0,1,0,1,1},
            {1,1,1,0,1,1}
        };
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        sc.nextLine(); // 개행 문자 제거
//
//        int[][] miro = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            String row = sc.nextLine();
//            for (int j = 0; j < M; j++) {
//                miro[i][j] = row.charAt(j) - '0';
//            }
//        } scanner로 받는게 왜 이렇게 어려운 것이냐

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        //상 하 우 좌

        int result = findShortestPath(n,m,miro,directions);
        System.out.println(result);
    }
    static int findShortestPath(int n, int m, int[][] miro, int[][] directions) {
        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                distance[i][j] = -1;
            }
        }
        //모든 셀의 거리를 -1로 설정하여 방문하지 않음을 나타냄
        //BFS알고리즘 시작 준비

        distance[0][0] = 1;
        //거리의 시작점을 1로 설정
        queue.offer(new int[]{0, 0});
        //시작점을 큐에 추가

        while(!queue.isEmpty()) {
            //큐가 비어 있지 않은 동안에는 다음 단계 수행
            int[] current = queue.poll();
            //큐에서 현재 탐색 중인 셀을 꺼내서 배열에 저장
            int x = current[0];
            int y = current[1];

            for(int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && miro[newX][newY] == 1 && distance[newX][newY] == -1) {
                    distance[newX][newY] = distance[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return distance[n-1][m-1];
    }
}
