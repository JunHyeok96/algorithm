def solution(priorities, location):
    order = sorted(priorities, reverse = True)    
    count = 0
    while True :
        if order[0]==priorities[0]:
            priorities.pop(0)
            order.pop(0)
            count +=1
            if location == 0:
                break;
            location -=1
        else:
            priorities.append(priorities.pop(0))        
            if location == 0 :
                location = len(priorities)-1
            else:
                location -=1
    return count