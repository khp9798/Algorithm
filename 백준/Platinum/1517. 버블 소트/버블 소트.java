import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] array, tempArray;
    static long swapCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        array = new long[N];
        tempArray = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        mergeSort(0, N - 1);
        System.out.println(swapCount);
    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        
        for (int l = left; l <= right; l++) {
            tempArray[l] = array[l];
        }

        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k++] = tempArray[i++];
            } else {
                array[k++] = tempArray[j++];
                swapCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            array[k++] = tempArray[i++];
        }

        while (j <= right) {
            array[k++] = tempArray[j++];
        }
    }
}
