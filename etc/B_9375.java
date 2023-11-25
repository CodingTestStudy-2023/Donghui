import java.util.*;

public class B_9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            Map<String, Set<String>> map = new HashMap<>() {
                {
                    for (int j = 0; j < n; j++) {
                        String value = sc.next(), key = sc.next();

                        computeIfAbsent(key, s -> new HashSet<>());
                        get(key).add(value);
                    }
                }
            };
            int sum = 1;
            if(map.keySet().size() == 1) {
                sum = 0;
            }

            for (String key : map.keySet()) {
                sum *= map.get(key).size();
            }
            System.out.println(map.values().size() + sum);

        }

    }
}
//import java.util.*;
//
//public class B_9375 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            Map<String, Set<String>> map = new HashMap<>();
//
//            for (int j = 0; j < n; j++) {
//                String value = sc.next(), key = sc.next();
//                map.computeIfAbsent(key, k -> new HashSet<>()).add(value);
//            }
//
//            int sum = 1;
//            for (String key : map.keySet()) {
//                sum *= map.get(key).size() + 1; // 각 종류별로 옵션 수 + 안 입는 경우
//            }
//
//            System.out.println(sum - 1); // 모두 안 입는 경우 제외
//        }
//    }
//}
