def solution(answers):
    answer = []
    
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    cnt = [0] * 3
    
    # p1
    for i in range(len(answers)):
        if(answers[i] == p1[i%len(p1)]): cnt[0] += 1
        
    # p2
    for i in range(len(answers)):
        if(answers[i] == p2[i%len(p2)]): cnt[1] += 1
        
    # p2
    for i in range(len(answers)):
        if(answers[i] == p3[i%len(p3)]): cnt[2] += 1
    
    max_size = max(cnt)
    
    for i in range(len(cnt)):
        if(cnt[i] == max_size): 
            answer.append(i+1)
    
    
    return answer