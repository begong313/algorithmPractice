import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ20920{
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            if(s.length()<M){
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.compare(map.get(o1), map.get(o2)) != 0){
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                if(o1.length() != o2.length()){
                    return o2.length()-o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str:words){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}