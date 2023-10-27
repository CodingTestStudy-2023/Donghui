import java.util.HashSet;
import java.util.Set;

public class B_10451 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8,9,10};
        int[] permutation = {2, 1, 3, 4, 5, 6, 7, 9, 10, 8};
        int cycle = 0;
        Set<Integer> set = new HashSet<>();
        //이미 확인한 인덱스를 저장하기 위한

        for (int i = 0; i < n; i++) {
            if(arr[i] == permutation[i]) {
                cycle++;
            } else {
                if (!set.contains(i)) {
                    int current = i;
                    while (!set.contains(current) && current >= 0 && current < n) {
                        set.add(current);
                        current = permutation[current];
                    }
                    cycle++;
                }
            }
        }
        System.out.println(cycle);
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt(); // 테스트 케이스의 개수
//
//        for (int t = 0; t < T; t++) {
//            int N = sc.nextInt(); // 순열의 크기 N
//            int[] permutation = new int[N + 1]; // 순열을 저장할 배열
//            boolean[] visited = new boolean[N + 1]; // 방문 여부를 표시하는 배열
//            int cycles = 0; // 순열 사이클의 개수
//
//            for (int i = 1; i <= N; i++) {
//                permutation[i] = sc.nextInt();
//            }
//
//            for (int i = 1; i <= N; i++) {
//                if (!visited[i]) {
//                    int current = i;
//                    while (!visited[current]) {
//                        visited[current] = true;
//                        current = permutation[current];
//                    }
//                    cycles++;
//                }
//            }
//
//            System.out.println(cycles);
//        }
//
//        sc.close();
//    }
//}