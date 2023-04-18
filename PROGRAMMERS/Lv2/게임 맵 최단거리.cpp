#include<vector>
#include<bits/stdc++.h>
using namespace std;

int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int visited[101][101] = {0,};
int bfs[101][101] = {0,};

int solution(vector<vector<int>> maps){
    int answer = 0;
    
    queue<pair<int, int>> q;
    q.push(make_pair(0, 0));
    visited[0][0] = 1;

    int n = maps.size();
    int m = maps[0].size();

    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            
            if(maps[ny][nx] == 1 && visited[ny][nx] == 0){
                visited[ny][nx] = 1;
                q.push(make_pair(ny, nx));
                bfs[ny][nx] = bfs[y][x] + 1;
            }
        }
    }
    
    
    
    if(bfs[n-1][m-1] == 0) answer = -1;
    else answer = bfs[n-1][m-1] + 1;
   
    return answer;
}