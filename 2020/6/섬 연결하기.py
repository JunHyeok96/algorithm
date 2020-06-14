def dfs(graph, start):
    need_go, visited = list(), list()
    need_go.append(start)
    while need_go:
        node = need_go.pop()
        if not node in visited:
            visited.append(node)
            need_go.extend(graph[node])
    return len(visited)

def make_graph(costs):
    graph = {}
    for cost in costs:
        if not cost[0] in graph.keys():
            graph[cost[0]] = [cost[1]]
        else:
            graph[cost[0]].append(cost[1])
        if not cost[1] in graph.keys():
            graph[cost[1]] = [cost[0]]
        else:
            graph[cost[1]].append(cost[0])
    return graph

def solution(n, costs):
    costs = sorted(costs, key = lambda x : x[2],  reverse= True)
    idx = 0
    while len(costs) >= n :
        costs_copy = costs.copy()
        node = costs_copy.pop(idx)
        graph = make_graph(costs_copy)
        if dfs(graph, costs_copy[0][0]) != n:
            idx+=1
        else:
            costs = costs_copy            

    answer = sum([cost[2] for cost in costs])

    return answer