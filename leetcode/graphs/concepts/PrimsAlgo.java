package dsa.leetcode.graphs.concepts;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* Use to find Minimum Spanning Tree
* Greedy Approach
* Algo:-
* 1. Add src in priority queue
* 2. remove, mark star, work, add star
*  */

class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

class PrimsPair implements Comparator {
    int vertex;
    int aquiringVertex;
    int weight;

    public PrimsPair(int vertex, int aquiringVertex, int weight) {
        this.vertex = vertex;
        this.aquiringVertex = aquiringVertex;
        this.weight = weight;
    }

    public int compare(PrimsPair o1, PrimsPair o2) {
        return o1.weight-o2.weight;
    }
}
public class PrimsAlgo {


    public void primsAlgo(){
        ArrayList<Edge>[] graph = new ArrayList[10];
        PriorityQueue<PrimsPair>pq = new PriorityQueue<>();
        boolean[] visited = new boolean[10];
        pq.add(new PrimsPair(0, -1, 0));

        while (!pq.isEmpty()){
            PrimsPair rem = pq.remove();
            if(visited[rem.vertex]){
                continue;
            }
            visited[rem.vertex] = true;

            if(rem.aquiringVertex != -1){
                System.out.println(rem.vertex + "-" + rem.aquiringVertex + "-" + rem.weight);
            }

            for(Edge e : graph[rem.vertex]){
                if(!visited[e.dest]){
                    pq.add(new PrimsPair(e.dest, rem.vertex, e.wt));
                }
            }
        }
    }
}
