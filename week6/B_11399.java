import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class B_11399 {
    public static void main(String[] args) {
        int[] arr = {3,1,4,3,2};
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);

        int result = 0;
        int answer = 0;

        for(int i=0; i<list.size(); i++) {
            result += list.get(i);
            answer += result;
        }
        System.out.println(answer);
    }
}
