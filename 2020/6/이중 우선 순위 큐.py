def solution(operations):
    hq = []
    for oper in operations:
        if oper[0] == "I":
            hq.append(int(oper.split(" ")[1]))
        elif len(hq):
            if oper == "D -1":
                hq.remove(min(hq))
            elif oper == "D 1":
                hq.remove(max(hq))
    if len(hq):
        return [ max(hq), min(hq)]
    else:
        return  [0,0]


import heapq
def solution(operations):
    hq = []
    for oper in operations:
        if oper[0] == "I":
            heapq.heappush(hq,int(oper.split(" ")[1]))
        elif len(hq):
            if oper == "D -1":
                heapq.heappop(hq)
            elif oper == "D 1":
                hq.remove(max(hq))
    if len(hq):
        return [ max(hq), heapq.heappop(hq)]
    else:
        return  [0,0]

