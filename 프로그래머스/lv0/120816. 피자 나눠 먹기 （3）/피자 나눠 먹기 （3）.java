class Solution {
    public int solution(int slice, int n) {
        
        return slice < n ? n % slice == 0 ? n / slice : n / slice + 1 : 1;
    }
}