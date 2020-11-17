class Solution {
    public int solution(String skill, String[] skill_trees) {
        char[] arr = skill.toCharArray();
        int answer = 0;
        for(String skill_tree : skill_trees){
            boolean check = true;
            int pos =  0;
            for(int i =0; i<skill_tree.length(); i++){
                int value = skill.indexOf(skill_tree.charAt(i));
                if(value == -1){
                    continue;
                }
                if(pos < value){
                    check=false;
                    break;
                }else{
                    pos += 1;
                }
            }
           answer = check ? answer + 1 : answer;
        }
        return answer;
    }
}