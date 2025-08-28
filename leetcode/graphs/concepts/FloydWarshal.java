package dsa.leetcode.graphs.concepts;

/*
* used to fnd all pair shortest path
* try using all the edges if distances b/w 2 nodes could be shortened
* n cube time complexity
* */
public class FloydWarshal {

    public static void floydWarshal(int[][] graph){

        int[][] dist = new int[graph.length][graph.length];

        int n = graph.length;
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // now this shortest distance b/w any two nodes is dist[x][y] where x & y are the nodes.
    }
}
