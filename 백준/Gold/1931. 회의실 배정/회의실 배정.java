import java.io.*;
import java.util.*;

class Main {

    static class Meeting implements Comparable<Meeting> {
        int st, et;

        Meeting(int st, int et) {
            this.st = st;
            this.et = et;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.et != o.et)
                return this.et - o.et;
            return this.st - o.st;
        }

        @Override
        public String toString() {
            return "(" + this.st + ", " + this.et + ")";
        }
    }

    public static void main(String[] args) throws IOException {
        // 코드 작성
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Meeting> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                String[] info = br.readLine().split(" ");

                int start = Integer.parseInt(info[0]);
                int end = Integer.parseInt(info[1]);

                pq.offer(new Meeting(start, end));
            }

            int count = 1;
            int endtime = pq.poll().et;
            while (!pq.isEmpty()) {
                Meeting cur = pq.poll();

                if (cur.st < endtime)
                    continue;

                count++;
                endtime = cur.et;
            }

            System.out.println(count);
        }
    }
}