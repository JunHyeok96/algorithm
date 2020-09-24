def solution(board, moves):
    stack = []
    anwser = 0
    for i in range(len(moves)):
        for row in board:
            if row[moves[i]-1] == 0:
                continue
            else:
                stack.append(row[moves[i]-1])
                if len(stack) > 1 and stack[-1] == stack[-2]:
                    stack.pop()
                    stack.pop()
                    anwser+=2
                row[moves[i]-1] = 0
                break
    return anwser