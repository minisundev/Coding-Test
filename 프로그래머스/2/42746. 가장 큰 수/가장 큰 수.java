import java.util.*;
import java.lang.Math;
import java.lang.StringBuilder;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();
        //등록
        for (int i : numbers) {
            list.add(Integer.toString(i));
        }
        //정렬
        list.sort((s1, s2) -> compare(s1, s2));
        //sort(list);
        //출력
        for (String s : list) {
            answer += s;
        }
        //맨 앞에 0이 있다는건 0 말고 다른 숫자가 없다는 것
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
    
    public void sort(ArrayList<String> list) {
        int n = list.size();
        boolean swapped;
        for(int i=0;i<n;i++){
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                
                String s1 = list.get(j);
                String s2 = list.get(j + 1);
                if(compare(s1,s2)==1){
                    Collections.swap(list,j,j+1);
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }


    public int compare(String s1, String s2) {
        int length = Math.min(s1.length(),s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                return 1;
            }
        }
        if(s1.length()==s2.length()){
            return 0;
        }else{
            String t1 = s1+s2;
            String t2 = s2+s1;
            return compare(t1,t2);
        }
    }
}