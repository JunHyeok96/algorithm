def solution(routes):
    answer = 0
    routes = sorted(routes, key = lambda x : (x[1]) )
    last_route = -30000
    for route in routes:
        if route[0] > last_route:
            answer +=1
            last_route = route[1]
    return answer