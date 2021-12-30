class Solution {
public:
    /**
     * @param height: n people's height
     * @return: return the maxium number of people in square matrix
     */
    int MaxPeopleNumber(vector<int> &height) {
        // write your code here
        sort(height.begin(),height.end());
        int start=1;
        int end=int(height.size());
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(can_form_square(height,mid)){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(can_form_square(height,end)){
            return end*end;
        }
        else{
            return start*start;
        }
    }
    bool can_form_square(vector<int>&height,int colsize){
        int start=0;
        int end=start+colsize-1;
        int rowsize=0;
        while(end<height.size()){
            if(height[end]-height[start]>2){
               start++;
                end++;
            }
            else{
                rowsize++;
                if(rowsize==colsize){
                    return true;
                }
                start=end+1;
                end=start+colsize-1;
            }
        }
        return false;
    }
};