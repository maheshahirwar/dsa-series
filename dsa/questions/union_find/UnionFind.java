class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int n){

        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++)
            parent[i] = i;
    }

    int find(int x){

        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    void union(int x,int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)
            return;

        if(rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if(rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
