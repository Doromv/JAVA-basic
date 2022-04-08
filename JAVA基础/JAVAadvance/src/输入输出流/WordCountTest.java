package 输入输出流;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author shkstart
 * @create 2021-12-15-15:28
 */
public class WordCountTest {
    public static void main(String[] args) {
        FileReader fr= null;
        BufferedWriter bw= null;
        try {
            Map<Character,Integer>map=new HashMap<>();
            fr = new FileReader("美文.txt");
            bw = new BufferedWriter(new FileWriter("美文各个字出现次数的统计.txt"));
            int c=0;
            while ((c=fr.read())!=-1){
                char ch=(char)c;
                if(map.get(ch)==null){
                    map.put(ch,1);
                }else {
                    map.put(ch,map.get(ch)+1);
                }
            }
            Set<Map.Entry<Character,Integer>> entrySet=map.entrySet();
            for(Map.Entry<Character,Integer>entry:entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键="+entry.getValue());
                        break;
                    case'\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
            if(bw!=null)
                bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
