class TrieNode:
    def __init__(self):
            self.child = dict()
            self.eow = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
    '''
    def addWord(self, word: str) -> None:
        cur = self.root
        for l in word:
            if not cur.child.get(l):
                cur.child[l] = TrieNode()
            cur = cur.child[l]
        cur.eow = True
    '''
    def search(self, num: str) -> List:
        
        out = []
        tmp = ''

        def dfs(j, node, word):
            cur = node

            for letter in numtoLetter[num[j]].values():
                word += letter
                if cur.child.get(letter):
                    for child in cur.child[letter].values():
                        dfs(j+1, child, word)

                    return word
                else:
                    return ''
                    
        return dfs(0, self.root, tmp)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)