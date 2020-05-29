import heapq

def solution(jobs):
    answer, time, end, count = 0, 0, -1, 0
    hq = []
    n= len(jobs)
    while count < n:
        for job in jobs:
            if end < job[0] <= time:
                heapq.heappush(hq, job[1])
                answer += time - job[0]
        if hq:
            answer += hq[0] * len(hq)
            end = time
            time += heapq.heappop(hq)
            count += 1
        else:
            time+=1
            
    return int(answer/n)