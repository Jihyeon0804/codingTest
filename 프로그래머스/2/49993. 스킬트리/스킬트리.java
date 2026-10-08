class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            
            // skill에 있는 문자만 남기기
            tree = tree.replaceAll("[^" + skill + "]", "");

            // 선행 스킬과 일치하면 answer++
            if (skill.startsWith(tree)) {
                answer++;
            }
        }

        return answer;
    }
}