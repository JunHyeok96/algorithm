import copy

def path_search(path_list, graph, path, start, path_len):    
    if not start in graph :
        if len(path) == path_len:
            path_list.append(path)
        return path_list
    else:
        for node in graph[start]:
            node_path = path + [node]
            graph_copy = copy.deepcopy(graph)
            graph_copy[start].remove(node)
            if len(graph_copy[start]) == 0 :
                del graph_copy[start]
            path_search(path_list, graph_copy, node_path, node, path_len)

def make_graph(tickets):
    graph = {}
    for ticket in tickets:
        if not ticket[0] in graph:
            graph[ticket[0]] = [ticket[1]]
        else:
            graph[ticket[0]].append(ticket[1])
    return graph

def solution(tickets):
    path_list = []
    path_len= len(tickets)+1
    graph = make_graph(tickets)
    path_search(path_list, graph, ['ICN'],'ICN', path_len)
    path_list.sort()
    return path_list[0]