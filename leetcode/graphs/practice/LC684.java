package dsa.leetcode.graphs.practice;

// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
//Output: [1,4]

//[[1,2],[1,3],[2,3]]
public class LC684 {

    public int find(int x, int[] parentArr){
        if(x == parentArr[x]){
            return x;
        }
        return parentArr[x] = find(parentArr[x], parentArr);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parentArr = new int[edges.length+1];
        int [] ans = new int[2];

        for (int i = 1; i <= edges.length; i++) {
            parentArr[i] = i;
        }
        //[[1,2],[1,3],[2,3]]
        for(int i = 1; i <= edges.length; i++){
            int a = edges[i-1][0];
            int b = edges[i-1][1];

            int parentOfA = find(a, parentArr);
            int parentOfB = find(b, parentArr);

            if(parentOfA == parentOfB){
                ans[0] = a;
                ans[1] = b;
            }else{
                parentArr[parentOfB] = parentOfA;
            }
        }
        return ans;
    }
}
