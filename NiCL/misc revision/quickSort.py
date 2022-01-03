def QuickSort(int_list):
    if(not int_list):
        return []
    
    if(len(int_list)==1):
        return int_list
    pivot = int_list[0]
    
    left_list = []
    right_list = []
    for i in int_list[1:]:
        if(i<pivot):
            left_list.append(i)
        else:
            right_list.append(i)
    return QuickSort(left_list) + [pivot] + QuickSort(right_list)


print(QuickSort([1,3,5,7,2]))