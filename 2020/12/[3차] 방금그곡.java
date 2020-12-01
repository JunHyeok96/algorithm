import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        m = normalize(m);
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> start_time_map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String musicinfo : musicinfos){
            String[] info = musicinfo.split(",");
            int range = timeToInt(info[1]) - timeToInt(info[0]);
            info[3] = normalize(info[3]);
            for(int i=0; i < range; i++){
                sb.append(info[3].charAt(i% info[3].length()));
            }
            String music = sb.toString();
            map.put(info[2], music);
            sb.delete(0, music.length());
            start_time_map.put(info[2], timeToInt(info[0]));
        }
        List<String> answers = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).contains(m)){
                answers.add(key);
            }
        }
        Collections.sort(answers, (s1, s2) -> {
            if(map.get(s2).length() == map.get(s1).length()){
                return start_time_map.get(s1) - start_time_map.get(s2);
            }else{
                return map.get(s2).length() - map.get(s1).length();
            }});                             
        return answers.size() > 0 ? answers.get(0) : "(None)";
    }
    
    public int timeToInt(String stringTime){
        String[] time = stringTime.split(":");
        int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        return minutes;
    }
    
    public String normalize(String input){
        input = input.replace("C#", "c");
        input = input.replace("D#", "d");
        input = input.replace("F#", "f");
        input = input.replace("G#", "g");
        input = input.replace("A#", "a");
        return input;
    }
}