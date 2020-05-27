import heapq

def solution(stock, dates, supplies, k):
    hip = []
    answer = 0
    date_idx = 0
    while stock < k:
        for i in range(date_idx,len(dates)): 
            if stock >= dates[i]: #버틸 수 있는한 최대한 버티며 밀가루 받을 수 있는거 전부 확보
                heapq.heappush(hip, -supplies[i])
                date_idx  = i + 1
            else:
                break
        stock -= heapq.heappop(hip)  #그중에 밀가루량이 많은 것을 가져옴
        answer +=1
    return answer