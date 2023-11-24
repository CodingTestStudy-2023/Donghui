import java.lang.reflect.Array;
import java.util.*;

public class B_12015 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {10,20,10,30,20,50};

        List<Integer> dp = new ArrayList<>();
        for(int num : arr) {
            System.out.println(num);
            if(dp.isEmpty() || num > dp.get(dp.size() - 1)) {
                dp.add(num);
                System.out.println(dp);
            } else {
                int i = Collections.binarySearch(dp, num);
                //이진탐색을 통하여 리스트에 특정 요소의 위치를 찾는다.
                if(i < 0) {
                    i = Math.abs(i + 1);
                }
                dp.set(i, num);
                //index, element
            }
        }
        System.out.println(dp.size());
    }
}