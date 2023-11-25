import java.sql.SQLOutput;
import java.util.*;

public class B_1822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }
        SortedSet<Integer> set = new TreeSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set2.add(arr2[i]);
        }

        set.removeIf(set2::contains);

        System.out.println(set.size());

        if(set.size() > 0) {
            String[] str = new String[set.size()];
            int index = 0;
            for (Iterator<Integer> it = set.iterator(); it.hasNext(); index++) {
                int e = it.next();
                str[index] = String.valueOf(e);
            }
            System.out.println(String.join(" ", str));
        }

    }
}
