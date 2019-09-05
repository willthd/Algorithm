def solution(record):
    id_name_dict = {}

    for str_ in record:
        word_list = str_.split()
        if word_list[0] == 'Enter' or word_list[0] == 'Change':
            id_name_dict[word_list[1]] = word_list[2]

    answer = []

    for str_ in record:
        word_list = str_.split()
        if word_list[0] == 'Enter':
            answer.append(id_name_dict[word_list[1]] + "님이 들어왔습니다.")
        elif word_list[0] == "Leave":
            answer.append(id_name_dict[word_list[1]] + "님이 나갔습니다.")

    return answer

parameter = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
print(solution(parameter))
