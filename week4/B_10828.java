import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_10828 {
    public static void main(String[] args) {

        int[][] arr = {
//                {3,1},
//                {2,3},
//                {3,1},
//                {3,2}
                {1,2},
                {3,1}
        };
        int[] bo = {1,2,3};

        for(int i=0; i<arr.length; i++) {
            int index1 = arr[i][0]-1;
            int index2 = arr[i][1]-1;

            int temp = bo[index1];
            bo[index1] = bo[index2];
            bo[index2] = temp;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<bo.length; i++) {
            list.add(bo[i]);
        }
        int result = list.indexOf(1) + 1;
        System.out.println(result);
    }
}
