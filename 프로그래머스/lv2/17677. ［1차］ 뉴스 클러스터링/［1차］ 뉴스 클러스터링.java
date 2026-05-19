import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        
        // 다중집합 생성
        List<String> str1List = getStringList(str1);
        List<String> str2List = getStringList(str2);

        // 공집합 처리
        if (str1List.isEmpty() && str2List.isEmpty()) {
            return 65536;
        }

        // 교집합 크기 계산
        int inter = 0;
        List<String> str2Copy = new ArrayList<>(str2List);
        for (String s : str1List) {
            if (str2Copy.remove(s)) {
                inter++;
            }
        }

        // 합집합 크기 계산
        int union = str1List.size() + str2List.size() - inter;

        // 자카드 유사도 계산
        return (int) Math.floor((double) inter / union * 65536);
    }

     static List<String> getStringList(String str) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).toLowerCase();
            if (Pattern.matches("^[a-zA-Z]*$", s)) {
                strList.add(s);
            }
        }

        return strList;
    }
}
