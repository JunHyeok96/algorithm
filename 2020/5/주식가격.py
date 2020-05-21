def solution(prices):
    answer = [0 for i in range(len(prices))]
    index = []
    for i in range(len(prices)):
        for j in index.copy():
            if prices[j] > prices[i]:
                answer[j] = i - j   
                index.remove(j)  
            if i == len(prices)-1:
                answer[j] = len(prices) - j - 1
        index.append(i)      
    return answer