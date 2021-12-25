graph = {
    'A':['B','C'],
    'B':['A','C','D'],
    'C':['A','B','D','E'],
    'D':['B','C','E','F'],
    'E':['C','D'],
    'F':['D'],
}
def BFS(graph,s):       #graph表示图表关系，s表示开始的节点
    queue = []          #新建队列
    queue.append(s)       #将初始节点加入到队列中
    seen = set()       #建立一个集合，后续判断是否重复
    seen.add(s)
    while (len(queue) > 0):
        vertex = queue.pop(0)     #移出队列的第一个元素
        nodes = graph[vertex]     #找到那个元素的相关节点并保存起来
        for w in nodes:
            if w not in seen:      #如果节点不重复，就添加到队列中
                queue.append(w)
                seen.add(w)
        print(vertex)
BFS(graph,'A')

