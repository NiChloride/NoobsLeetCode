class TrieNode:
    def __init__(self):
        self.child = dict()
        self.eow = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        cur = self.root
        for l in word:
            if not cur.child.get(l):
                cur.child[l]= TrieNode()
            cur = cur.child[l]
        cur.eow = True

    def search(self, word: str) -> bool:
        def dfs(j, node):
            cur = node
            
            for i in range(j, len(word)):
                l = word[i]
                if not cur.child.get(l):
                    return False
                cur = cur.child[l]
            return cur.eow
        
        return dfs(0, self.root)

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        
        for l in prefix:
            if not cur.child.get(l):
                return False
            cur = cur.child[l]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
