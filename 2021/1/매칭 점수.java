import java.util.*;
class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
        word = word.toLowerCase();
        Map<String, Set<String>> map = new HashMap<>();
        Page[] pageArr = new Page[pages.length];
        int idx=0;
        for(String page : pages){
            String url = page.split("<meta property=")[1]
                .split("content=")[1]
                .split("/>")[0];
            String body = page.split("<body>")[1].split("</body>")[0].toLowerCase();
            String[] hrefs = body.split("</a>");
            int linkCnt=0;
            int searchCnt=search(body, word);
            for(String href : hrefs){
                if(href.split("<a href=").length > 1){
                    String externalHref = href.split("<a href=")[1].split(">")[0];
                    map.put(externalHref,
                            map.getOrDefault(externalHref, new HashSet<String>()));
                    map.get(externalHref).add(url);
                    linkCnt++;
                }
            }
            
            pageArr[idx++] = new Page(url, searchCnt, linkCnt);
        }
        float maxScore = 0;
        for(int i=0; i<pageArr.length; i++){
            float tempScore = pageArr[i].baseScore;
            if(map.containsKey(pageArr[i].url)){
                for(String href : map.get(pageArr[i].url)){
                    for(Page tempPage : pageArr){
                        if(tempPage.url.equals(href)){
                            tempScore += (float)tempPage.baseScore/tempPage.linkCnt;
                        }
                    }
                }
            }
            if(maxScore < tempScore){
                maxScore = tempScore;
                answer = i;
            }
        }
        return answer;
    }
    public int search(String body, String word){
        int wordLength = word.length();
        int bodyLength = body.length();
        int count=0;
        for(int i=1; i< bodyLength - wordLength; i++){
            if((body.charAt(i - 1) < 'a' ||  
                body.charAt(i - 1) > 'z') &&
               (body.charAt(i+ wordLength) < 'a' ||  
                body.charAt(i+ wordLength) > 'z') &&
               word.equals(body.substring(i, i+wordLength))
              ){
                count++;
            }
        }
        return count;
    }
}

class Page{
    String url;
    int baseScore;
    int linkCnt;
    public Page(String url, int baseScore, int linkCnt){
        this.url=url;
        this.baseScore=baseScore;
        this.linkCnt=linkCnt;
    }
}