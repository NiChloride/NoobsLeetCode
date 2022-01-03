#include<iostream>
#include<vector>
#include<queue>
using namespace std;

class Point
{
    public:
    int x;
    int y;
    Point (int a, int b)
    {
        x = a;
        y = b;
    }

    bool operator==(const Point &p)
    {
        return ((this->x)==(p.x))&&((this->y)==(p.y)); //"this" is a self pointer, thus use the -> operator to access its member
    }

    bool legal()
    {
        return (x>=0)&&(y>=0);
    }
};




class Solution {
public:
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    int numIslands(vector<vector<bool> > &grid) {
        // write your code here
        if(grid.size() == 0)
        {
            return 0;
        }
        if (grid[0].size()==0)
        {
            return 0;
        }
        int num_rows = grid.size();
        int num_cols = grid[0].size();
        bool visited[num_rows][num_cols];
        int result = 0;

        

        for(int i=0; i<num_rows; i++)
        {
            for(int j=0;j<num_cols;j++)
            {
                if (grid[i][j]==1)
                {
                    result++;
                    queue<Point> exploring;
                    exploring.push(Point(i,j));
                    grid[i][j] = 0; //set visited point to 0 to avoid repetition
                    while(!exploring.empty())
                    {
                        int x = exploring.front().x;
                        int y = exploring.front().y;
                        exploring.pop();

                        vector<Point> adjacent;
                        for(int k=x-1;k<x+2;k++)
                        {
                            for(int h=y-1;h<y+2;h++)
                            {
                                
                            }
                        }
                        

                    }

                }
            }
        }
      
//bfs伪代码
// function bfs(x,y) //从x,y点出发开始搜索
//     queue.push(x,y) //将当前点推入队列
//     map[x][y] = 0 //走过的点赋值为0
//     while(!queue.empty())//当队列为空则结束循环
//         (now_x,now_y) = queue.front()
//         queue.pop() //将队头元素取出
//         for i 1:4 //遍历四个方向
//             next_x = now_x + dir[i][0] //得到下一个位置坐标
//             next_y = now_y + dir[i][1]
//             if(0<=next_x<n && 0<=next_y<m && map[next_x][next_y]==1)
//             //合法性判断
//                 map[next_x][next_y] = 0  //走过的点赋值为0，以便不会再次遍历
//                 queue.push(next_x,next_y) //将该点推入队列
       


    }

};