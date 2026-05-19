class Solution {
    public String solution(String my_string, String alp) {
        my_string = my_string.replace(alp, alp.toUpperCase());
        return my_string;
    }
}