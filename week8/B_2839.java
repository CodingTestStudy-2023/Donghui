import java.util.Scanner;

public class B_2839 {
    public static void main(String[] args) {
//        int n = 11;
//        int kg5 = 5;
//        int kg3 = 3;
//        int sum = 0;
//        int temp = 0;
//
//        if(n % kg5 == 0) {
//            sum = n / kg5;
//        } else {
//            sum = n / kg5;
//            temp = n % kg5;
//            sum += temp / kg3;
//            if(temp % kg3 == 0) {
//                System.out.println(sum);
//            } else {
//                if(n % kg3 == 0) {
//                    sum = n / kg3;
//                    System.out.println(sum);
//                } else {
//
//                    if((temp + kg5) % kg3 == 0 && n > kg5) {
//                        sum += (temp + kg5/kg3) - 1;
//                        System.out.println(sum);
//                    } else {
//                        System.out.println(-1);
//                    }
//
//                }
//            }
//        }
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int bags = 0;

        while(N > 0) {
            if(N % 5 == 0) {
                bags += N / 5;
                N = 0;
                break;
            } else {
                N -= 3;
                bags++;
            }
        }
        if(N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(bags);
        }
        sc.close();
    }
}
