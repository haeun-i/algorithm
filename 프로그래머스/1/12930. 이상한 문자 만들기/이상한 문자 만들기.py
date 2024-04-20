def solution(s):
    answer = ''
    for str in s.split(" "):
        for c in range(len(str)):
                if(c % 2 == 0): 
                    answer += str[c].upper()
                else:
                    answer += str[c].lower()
        # if(len(str) == 0): answer += ' '
        answer += ' '
    answer = answer[:-1]
    return answer