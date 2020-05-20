    def solution(arrangement):
        laser = arrangement.replace("()","r");
        cutting = []
        count = 0
        for i in laser:
            if i == "r":
                count+=len(cutting)
            elif i == "(":
                cutting.append("(")
            elif i == ")":
                cutting.pop()
                count+=1
        return count