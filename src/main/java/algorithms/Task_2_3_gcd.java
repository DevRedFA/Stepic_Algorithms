package algorithms;

import java.util.Scanner;
// 13.2  complexity score
public class Task_2_3_gcd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(gcd(s.nextInt(), s.nextInt()));
    }

    private static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        return a >= b ? gcd(a % b, b) : gcd(a, b % a);
    }
}
// 8.77  complexity score
//import java.util.Scanner;
//class Main {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int m = in.nextInt();
//
//        while(n!=m) {
//            if(n>m) n=n-m;
//            else m=m-n;
//        }
//        System.out.println(n);
//    }
//}