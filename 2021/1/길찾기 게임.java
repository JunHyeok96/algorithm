import java.util.*;
class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Point[] pointArr = new Point[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            pointArr[i] = new Point(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }
        Arrays.sort(pointArr, (i1, i2) -> i2.y == i1.y ? i2.x - i1.x : i2.y - i1.y);
        for(int i=1; i <  pointArr.length; i++){
            searchAndInsert(pointArr[0], pointArr[i]);
        }
        List<Integer> list = new ArrayList<>();
        preorder(pointArr[0], list);
        answer[0] = list.stream().mapToInt(i -> i).toArray();
        list.clear();
        postorder(pointArr[0], list);
        answer[1] = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    public void searchAndInsert(Point root, Point insertPoint){
        if(root.x > insertPoint.x){
            if(root.left == null){
                root.left = insertPoint;
            }else{
                searchAndInsert(root.left, insertPoint);
            }
        }else{
            if(root.right == null){
                root.right = insertPoint;
            }else{
                searchAndInsert(root.right, insertPoint);
            }
        }
    }
    
    public void preorder(Point root, List list){
        list.add(root.order);
        if(root.left != null){
            preorder(root.left, list);
        }
        if(root.right != null){
            preorder(root.right, list);
        }
    }
    
    public void postorder(Point root, List list){
        if(root.left != null){
            postorder(root.left, list);
        }
        if(root.right != null){
            postorder(root.right, list);
        }
        list.add(root.order);
    }
}
class Point{
    int x;
    int y;
    int order;
    Point right;
    Point left;
    public Point(int x, int y, int order){
        this.x = x;
        this.y = y;
        this.order = order;
    }
}