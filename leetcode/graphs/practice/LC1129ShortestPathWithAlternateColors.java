package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int color;
    int dist;

    Pair(int node, int color, int dist) {
        this.node = node;
        this.color = color;
        this.dist = dist;

    }
}
public class LC1129ShortestPathWithAlternateColors {
    public ArrayList<ArrayList<Integer>> createList(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);

        }
        return adjList;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Integer>> redAdjList = createList(redEdges,n);
        ArrayList<ArrayList<Integer>> blueAdjList = createList(blueEdges,n);

        Queue<Pair> queue = new LinkedList<>();
        boolean visR[] = new boolean[n];
        boolean visB[] = new boolean[n];
        int ans[] = new int[n];
        Arrays.fill(ans,-1); // Initializing with -1 assuming till now no node is rechable
        queue.add(new Pair(0,0,0)); // Add 0 as red edge
        queue.add(new Pair(0,1,0)); // Add 0 as blue edge
        visR[0]=visB[0]=true; // Marking it as visited

        int dist = 0;
        while(!queue.isEmpty()){

            int size = queue.size(); // Calculate size to traverse the list

            for(int i =0;i<size;i++){
                Pair p = queue.poll();
                int node = p.node;
                dist = p.dist;

                if(ans[node]==-1 || ans[node] > dist){ // Update the minimul value
                    ans[node] = dist;
                }
                int color = p.color;
                if(color==1){ // if blue then checking in redList
                    for(int neigh : redAdjList.get(node)){
                        if(!visR[neigh]){
                            visR[neigh] = true;
                            queue.add(new Pair(neigh,0,dist+1));

                        }
                    }
                }else if(color == 0){ // if red then checking in blueList
                    for(int neigh : blueAdjList.get(node)){
                        if(!visB[neigh]){
                            visB[neigh] = true;
                            queue.add(new Pair(neigh,1,dist+1));

                        }
                    }
                }
            }

            dist++;
        }
        return ans;
    }
}
