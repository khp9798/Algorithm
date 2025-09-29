class Solution {
    public int solution(int[] wallet, int[] bill) {
        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);

        int bMin = Math.min(bill[0], bill[1]);
        int bMax = Math.max(bill[0], bill[1]);

        int cnt = 0;
        while (bMin > wMin || bMax > wMax) {
            // 항상 더 긴 쪽을 접는다
            bMax /= 2;
            cnt++;

            // 다시 (min, max) 정렬
            if (bMin > bMax) {
                int tmp = bMin;
                bMin = bMax;
                bMax = tmp;
            }
        }
        return cnt;
    }
}
