package dsa.leetcode.graphs.concepts;

import java.util.ArrayList;
import java.util.Stack;

/*
* Algo to find the Strongly Connected Components (SCC)
* SCC is if you start from vertex '1' then you should be able to come on the vertex '1'
* Uses Topological Sort
* Algo:-
* 1. Sort the vertices in topological Order
* 2. Reverse all the edges of the graph
* 3. Do DFS again, and you'll get strongly connected components
* */
public class StronglyConnectedComponentsKosaraju {
    public void topologicalSort(int vertex, ArrayList<TopoEdge>[]graph, boolean[] visited, Stack<Integer>st){
        visited[vertex] = true;
        for(int i = 0; i < graph[vertex].size(); i++){
            if(!visited[graph[vertex].get(i).dest]){
                topologicalSort(i, graph, visited, st);
            }
        }
        st.push(vertex);
    }
    public void kosaraju(int v, ArrayList<TopoEdge>[]graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                topologicalSort(i, graph, visited, st);
            }
        }
        ArrayList<TopoEdge>[] reverseGraph = new ArrayList[10];

        for(int i = 0; i < reverseGraph.length; i++){
            visited[i] = false;
            for(TopoEdge it : reverseGraph[i]){
                reverseGraph[it.src].add(it);
            }
        }

        int scc = 0;
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(!visited[node]){
                scc++;
                //dfs(node, vis, reverseGraph);
            }
        }
        System.out.println(scc);
    }
}
