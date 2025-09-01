package dsa.leetcode.graphs.concepts;

/*
* Used to find Topological Sort Using BFS
* Algo->
* 1. Find the indegree of each vertex
* 2. Put 0 degree indregree in the queue
* 3. Now start remove,mark*, work, add*
* 4. Remove, add into the answer, then start removing the edges of neighbirs
* 5. If the neighbords indegree is 0 then just add in the queue.
* */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo {

    public int[] topoSort(int v, ArrayList<ArrayList<Integer>>adj){
        int indegree[] = new int[v];
        for(int i = 0; i < v; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int topo[] = new int[v];
        int i = 0;
        while (!q.isEmpty()){
            int node = q.remove();
            topo[i++] = node;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
