# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

S = '(((('

def solution(S):
    if len(S)%2 == 1:
        return 0

    st = []
    for c in S:
        print(c)
        if c == '{' or c == '[' or c == '(':
            st.append(c)
        else:
            length = len(st)
            if length < 1:
                return 0
            if c == '}':
                if st[length-1] == '{':
                    st.pop()
                # else:
                #     return 0
            if c == ']':
                if st[length - 1] == '[':
                    st.pop()
                # else:
                #     return 0
            if c == ')':
                if st[length - 1] == '(':
                    st.pop()
                # else:
                #     return 0
        print(st)
    if len(st) == 0:
        return 1
    return 0

print('result :', solution(S))
