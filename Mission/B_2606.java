//import java.util.*;
//
//public class B_2606 {
//    public static void main(String[] args) {
//        int[][] arr = {
//            {1,2},
//            {2,3},
//            {1,5},
//            {5,2},
//            {5,6},
//            {4,7}
//        };
//        //연결되있는 노드들을 찾고 1번 컴을 제외한 그레프 개수를 찾자
//        Set<Integer> set = new HashSet<>();
//        //몇개의 그레프로 구성되있나 찾고 set에 담아서 갯수를 -1 해주자
////        List<Integer> list = new ArrayList<>();
////        for(int i=0; i<arr.length; i++) {
////            for(int j=0; j<=1; j++) {
////                list.add(arr[i][j]);
////            }
////        }
////        Collections.sort(list);
////        System.out.println(list);
//
//    }
//}
import java.util.*;

public class B_2606 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,3},
                {1,5},
                {5,2},
                {5,6},
                {4,7}
        };

        int n = 7; // 전체 컴퓨터의 수
        List<List<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결 정보를 그래프에 추가
        for (int i = 0; i < arr.length; i++) {
            int node1 = arr[i][0];
            int node2 = arr[i][1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1); // 1번 컴퓨터에서 시작

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        int result = visited.size() - 1; // 1번 컴퓨터는 제외

        System.out.println("1번 컴퓨터를 통해 웜 바이러스에 걸리는 컴퓨터 수: " + result);
    }
}
