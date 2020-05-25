def solution(answers):
    best = [0, 0, 0]
    per1 = [1, 2, 3, 4, 5]
    per2 = [2, 1, 2, 3, 2, 4, 2, 5]
    per3 = [3, 3, 1, 1, 2, 2, 4, 4 ,5, 5]
    for i in range(len(answers)):
        if per1[i%5] == answers[i]:
            best[0] +=1
        if per2[i%8] == answers[i]:
            best[1] +=1
        if per3[i%10] == answers[i]:
            best[2] +=1
    answer=[]
    max_acc = max(best)
    for i in range(len(best)):
        if best[i] == max_acc :
            answer.append(i+1)
    return answer