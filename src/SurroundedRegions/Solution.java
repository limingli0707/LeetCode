package SurroundedRegions;
/*
 * First scan the four borders of the board, replace all 'O's that are connected to the 'O's at the border with a temporary character (e.g., '#').

Then scan through the entire board, if an 'O' is found, then it must be an interior element, so we change it to 'X', else if a '#' is found, then it should have been the 'O' character before, so we just restore it to 'O'.

Both DFS and BFS can be used to visit connected elements. 
 */
class Solution {
public:
    void solve(vector<vector<char>>& board) {
        if (board.empty()) return;
        int n = board.size();
        int m = board[0].size();
        // Top-most line
        for (int j = 0; j < m; ++j)
            if (board[0][j] == 'O')
                DFS(board, 0, j);
        // Right-most column
        for (int i = 1; i < n; ++i)
            if (board[i][m-1] == 'O')
                DFS(board, i, m - 1);
        // Bottom-most line
        for (int j = 0; j < m - 1; ++j)
            if (board[n-1][j] == 'O')
                DFS(board, n - 1, j);
        // Left-most column
        for (int i = 1; i < n - 1; ++i)
            if (board[i][0] == 'O')
                DFS(board, i, 0);
        // Change interior 'O's to 'X's meanwhile restoring '#'s to 'O's
        for (auto& vec: board)
            for (char& c : vec)
                if (c == 'O')
                    c = 'X';
                else if (c == '#')
                    c = 'O';
    }

    void DFS(vector<vector<char>>& board, int i, int j) {
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i-1][j] == 'O')
            DFS(board, i - 1, j);
        if (j + 1 < board[0].size() && board[i][j+1] == 'O')
            DFS(board, i, j + 1);
        if (i + 1 < board.size() && board[i+1][j] == 'O')
            DFS(board, i + 1, j);
        if (j - 1 >= 0 && board[i][j-1] == 'O')
            DFS(board, i, j - 1);
    }

    void BFS(vector<vector<char>>& board, int row, int col) {
        board[row][col] = '#';
        queue<pair<int, int>> Q;
        Q.push(make_pair(row, col));
        while (!Q.empty()) {
            int i = Q.front().first;
            int j = Q.front().second;
            Q.pop();
            if (i - 1 >= 0 && board[i-1][j] == 'O') {
                board[i-1][j] = '#';
                Q.push(make_pair(i - 1, j));
            }
            if (j + 1 < board[0].size() && board[i][j+1] == 'O') {
                board[i][j+1] = '#';
                Q.push(make_pair(i, j + 1));
            }
            if (i + 1 < board.size() && board[i+1][j] == 'O') {
                board[i+1][j] = '#';
                Q.push(make_pair(i + 1, j));
            }
            if (j - 1 >= 0 && board[i][j-1] == 'O') {
                board[i][j-1] = '#';
                Q.push(make_pair(i, j - 1));
            }
        }
    }
};