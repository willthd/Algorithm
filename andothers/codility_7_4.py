def solution(H):
    st = []
    cnt = 0

    for height in H:
        while (len(st) != 0) and (st[-1] > height):
            st.pop()
        if (len(st) == 0) or (st[-1] < height):
            st.append(height)
            cnt += 1

    return cnt