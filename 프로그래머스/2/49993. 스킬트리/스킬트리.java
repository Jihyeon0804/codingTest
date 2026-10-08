class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {

            int position = 0;
            boolean valid = true;

            for (char c : skillTree.toCharArray()) {
                int idx = skill.indexOf(c);

                if (idx == -1) {
                    continue; // 선행 스킬에 없는 문자이면 pass
                }

                // 순서가 아닌 경우
                if (idx != position) {
                    valid = false;
                    break;
                }
                position++;
            }

            if (valid) {
                answer++;
            }
        }

        return answer;
    }
}