//hash table version, o(N)
class Solution {
public:
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &numbers, int target) {
        // write your code here
        map<int, vector<int> > positions; //records the positions of each number
        for (int i=0;i<numbers.size();i++)
        {
            if(positions.count(numbers[i])>0)
            {
                positions[numbers[i]].push_back(i);
            }
            else
            {
                vector<int> temp;
                temp.push_back(i);
                positions[numbers[i]] = temp;
            }
        }
        for (int i=0;i<numbers.size();i++)
        {
            int compliment = target - numbers[i];
            if(positions.count(compliment)>0)
            {
                if (positions[compliment][0]!=i)
                {
                    //return
                    vector<int> result{i, positions[compliment][0]};
                    sort(result.begin(), result.end());
                    return result;
                }
            }
        }


    }
};