import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder(26);
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int idx = 0;
        for(String log : record){
            String[] logSplit = log.split(" ");
            if(logSplit.length == 3){
                map.put(logSplit[1], logSplit[2]);
            }
        }
        for(String log : record){
            String[] logSplit = log.split(" ");
            if(logSplit[0].equals("Change")) continue;
            answer.add(makeLog(logSplit[0], 
                               logSplit[1], 
                               map.get(logSplit[1])));
        }
        return answer.toArray(new String[answer.size()]);
    }

    public String makeLog(String action, String id, String nickname){
        sb.append(nickname);
        if(action.equals("Enter")){
            sb.append("님이 들어왔습니다.");
        }else if(action.equals("Leave")){
            sb.append("님이 나갔습니다.");
        }
        String result = sb.toString();
        sb.delete(0, result.length());
        return result;
    }
}