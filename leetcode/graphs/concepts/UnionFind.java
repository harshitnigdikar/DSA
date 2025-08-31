package dsa.leetcode.graphs.concepts;

/*
* Algorithm for merging 2 different sets recognised by its leader
* For merging -> make parent[a] = parent[b]
* while starting the algo, all elements are parents of itself
*
*  */

public class UnionFind {
    public void make (int[]parent, int v){
        parent[v] = v;
    }
    public void makeOptimise2 (int[]parent, int[]size, int v){
        // O(1) approach
        parent[v] = v;
        size[v] = 1;
    }

    public int findSet(int[]parent, int v){
        // O(n) approach
        if(v == parent[v]){
            return v;
        }
        return findSet(parent, parent[v]);
    }

    public int findSetOptimise1(int[]parent, int v){
        // Log(n) approach
        if(v == parent[v]){
            return v;
        }
        return parent[v]=findSetOptimise1(parent, parent[v]);
    }

    public void unionSets(int a, int b, int[] parent){
        a = findSet(parent, a);
        b = findSet(parent, b);
        if(a != b){
            parent[b] = a;
        }
    }

    public void unionSetsOptimise2(int a, int b, int[] parent, int[] size){
        a = findSet(parent, a);
        b = findSet(parent, b);
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
}
