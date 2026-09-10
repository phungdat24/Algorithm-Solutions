class Solution {
    class UnionFind{
        private int[] id;
        private int[] sz;
        private int count;

        public UnionFind(int N){
            id = new int[N];
            sz = new int[N];
            this.count = N;
            for(int i = 0; i < N; i++){
                id[i] = i;
                sz[i] =1;
            }
        }
        public int find(int d){
            while( d != id[d]){
                id[d] = id[id[d]];
                d = id[d];
            }
            return d;
        }
        public void union(int p, int q){
            int root_p = find(p);
            int root_q = find(q);
            if(root_p == root_q) return;
            if(sz[root_p] < sz[root_q]){
                sz[root_q] += sz[root_p];
                id[root_p] = id[root_q];
            }
            else{
                sz[root_p] += sz[root_q];
                id[root_q] = id[root_p]; 
            }
            count--;
        }
        public int getCount(){
            return count;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) { 
                if (isConnected[i][j] == 1) {
                    uf.union(i, j); 
                }
            }
        }

        return uf.getCount(); 
    }
}