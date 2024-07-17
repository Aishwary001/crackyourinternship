// https://leetcode.com/u/aishwarylifeline/ 
class Solution {
    public static int n;
    public static int m;
    public static int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean find(char board[][], int i, int j, int idx, String word) {

    // isse pata chalta hai hamne word ki puri length mil gaye hai
    if (idx == word.length()) {
        return true;
    }

    // isss pata chalega ki ham kahan or kis position me traverse kar rahe hai kahi aage to nahi hai ya uske equal nahi hai 
    if (i < 0 || j < 0 || i >= n || j >= m || board[i][j] == '$' || board[i][j] != word.charAt(idx)) {
        return false;
    }

    // isse hame pata chalega ki kya ham jis index ko dej=kha vh idx us char ke equal ho gaya hai agar hoga hai to us pr dollar marke kar denge jiss hame pata chalega ki ham iss or aa gaye hai ek bar
    char temp = board[i][j];
    board[i][j] = '$';

    // is bale se direction provide karbaye ge
    for (int dir[] : direction) {
        int new_i = i + dir[0];
        int new_j = j + dir[1];
        if (find(board, new_i, new_j, idx + 1, word)) {
            return true;
        }
    }

    board[i][j] = temp;
    return false;
}
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
