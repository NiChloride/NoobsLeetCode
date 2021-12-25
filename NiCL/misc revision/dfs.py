graph = {
    'A':['B','C'],
    'B':['A','C','D'],
    'C':['A','B','D','E'],
    'D':['B','C','E','F'],
    'E':['C','D'],
    'F':['D'],
}
def DFS(graph,s):       #graph表示图表关系，s表示开始的节点
    stack = []          #新建栈
    stack.append(s)       #将初始节点加入到栈中
    seen = set()       #建立一个集合，后续判断是否重复
    seen.add(s)
    while (len(stack) > 0):
        vertex = stack.pop()     #移出栈的最后一个元素
        nodes = graph[vertex]     #找到那个元素的相关节点并保存起来
        for w in nodes:
            if w not in seen:        #如果节点不重复，就添加到栈中
                stack.append(w)
                seen.add(w)
        print(vertex)
DFS(graph,'A')
