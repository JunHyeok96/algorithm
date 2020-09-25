def solution(numbers):
    answer = []
    for i in range(len(numbers)-1):
        numbers_copy = numbers[i+1:]
        for number in numbers_copy:
            answer.append(numbers[i] + number)
    return sorted(list(set(answer)))