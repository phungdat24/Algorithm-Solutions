class Solution {
    class UnionFind{
        private int[] parent;
        private int[] sz;
        public UnionFind(int N){
            parent = new int[N];
            sz = new int[N];
            for(int i = 0; i < N; i ++){
                parent[i] = i;
                sz[i] = 1;
            }
        }
        public int find(int p){
            while( p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q){
            int root_p = find(p);
            int root_q = find(q);

            if(root_p == root_q) return;
            if(sz[root_p] < sz[root_q]){
                parent[root_p] = root_q;
                sz[root_q] += sz[root_p];
            }
            else{
               parent[root_q] = root_p;
                sz[root_p] += sz[root_q]; 
            }
        }
        public boolean connected(int p, int q){
            return find(p) == find(q);
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int cols = board[0].length;
        int rows = board.length;

        UnionFind uf = new UnionFind(cols * rows + 1);
        int virtualNode = cols * rows; 

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    int currentId = i * cols + j;
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(currentId, virtualNode);
                    } 
                    if (i > 0 && board[i - 1][j] == 'O') {
                        uf.union(currentId, (i - 1) * cols + j);
                    }
                    if (j > 0 && board[i][j - 1] == 'O') {
                        uf.union(currentId, i * cols + (j - 1));
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    int currentId = i * cols + j;
                    if (!uf.connected(currentId, virtualNode)) {
                        board[i][j] = 'X'; 
                    }
                }
            }
        }

    }
}