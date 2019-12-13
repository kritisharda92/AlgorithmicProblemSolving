public class FriendCircles {

    public void findFriends(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                findFriends(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int totalStudents = M.length;
        boolean[] visited = new boolean[totalStudents];
        int circle = 0;
        for (int i = 0; i < totalStudents; i++) {
            if (!visited[i]) {
                circle++;
                findFriends(M, visited, i);
            }
        }
        return circle;
    }

    public static void main(String args[]) {
        FriendCircles obj = new FriendCircles();
        int[][] classMatrix1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] classMatrix2 = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(obj.findCircleNum(classMatrix1));
    }
}
