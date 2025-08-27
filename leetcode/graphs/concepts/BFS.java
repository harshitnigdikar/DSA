package dsa.leetcode.graphs.concepts;


import java.util.*;

class Pair{
    int val;
    String pathSoFar;

}
public class BFS {
    /*
    * Remove -> remove from the queue
    * Mark Star -> Mark this element as visited
    * Work -> Print or anything
    * Add Star -> Add its children into the queue
    * */
    public void bfs(Node node){

        Queue<Node>q = new ArrayDeque<>();
        q.add(node);

        int[] visited = new int[100];


        while(!q.isEmpty()){
            // 1. remove
            Node n = q.remove();

            if(visited[n.val] == 0){
                // 2. mark star
                visited[n.val] = 1;

                //3. work
                System.out.println(n.val);

                //4. Add
                for(Node t: n.neighbors){
                    if(visited[t.val] == 0){
                        q.add(t);
                    }
                }
            }
            System.out.println();
        }
    }
}
