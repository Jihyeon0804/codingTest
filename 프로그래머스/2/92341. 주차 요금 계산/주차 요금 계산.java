import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();

        // fees = [기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)]
        // records = ["시각 차량번호 입/출차", ...]

        // 차량 번호가 작은 자동차부터 출력이니 TreeMap 사용
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int hour = Integer.parseInt(split[0].substring(0, 2));
            int minute = Integer.parseInt(split[0].substring(3, 5));
            String carNum = split[1];
            String direction = split[2];

            int time = hour * 60 + minute;

            if (direction.equals("IN")) {
                inMap.put(carNum, time);
            } else {
                // 출차 처리 : 총 주차 시간 계산 후 입차 Map에서 제거
                int parkTime = time - inMap.get(carNum);
                inMap.remove(carNum);
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parkTime);
            }
        }

        for (String car : inMap.keySet()) {
            int parkTime = 1439 - inMap.get(car);
            timeMap.put(car, timeMap.getOrDefault(car, 0) + parkTime);
        }

        for (String car : timeMap.keySet()) {
            int time = timeMap.get(car);
            int fee = fees[1];


            // 기본 시간 초과 시
            if (time > fees[0]) {
                fee += (int) (Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3]);
            }
            answer.add(fee);
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}