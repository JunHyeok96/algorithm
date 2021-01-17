class Solution {
    public int solution(String dartResult) {
        int[] point = new int[3];
        StringBuilder sb = new StringBuilder();
        int idx =0;
        for(char result : dartResult.toCharArray()){
            if(result >= '0' && result <= '9'){
                if(point[idx] != 0){
                    idx++;
                }       
                sb.append(result);
            }else{
                if(result == 'S'){
                    point[idx] = Integer.parseInt(sb.toString());
                }else if(result == 'D'){
                    point[idx] = (int)Math.pow(Integer.parseInt(sb.toString()), 2);
                }else if(result == 'T'){
                    point[idx] = (int)Math.pow(Integer.parseInt(sb.toString()), 3);
                }else if(result == '*'){
                    if(idx > 0){
                        point[idx -1] *= 2;
                        point[idx++] *= 2;
                    }else{
                        point[idx++] *= 2;
                    }
                }else if(result == '#'){
                    point[idx++] *= -1;
                }
                sb.setLength(0);
            }
        } 
        return point[0] + point[1] + point[2];
    }
}