package dsa.leetcode.graphs.concepts;

/*
* 1. Sort all vertices of graph such that if 1 -> 2, i.e. if 2 is dependent on 1 then 1 must always be above 2 in the sort
* 2. Uses dfs
* 3. Only applicable on Directed Acyclic Graphs
* Algo ->
* 1.DFS se traverse kro and aur wapas aate time elements ko stack me daaldo
* Ye aagya bhai tumahra topological sort
* */

import java.util.ArrayList;
import java.util.Stack;

class TopoEdge{
    int src;
    int dest;
    int wt;

    public TopoEdge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}

public class TopologicalSort {

    public void TopologicalSOrt(ArrayList<TopoEdge>[]graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfs(i, graph, visited, st);
            }
        }
        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    public void dfs(int vertex, ArrayList<TopoEdge>[]graph, boolean[] visited, Stack<Integer>st){

        visited[vertex] = true;

        for(int i = 0; i < graph[vertex].size(); i++){
            if(!visited[graph[vertex].get(i).dest]){
                dfs(i, graph, visited, st);
            }
        }
        st.push(vertex);
    }
}
