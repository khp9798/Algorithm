import java.util.*;

public class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        // 1) 그래프 초기화
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int u : nodes) {
            graph.put(u, new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            // 양방향 무향 그래프로 저장
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 2) 방문 체크용 집합
        Set<Integer> visited = new HashSet<>();
        int oddEvenCount = 0;       // 홀짝 트리 개수
        int reverseOddEvenCount = 0; // 역홀짝 트리 개수

        // 3) 모든 노드를 순회하며, 미방문인 노드로부터 BFS/DFS로 연결 요소(트리) 탐색
        for (int start : nodes) {
            if (visited.contains(start)) continue;

            // BFS를 통해 하나의 트리에 속한 노드 목록을 모은다
            List<Integer> component = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                component.add(cur);
                for (int nxt : graph.get(cur)) {
                    if (!visited.contains(nxt)) {
                        visited.add(nxt);
                        queue.offer(nxt);
                    }
                }
            }

            // 4) 이 컴포넌트(트리) 내부에서 base 상태(루트가 아닌 상태)로 노드별 분류 수행
            int normalBaseCount = 0;
            int reverseBaseCount = 0;
            for (int u : component) {
                int degree = graph.get(u).size();            // 이 노드가 연결된 전체 간선 수
                int baseChildCount = degree - 1;              // 루트가 아닌 상태라면 "자식 개수"
                int baseChildParity = ((baseChildCount % 2) + 2) % 2; // 음수 방지 후 0/1
                int idParity = u % 2;                         // 노드 번호가 홀수면 1, 짝수면 0

                // base 상태에서 정방향(홀짝)인지 비교
                if (idParity == baseChildParity) {
                    normalBaseCount++;
                } else {
                    reverseBaseCount++;
                }
            }

            int size = component.size();
            // 5) reverseBaseCount == 1 → 홀짝 트리 가능
            if (reverseBaseCount == 1) {
                oddEvenCount++;
            }
            // 6) normalBaseCount == 1 → 역홀짝 트리 가능
            if (normalBaseCount == 1) {
                reverseOddEvenCount++;
            }
        }

        return new int[]{oddEvenCount, reverseOddEvenCount};
    }
}
