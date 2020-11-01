import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer>play_map = new HashMap<>();
        HashMap<String, List<Integer>>index_map = new HashMap<>();
        List<Integer> id_order = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            play_map.put(genres[i], play_map.getOrDefault(genres[i], 0) + plays[i]);
            if(index_map.get(genres[i]) == null){
                index_map.put(genres[i], new ArrayList<Integer>(Arrays.asList(i))); 
            }else{
                List<Integer> arr = new ArrayList<Integer>(index_map.get(genres[i]));
                arr.add(i);
                index_map.put(genres[i], arr);
            }
        }
        List<String> genres_order = new ArrayList<>(play_map.keySet());
        Collections.sort(genres_order, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return play_map.get(s2) - play_map.get(s1);
            }
        });          
        for(String key : genres_order){
            List<Integer> arr = new ArrayList<>(index_map.get(key));
            HashMap<Integer, Integer> id_map = new HashMap<>();
            for(int id : arr)id_map.put(id, plays[id]);
            Collections.sort(arr, new Comparator<Integer>(){
                @Override
                public int compare(Integer i1, Integer i2){
                    return id_map.get(i2) - id_map.get(i1);           
            }});
            id_order.add(arr.get(0));
            if(arr.size() > 1){
                id_order.add(arr.get(1));
            }
        }
        return id_order.stream().mapToInt( i -> i.intValue()).toArray();
    }
}