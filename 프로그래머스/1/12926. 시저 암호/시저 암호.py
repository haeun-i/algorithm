def solution(s, n):
    answer = ''
    for c in s:
        if(ord(c) >= 65 and ord(c) <= 90):
            answer += chr(((ord(c)-65+n)%26)+65)
        elif(ord(c) >= 97 and ord(c) <= 122):
            print(ord(c))
            answer += chr(((ord(c)-97+n)%26)+97)
        else:
            answer += c
    return answer