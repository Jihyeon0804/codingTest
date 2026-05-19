class Solution {
    public String solution(String my_string) {
        
        // 정규식
        // return my_string.replaceAll("[aeiou]", "");
        
        char[] arr = {'a', 'e', 'i', 'o', 'u'};
        for (char c : arr) {
            if (my_string.contains(Character.toString(c))) {
                my_string =  my_string.replace(Character.toString(c), "");
            }
        }
        return my_string;
    }
}