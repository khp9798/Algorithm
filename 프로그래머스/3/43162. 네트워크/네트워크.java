public class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];  // 방문 여부를 체크하는 배열
        int networkCount = 0;  // 네트워크 개수

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 방문하지 않은 컴퓨터가 있으면
                dfs(i, computers, visited);  // DFS로 해당 컴퓨터와 연결된 네트워크 탐색
                networkCount++;  // 새로운 네트워크 발견 시 개수 증가
            }
        }

        return networkCount;
    }

    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;  // 현재 컴퓨터를 방문 처리

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);  // 연결된 컴퓨터에 대해 재귀적으로 탐색
            }
        }
    }
}
