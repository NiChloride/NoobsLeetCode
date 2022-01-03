//DAG, BFS

public class Solution {
    /**
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        //find out whether the prerequisites make a DAG
        //if it does, find out whether there are enough courses, if there are cycles, return false
        List[] graph = new ArrayList[numCourses]; //adjacency list
        int[] inDegree = new int[numCourses];
        //initialise the graph with empty arrayLists
        for (int i=0;i<numCourses;i++)
        {
            graph[i] = new ArrayList<Integer>();//edges, from i to graph[i]
        }
        //build the graph
        for (int[] edge: prerequisites)
        {
            graph[edge[1]].add(edge[0]); //from 1 point to 0
            inDegree[edge[0]]++;
        }
        int num_classes_selected = 0;
        //add all classes with indegree(0) to the queue
        Queue queue = new LinkedList();
        for (int i=0;i<numCourses;i++)
        {
            if(inDegree[i]==0)
            {
                queue.add(i);
            }
        }

        while (!queue.isEmpty())
        {
            //pop queue, remove its adjacent nodes' indegrees by 1
            int cur = (int) queue.poll();//pop
            num_classes_selected++;
            //remove every edge. if the indegree of next node becomes 0, add it to the queue
            for (int i=0; i<graph[cur].size();i++)
            {
                int next_node = (int)graph[cur].get(i); //ith neighbour
                inDegree[next_node]-- ; //reduce in degree of neighbour by 1
                if(inDegree[next_node]==0)
                {
                    queue.add(next_node);
                }

            }
        }
        return num_classes_selected==numCourses;

        

    }
}