import java.io.*;
import java.util.*;

public class SlidingWindowMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        String[] second = br.readLine().split(" ");
        long x = Long.parseLong(second[0]);
        long a = Long.parseLong(second[1]);
        long b = Long.parseLong(second[2]);
        long c = Long.parseLong(second[3]);

        Deque<long[]> dq = new ArrayDeque<>();
        long xor = 0;

        long current = x;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst()[0] <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && dq.peekLast()[1] >= current) {
                dq.pollLast();
            }
            dq.offerLast(new long[]{i, current});
            if (i >= k - 1) {
                xor ^= dq.peekFirst()[1];
            }
            if (i < n - 1) {
                current = (a * current + b) % c;
            }
        }

        System.out.println(xor);
    }
}
