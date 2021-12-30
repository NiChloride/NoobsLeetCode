#include <vector>
#include <cstdio>
#include <set>
#include <algorithm>
using namespace std;


class Solution {
public:
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    vector<vector<int> > threeSum(vector<int> &numbers) {
        // write your code here
        set<vector<int> > solutions;
        sort(numbers.begin(),numbers.end());//nlogn, the list is now ordered
        //3 pointers. first pointer fixes a position, second pointer and third pointer start from next position and end respectively
        int n = numbers.size();
        for(int first = 0;first < n;first++)
        {
            
            //if the combination is greater than 0, third pointer should decrement
            //if the combination is smaller than 0, second pointer should increment
            //when second and third pointer meet, stop
            for(int second=first+1, third=n-1; second<third;)
            {
                int sum = numbers[first] + numbers[second] + numbers[third];
                printf("%d",sum);
                
                if(sum<0)
                {
                    second++;
                }
                else if(sum>0)
                {
                    third--;
                }
                else
                {
                    solutions.insert({numbers[first], numbers[second], numbers[third]});
                    second++;
                    third--;
                }
            }
        }
        return vector<vector<int> >{solutions.begin(), solutions.end()};


    }
};