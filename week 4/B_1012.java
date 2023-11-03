

public class B_1012 {
    public static void main(String[] args) {
        int width = 5;
        int height = 3;
        int digit = 6;
        int[][] location = {
                {0, 2},
                {1, 2},
                {2, 2},
                {3, 2},
                {4, 2},
                {4, 0},
        };
        boolean[][] path = new boolean[width][height];
        for (int i = 0; i < location.length; i++) {
            path[location[i][0]][location[i][1]] = true;
        }

        int graphCount = countGraphs(path, width, height);
        System.out.println(graphCount);
    }

    public static int countGraphs(boolean[][] path, int width, int height) {
        int graphCount = 0;
        boolean[][] visited = new boolean[width][height];
        //이미 방문한 위치 추적
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (path[i][j] && !visited[i][j]) {
                    //배추가 심어져있고 방문하지 않았다면
                    dfs(path, visited, i, j);
                    graphCount++;
                }
            }
        }
        return graphCount;
    }

    public static void dfs(boolean[][] path, boolean[][] visited, int i, int j) {
        int width = path.length;
        int height = path[0].length;

        if (i < 0 || i >= width || j < 0 || j >= height || visited[i][j] || !path[i][j]) {
                                                            //방문하였거나 배추가 없을때
            return;
        }

        visited[i][j] = true;
        dfs(path, visited, i + 1, j);
        dfs(path, visited, i - 1, j);
        dfs(path, visited, i, j + 1);
        dfs(path, visited, i, j - 1);
    }
}

//        int T = sc.nextInt(); // 테스트 케이스 개수
//
//        for (int t = 0; t < T; t++) {
//            int width = sc.nextInt(); // 배추밭의 가로길이
//            int height = sc.nextInt(); // 배추밭의 세로길이
//            int k = sc.nextInt(); // 배추가 심어져 있는 위치의 개수
//            boolean[][] path = new boolean[width][height];
//
//            for (int i = 0; i < k; i++) {
//                int x = sc.nextInt(); // 배추의 X 좌표
//                int y = sc.nextInt(); // 배추의 Y 좌표
//                path[x][y] = true;
//            }
//
//            int graphCount = countGraphs(path, width, height);
//            System.out.println(graphCount);
//        }
//        sc.close();

//import java.util.Stack;
//
//public class B_1012 {
//    public static void main(String[] args) {
//        int width = 5;
//        int height = 3;
//        int[][] location = {
//                {0, 2},
//                {1, 2},
//                {2, 2},
//                {3, 2},
//                {4, 2},
//                {4, 0},
//        };
//        boolean[][] path = new boolean[width][height];
//        for (int i = 0; i < location.length; i++) {
//            path[location[i][0]][location[i][1]] = true;
//        }
//
//        int graphCount = countGraphs(path, width, height);
//        System.out.println(graphCount);
//    }
//
//    public static int countGraphs(boolean[][] path, int width, int height) {
//        int graphCount = 0;
//        boolean[][] visited = new boolean[width][height];
//
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                if (path[i][j] && !visited[i][j]) {
//                    dfsUsingStack(path, visited, i, j);
//                    graphCount++;
//                }
//            }
//        }
//        return graphCount;
//    }
//
//    public static void dfsUsingStack(boolean[][] path, boolean[][] visited, int startX, int startY) {
//        int width = path.length;
//        int height = path[0].length;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(startX * height + startY); //  시작 위치 (startX, startY)를 스택에 추가합니다. 2차원 배열의 좌표를 1차원 인덱스로 변환하여 스택에 저장합니다. 이렇게 하는 이유는 스택에 1차원 인덱스를 저장하면 좌표로 다시 변환할 필요가 없기 때문입니다.
//        visited[startX][startY] = true;
//
//        while (!stack.isEmpty()) {
//            int node = stack.pop();
//            int x = node / height; // int x = node / height;와 int y = node % height;를 사용하여 1차원 인덱스를 2차원 좌표로 변환합니다.
//            int y = node % height;
//
//            int[] dx = {1, -1, 0, 0};   //좌우
//            int[] dy = {0, 0, 1, -1};   //상하
//
//            for (int k = 0; k < 4; k++) {
//                int newX = x + dx[k];
//                int newY = y + dy[k];
//
//                if (newX >= 0 && newX < width && newY >= 0 && newY < height && path[newX][newY] && !visited[newX][newY]) {
//                    stack.push(newX * height + newY);
//                    visited[newX][newY] = true;
//                }
//            }
//        }
//    }
//}
