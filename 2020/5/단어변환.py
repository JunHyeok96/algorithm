def dfs(graph, start, end):
    visited, need_visit = list(), list()
    need_visit.append(start)
    count = 0
    while need_visit:
        node = need_visit.pop()
        if node not in visited:
            visited.append(node)
            if node == end:
                return count
            need_visit.extend(graph[node])
            count +=1    
    return count 

def make_graph(words):
    word_dict = {}
    for src_word in words:
        word_list = words.copy()
        word_list.remove(src_word)
        word_dict[src_word] = []
        for dst_word in word_list:
            count = 0
            for i in range(len(dst_word)):
                if src_word[i] != dst_word[i]:
                    count +=1
            if count == 1:
                word_dict[src_word] += [dst_word]
    return word_dict 

def solution(begin, target, words):
    if not target in words:
        return 0
    all_word = words + [begin]
    graph = make_graph(all_word)
    answer = dfs(graph, begin, target)
    return answer