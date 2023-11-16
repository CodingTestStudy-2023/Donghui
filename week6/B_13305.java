import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//그리디 알고리즘
//현재까지의 최소 비용을 유지하면서 각 거리에 대해 연료 비용을 계산
public class B_13305 {
    public static void main(String[] args) {
        int n = 4;
        int[] distance = {2,3,1};
        int[] money = {5,2,4,1};
        long sum = 0;
        int currentMin = money[0];
        for(int i=0; i<n-1; i++) {
            if(money[i]<currentMin) {
                currentMin = money[i];
            }
            sum += (long)currentMin * distance[i];
        }
        System.out.println(sum);
        //돈 0번째 인덱스가 최소값이라면 모든 거리의 수를 더한 후 곱한다.
        //돈 0번째 인덱스가 최소값이 아니라면 거리 0번째 인덱스와 곱하고 다음으로 넘어간다.
        //돈 1번째 인덱스가 0번째 인덱스를 제외하고 최소값이라면 나머지 거리를 더한 후 곱한다.
        //아니라면 거리 1번째 인덱스를 곱한 후 다음으로 넘어간다.
        //거리 인덱스가 마지막이라면 돈 2번쨰 인덱스를 곱하고 끝낸다. 모든 곱들을 더한다.
        //첫번째 인덱스는 최소값과 비교해도 무난하게 결과값을 낼 수 있지만
        //두번째 부터는 다음 인덱스와 비교를 해야 함.
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            queue.add(money[i]);
//        }
//        int sum = 0;
//        int min = Arrays.stream(money).min().getAsInt();
//
//        if (money[0] == min) {
//            sum = money[0] * Arrays.stream(distance).sum();
//        } else {
//            for (int i = 0; i < n - 1; i++) {
//                if (!queue.isEmpty()) {
//                    int currentMoney = queue.poll(); // 현재 돈 값을 가져옴
//                    sum += currentMoney * distance[i];
//
//                    if (!queue.isEmpty() && queue.peek() < currentMoney) {
//                        // 큐의 다음 값이 현재 값보다 작다면 나머지 거리의 합을 계산
//                        sum += queue.peek() * Arrays.stream(distance, i + 1, distance.length).sum();
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println("총 합계: " + sum);

    }
}