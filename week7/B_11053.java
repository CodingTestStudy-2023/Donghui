import java.util.*;

public class B_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 모든 위치에 대해 LIS 길이를 최소 1로 초기화

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().getAsInt();
        System.out.println(maxLength);

//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        int min = arr[0];
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i] < min) {
//                min = arr[i];
//            }
//            if(min < arr[i]) {
//                list.add(arr[i]);
//            }
//        }
//        System.out.println(list.size());
        //배열 안의 수중에 제일 낮은 값부터 하나씩 증가 수열을 찾은 후 그중 최대값을 뽑는다.
//        int[] arr = {3,4,5,10,2,6,7,8};
//        int min = arr[0];
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i]<min) {
//                min = arr[i];
//            }
//            if(min <arr[i]) {
//                list.add(arr[i]);
//            }
//        }
//        System.out.println(list.size());

//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<arr.length; i++) {
//            set.add(arr[i]);
//        }
//        System.out.println(set.size());
    }
}
