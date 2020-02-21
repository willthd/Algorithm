def solution(S):
    if len(S)%2 == 1:
        return 0

    st = []
    for c in S:
        if c == '(':
            st.append(c)
        else:
            length = len(st)
            if length < 1:
                return 0
            if st[length-1] == '(':
                    st.pop()

    if len(st) == 0:
        return 1

    return 0