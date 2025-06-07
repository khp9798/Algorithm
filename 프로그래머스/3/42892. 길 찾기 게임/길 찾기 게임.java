import java.util.*;

class Solution {
    
    static List<Integer> preOrderList;
    static List<Integer> postOrderList;
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            nodes.add(new Node(x,y,i+1));
        }
        
        nodes.sort((o1,o2) -> {
            //루트노드를 알아야하기 때문에 y좌표값이 큰 순으로 정렬하고
            //같은 y좌표라면 왼쪽 노드 먼저
            if(o1.y == o2.y) return o1.x-o2.x;
            return o2.y - o1.y;
        });
        
        Node root = nodes.get(0);
        for(int i=1; i<nodes.size(); i++){
            insert(root,nodes.get(i));
        }
        
        
        preOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();
        preOrder(root);
        postOrder(root);
        
        
        for(int i=0; i<nodes.size(); i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }
        
        return answer;
    }
    
    
    //전위순회: 부모,왼,오
void preOrder(Node node){
    if(node == null) return;
    preOrderList.add(node.num);
    preOrder(node.left);
    preOrder(node.right);
}

//후위순회: 왼,오,부
void postOrder(Node node){
    if(node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    postOrderList.add(node.num);
}

void insert(Node parent, Node child){
    
    //왼쪽 자식 노드일 때
    if(child.x < parent.x){
        if(parent.left == null) parent.left = child;
        else insert(parent.left, child);
    }
    
    //오른쪽 자식 노드일 때
    else{
        if(parent.right == null) parent.right = child;
        else insert(parent.right, child);
    }
}

class Node {
    int x;
    int y;
    int num;
    
    Node left,right;
    
    Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
}

