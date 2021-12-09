
import java.util.*;


public class Week13 {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;


    static int count_connected(int row, int col) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(row);
        q.add(col);
        visited[row][col] = true;
        cnt++;
        while (true) {
            if (row + 1 < grid.length) {
                if (grid[row + 1][col] == 1 && !visited[row + 1][col]) {
                    cnt++;
                    q.add(row + 1);
                    q.add(col);
                }
                visited[row + 1][col] = true;
            }

            if (row > 0) {
                if (grid[row - 1][col] == 1 && !visited[row - 1][col]) {
                    cnt++;
                    q.add(row - 1);
                    q.add(col);
                }
                visited[row - 1][col] = true;
            }

            if (col + 1 < grid[0].length) {
                if (grid[row][col + 1] == 1 && !visited[row][col + 1]) {
                    cnt++;
                    q.add(row);
                    q.add(col + 1);
                }
                visited[row][col + 1] = true;
            }

            if (col > 0) {
                if (grid[row][col - 1] == 1 && !visited[row][col - 1]) {
                    cnt++;
                    q.add(row);
                    q.add(col - 1);
                }
                visited[row][col - 1] = true;
            }

            if (col + 1 < grid[0].length && row + 1 < grid.length) {
                if (grid[row + 1][col + 1] == 1 && !visited[row + 1][col]) {
                    cnt++;
                    q.add(row + 1);
                    q.add(col + 1);
                }
                visited[row + 1][col + 1] = true;
            }

            if (col > 0 && row + 1 < grid.length) {
                if (grid[row + 1][col - 1] == 1 && !visited[row + 1][col - 1]) {
                    cnt++;
                    q.add(row + 1);
                    q.add(col - 1);
                }
                visited[row + 1][col - 1] = true;
            }

            if (col + 1 < grid[0].length && row > 0) {
                if (grid[row - 1][col + 1] == 1 && !visited[row - 1][col + 1]) {
                    cnt++;
                    q.add(row - 1);
                    q.add(col + 1);
                }
                visited[row - 1][col + 1] = true;
            }

            if (col > 0 && row - 1 > 0) {
                if (grid[row - 1][col - 1] == 1 && !visited[row - 1][col - 1]) {
                    cnt++;
                    q.add(row - 1);
                    q.add(col - 1);
                }
                visited[row - 1][col - 1] = true;
            }

            if (!q.isEmpty()) {
                row = q.remove();
                col = q.remove();
            } else break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }

        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}