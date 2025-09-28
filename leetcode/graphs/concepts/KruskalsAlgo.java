package dsa.leetcode.graphs.concepts;


import java.util.Arrays;
import java.util.List;

/*
* Used to find minimum spanning tree
* A Spanning tree is a tree of graph with all vertices and all edges connected
* A Minimum spanning tree is the spanning tree with least of sum all weights
* How to find MST :-
* Sort all edges as per weights
* Then start connecting edges.
* If and if there is a cycle formed while adding any edges, don't add that edge
*
* Use union find to detect edges
* Time complexity = O(E log V)
* Space Complexity = O(E+V)
* */
public class KruskalsAlgo {

    public static int N = Integer.MAX_VALUE;

    // src, dest, weight
    int[][] edges = new int[100][3];

    public void make (int[]parent, int v){
        parent[v] = v;
    }
    public void makeOptimise2 (int[]parent, int[]size, int v){
        // O(1) approach
        parent[v] = v;
        size[v] = 1;
    }

    public int findSetOptimise1(int[]parent, int v){
        // Log(n) approach
        if(v == parent[v]){
            return v;
        }
        return parent[v]=findSetOptimise1(parent, parent[v]);
    }

    public void unionSetsOptimise2(int a, int b, int[] parent, int[] size){
        a = findSetOptimise1(parent, a);
        b = findSetOptimise1(parent, b);
        if(a != b){
            if(size[a] < size[b]){
                int c = a;
                a = b;
                b = a;
            }
            parent[b] = a;
            size[a] += size[b];
        }
        }


    public void KruskalsAlgo( int vertices, int []parent, int [][] edges){
        for(int i = 0; i < vertices; i++){
            make(parent, N);
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int cost = 0;

        for(int i = 0; i < edges.length; i++){
            int w = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            int x = findSetOptimise1(parent, u);
            int y = findSetOptimise1(parent,v);

            if(x == y){
                continue;
            }else{
                cost += w;
                unionSetsOptimise2(u,v, parent, new int [parent.length]);
            }
        }

    }
}
