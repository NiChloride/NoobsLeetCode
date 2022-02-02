class Solution:
    """
    @param logs: the logs
    @return: the logs after sorting
    
    three rules:
    1.Logs whose content is letter should be ahead of logs whose content is number.
    2.Logs whose content is letter should be sorted by their content in lexicographic order. And when two logs have same content, sort them by ID in lexicographic order.
    3.Logs whose content is number should be in their input order.
    """
    def logSort(self, logs):
        # Write your code here

        def Sortkeys(logGiven):
            id, log = logGiven.split(' ', 1)
            if log[0].isalpha():
                return (0, log, id)
            else:
                return (1, None, None)
            

        logs.sort(key=Sortkeys)

        return logs
