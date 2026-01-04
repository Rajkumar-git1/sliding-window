import java.util.LinkedList;
import java.util.Queue;

public class First_neg {
    public long [] printNeg(long A[], int N, int K) {
        Queue<Long> queue = new LinkedList<>();
        
        // process first window
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                queue.offer(A[i]);
            }
        }
        
        long res[] = new long[N - K + 1];
        res[0] = (queue.isEmpty()) ? 0 : queue.peek();
        
        // process the remaining windows
        for (int i = K; i < N; i++) {
            // remove the element going out of the window
            if (A[i - K] < 0) {
                queue.poll();
            }
            
            // add the new element entering the window
            if (A[i] < 0) {
                queue.offer(A[i]);
            }
            
            // store the first negative number of the current window
            res[i - K + 1] = (queue.isEmpty()) ? 0 : queue.peek();
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        First_neg fn = new First_neg();
        long arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int N = arr.length;
        int K = 3;
        
        long ans[] = fn.printNeg(arr, N, K);
        
        for (long x : ans) {
            System.out.print(x + " ");
        }
    }
}
