def solution(people, limit):
    answer, start_idx, end_idx = 0, 0, len(people)-1
    people.sort()
    while start_idx<=end_idx:
        temp_sum = people[end_idx]
        if people and temp_sum + people[start_idx] <= limit:
            temp_sum += people[start_idx]
            start_idx+=1
        end_idx-=1
        answer+=1
    return answer