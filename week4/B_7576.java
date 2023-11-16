import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class B_7576 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] tomato = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,1}
        };
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int day = howLongDay(n, m, tomato, directions);
        System.out.println(day);
    }
    static int howLongDay(int n, int m, int[][] tomato, int[][] directions) {
        int[][] distance = new int[n][m];
        Queue<List<Integer>> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(tomato[i][j] == 1) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    queue.offer(pos);
                    distance[i][j] = 0;
                }
            }
        }

        int maxDay = 0;

        while(!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int currentX = current.get(0);
            int currentY = current.get(1);

            for(int[] dir : directions) {
                int newX = currentX + dir[0];
                int newY = currentY + dir[1];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && tomato[newX][newY] == 0) {
                    tomato[newX][newY] = 1; //토마토를 익히기
                    distance[newX][newY] = distance[currentX][currentY] + 1;
                    maxDay = Math.max(maxDay, distance[newX][newY]);
                    List<Integer> newPos = new ArrayList<>();
                    newPos.add(newX);
                    newPos.add(newY);
                    queue.offer(newPos);
                }
            }
        }
        //모든 토마토가 익었는지 확인
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(tomato[i][j] == 0) {
                    return -1; //익히지 못하는 토마토
                }
            }
        }
        return maxDay;
    }
}
