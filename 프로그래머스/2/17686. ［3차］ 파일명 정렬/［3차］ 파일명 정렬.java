import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("^([^\\d]+)(\\d{1,5})(.*)$");

        Arrays.sort(files, (f1, f2) -> {
            Matcher m1 = pattern.matcher(f1);
            Matcher m2 = pattern.matcher(f2);

            if (m1.find() && m2.find()) {
                // HEAD 비교 (대소문자 구분X )
                String head1 = m1.group(1).toLowerCase();
                String head2 = m2.group(1).toLowerCase();

                int headCompare = head1.compareTo(head2);
                // HEAD가 다르면 HEAD 순으로 정렬
                if (headCompare != 0) {
                    return headCompare;
                }

                // NUMBER 비교 (문자열 -> 정수 변환하여 비교)
                int num1 = Integer.parseInt(m1.group(2));
                int num2 = Integer.parseInt(m2.group(2));

                // NUMBER가 다르면 오름차순 정렬
                if (num1 != num2) {
                    return Integer.compare(num1, num2);
                }
            }

            // HEAD와 NUMBER 둘 다 같으면 원래 순서 유지
            return 0;
        });

        return files;
    }
}