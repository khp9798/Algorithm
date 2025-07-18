import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Integer[] arr = new Integer[n];

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // 최빈값 용 map
            Map<Integer, Integer> map = new HashMap<>();

            double sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];

                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

                max = Math.max(arr[i], max);
                min = Math.min(arr[i], min);
            }

            Arrays.sort(arr);

            int maxCount = Integer.MIN_VALUE;
            for (Integer num : arr) {
                maxCount = Math.max(maxCount, map.get(num));
            }

            // 최빈값 용 set
            Set<Integer> set = new HashSet<>();

            for (Integer num : arr) {
                if (maxCount == map.get(num)) {
                    set.add(num);
                }
            }

            List<Integer> maxNums = new ArrayList<>(set);

            Collections.sort(maxNums);

            System.out.println(Math.round(sum / n));
            System.out.println(arr[n / 2]);
            System.out.println(maxNums.size() > 1? maxNums.get(1) : maxNums.get(0));
            System.out.println(max - min);
        }
    }
}