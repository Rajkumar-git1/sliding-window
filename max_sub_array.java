import java.util.ArrayList;

public class max_sub_array {  
    static long sub(int k, ArrayList<Integer> Arr, int N) {
        if (k > N) return 0; // edge case

        long sum = 0, maxSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += Arr.get(i);
        }
        maxSum = sum;

        // Slide the window
        for (int i = k; i < N; i++) {
            sum = sum - Arr.get(i - k) + Arr.get(i);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(1);
        arr.add(3);
        arr.add(2);

        System.out.println(sub(3, arr, arr.size())); 
    
    }
}
