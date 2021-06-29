class Solution {
    public String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        char[] arr = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < arr.length){
            if(arr.length - idx > 4){
                sb.append(arr[idx]);
                sb.append(arr[idx+1]);
                sb.append(arr[idx+2]);
                sb.append("-");
                idx+=3;
            }else if(arr.length - idx == 4){
                sb.append(arr[idx]);
                sb.append(arr[idx+1]);
                sb.append("-");
                sb.append(arr[idx+2]);
                sb.append(arr[idx+3]);
                idx+=4;
            }else if(arr.length - idx == 3){
                sb.append(arr[idx]);
                sb.append(arr[idx+1]);
                sb.append(arr[idx+2]);
                idx+=3;
            }else if(arr.length - idx == 2){
                sb.append(arr[idx]);
                sb.append(arr[idx+1]);
                idx+=2;
            }
        }
        return sb.toString();
    }
}