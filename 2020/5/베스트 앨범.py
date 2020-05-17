def solution(genres, plays):
    answer = []
    genre_count = {}
    genre_sum = {}

    for i in range(len(genres)):
        if not genres[i] in genre_count.keys():
            genre_sum[genres[i]]=plays[i]
            genre_count[genres[i]] = [(plays[i], i)]
        else:
            genre_sum[genres[i]]+=plays[i]
            genre_count[genres[i]].append((plays[i],i))
            
    genre_sort = sorted(genre_sum.items(), key=lambda x: x[1], reverse=True)
    
    for i in genre_sort:
        list = sorted(genre_count[i[0]], key = lambda x : (x[0], -x[1]), reverse = True)
        answer += [ idx for value, idx in list[:2]]
        
    return answer