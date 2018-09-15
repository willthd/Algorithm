package practice;

import java.util.*;

// kakao 2017 하반기 1차 2번
public class ppp {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan"};
		String[] result = solution(record);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static String[] solution(String[] record) {
		String id[] = new String[record.length];
		String command[] = new String[record.length];
		for (int i = 0; i < record.length; i++) {
			String splitStr[] = record[i].split(" ");
			id[i] = splitStr[1];
			command[i] = splitStr[0];
		}
		for (int i = 0; i < id.length; i++) {
			
		}
		String result[] = {};
		return result;
	}
}