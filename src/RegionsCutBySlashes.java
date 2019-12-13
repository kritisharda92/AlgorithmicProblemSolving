public class RegionsCutBySlashes {

    int find(int[] p, int v) {
        if (p[v] == v) return v;
        return find(p, p[v]);
    }

    boolean union(int[] p, int[] rank, int v1, int v2) {
        int p1 = find(p, v1);
        int p2 = find(p, v2);
        if (p1 != p2) {
            if (rank[p1] < rank[p2]) p[p1] = p2;
            else p[p2] = p1;
            if (rank[p1] == rank[p2])
                rank[p2]++;
            return true;
        }
        return false;
    }

    public int regionsBySlashes(String[] grid) {
        int row = grid.length + 1;
        int col = grid[0].length() + 1;
        int[] p = new int[row*col];
        int[] rank = new int[row*col];
        int pLen = p.length;

        for (int i = 0; i < pLen; i++) p[i] = i;

        for (int i = 0; i < col; i++)
            union(p, rank, 0, i);
        for (int i = pLen - 1; i >= pLen - grid[0].length() - 1; i--)
            union(p, rank, 0, i);
        for (int i = 0; i < row; i++)
            union(p, rank, 0, i * col);
        for (int i = 0; i < col; i++)
            union(p, rank, 0, i * col + col - 1);
        for (int i = 0; i < rank.length; i++) find(p, i);

        int regions = 1;
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < col-1; j++) {
                int v1 = i * col + j;
                int v2 = (i+1) * col + j;
                if (grid[i].charAt(j) == '/' && !union(p, rank, v1+1, v2)
                        || grid[i].charAt(j) == '\\' && !union(p, rank, v1, v2 + 1)) {
                    regions++;
                }
            }
        }
        return regions;
    }

    public static void main(String args[]) {
        RegionsCutBySlashes obj = new RegionsCutBySlashes();
        String[] grid1 = {" /","/ "};
        System.out.println(obj.regionsBySlashes(grid1));
    }
}
