class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String []arr_map = new String[n];
        for(int i=0; i<n; i++){
            String arrTo2 = Integer.toBinaryString(arr1[i] | arr2[i]);
            int arrlength = arrTo2.length();
            for(int j=0; j<n - arrlength; j++) arrTo2 = "0" + arrTo2;
            arrTo2 = arrTo2.replace("0", " ");
            arrTo2 = arrTo2.replace("1", "#");
            arr_map[i] = arrTo2;
        }
        return arr_map;
    }
}