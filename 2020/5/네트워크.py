def bfs(graph, start):
    need_go, visited = list(), list()
    need_go.append(start)
    
    while len(need_go):
        check_node = need_go.pop(0)
        if not check_node in visited:
            visited.append(check_node)
            need_go.extend(graph[check_node])
            
    return visited

def solution(n, computers):
    connect_node = {}
    connect_node_list = []
    count = 0
    
    for idx, computer in enumerate(computers):
        computer[idx] = 0
        connect_node[idx] = []
        for i in range(len(computer)):
            if computer[i] == 1:
                connect_node[idx] += [i]
                
    for i in range(n):        
        if i in connect_node_list:
            continue
        else:
            connect_node_list += bfs(connect_node, i)
            count+=1

    return count