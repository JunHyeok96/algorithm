class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String tree : skill_trees){
            if(isCorrect(skill, tree)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isCorrect(String skill, String tree){
        boolean[] check = new boolean[skill.length()];
        int idx=-1;
        int count = 0;
        for(char element : skill.toCharArray()){
            int tempIdx = tree.indexOf(element);
            if(tempIdx != -1){
                if(idx > tempIdx){
                    return false;
                }else{
                    check[count] = true;
                    if(count > 0 && check[count-1] == false){
                        return false;
                    }
                    idx = tempIdx;
                }
            }
            count++;
        }
        return true;
    }
}