import java.util.*;

public class Max{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        long x = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();

        long[] window = new long[k];
        long sum = 0, result = 0;

        // first k elements
        for (int i = 0; i < k; i++) {
            window[i] = x;
            sum += x;
            x = (a * x + b) % c;
        }
        result ^= sum;

        // sliding window
        for (int i = k; i < n; i++) {
            int idx = i % k;
            sum += x - window[idx];
            window[idx] = x;
            result ^= sum;
            x = (a * x + b) % c;
        }

        System.out.println(result);
    }
}
