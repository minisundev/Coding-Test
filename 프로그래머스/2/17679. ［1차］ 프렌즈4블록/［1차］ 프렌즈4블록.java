import java.util.*;
import java.lang.Math;

class Solution { 
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        List<List<Character>> list = new ArrayList<>();
        
        //리스트 초기화
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        
        //리스트에 넣기(세로로)
        for(String s : board){
            for(int i=0; i<s.length(); i++){
                list.get(i).add(s.charAt(i));
            }
        }
        
        //변화가 있었으면 또 계산하고 아니면 끝남
        boolean hasChanged = true;
        while(hasChanged){
            hasChanged = false;
            
            //지울 인덱스 리스트 Set으로 만듦 중복을 방지하기 위해서
            List<Set<Integer>> remove = new ArrayList<>();
            for(int i=0; i<n; i++){
                remove.add(new HashSet<>());
            }
            
        
            //왼쪽줄 1개랑 오른쪽줄 1개랑 가져와서 봄
            for(int j=0; j<n-1; j++){
                List<Character> left = list.get(j);
                List<Character> right = list.get(j+1);
                
                int min = Math.min(left.size(),right.size())-1;

            
                for(int i=0; i<min; i++){
            
                    //네개 비교함
                    char l1 = left.get(left.size()-1-i);
                    char l2 = left.get(left.size()-1-(i+1));
                    char r1 = right.get(right.size()-1-i);
                    char r2 = right.get(right.size()-1-(i+1));
                    //System.out.println(l1+","+l2+","+r1+","+r2);//아니 테케 다 돌렷는데 제대로 돌아가는디.. 중간과정도.. 어쩌라고 어쩌라고 진짜 
                    //힘들다 진자 흑흑 내가 여태껏 제출한 코드들도 히든케이스에서 안 돌아갔겠지...
                
                    if(l1==l2 && l2==r1 && r1==r2){
                        hasChanged = true;
                        remove.get(j).add(left.size()-1-i);
                        remove.get(j).add(left.size()-1-(i+1));
                        remove.get(j+1).add(right.size()-1-i);
                        remove.get(j+1).add(right.size()-1-(i+1));
                    }  
                }
            }
            
            for(int i=0; i<n; i++){
                List<Character> chars = list.get(i);
                Set<Integer> targets = remove.get(i);
                answer += targets.size();
                
                List<Integer> targetList = new ArrayList<>(targets);
                Collections.sort(targetList);
                
                int diff = 0;
                for(int t : targetList){
                    chars.remove(t-diff);
                    diff++;
                }
            }
        }
        
        
        return answer;
    }
}