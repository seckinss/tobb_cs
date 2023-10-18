import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ngram {
    public void extractNgrams(String input_file,String output_file,int[] N_list) {
        Scanner s=null;
        try {
            s=new Scanner(new FileInputStream(input_file));
        } catch (Exception e) {
            System.out.println("alsdk");
        }
        String str="";
        while(s.hasNextLine()){
             str+=s.nextLine();
        }
        str=str.toLowerCase();
        str=str.replaceAll("[\\p{P}&&[^.]&&[^!]&&[^?]&&[^:]]", "");
        String[] k=str.split("[.?!]+");
        List<List<String>> words2=new ArrayList<List<String>>();
        for (int z = 0; z < k.length; z++) {
            String[] words=k[z].trim().split("\\p{Blank}");
            List<String> words1 =Arrays.asList(words); 
        
            for (int i = 0; i <= words1.size(); i++) {
                for (int j = words1.size()-1; j>=0; j--) {
                    for (int j2 = N_list.length-1; j2 >= 0; j2--) {
                        if(i-j==N_list[j2])
                            words2.add(words1.subList(j, i));
                    }
                }
            }
        }
        String output="";
        for (int i = 0; i < words2.size(); i++) {
            int count=1;
            List<String> strs=words2.get(i);
            for (int j = i+1; j < words2.size(); j++) {
                List<String> counter=words2.get(j);
                for (int j2 = 0; j2 < strs.size(); j2++) {
                    if(strs.size()!=counter.size())
                        break;
                    if(!(counter.get(j2).equals(strs.get(j2))))
                        break;
                    if(j2==strs.size()-1){
                        count++;
                        words2.remove(j);
                        j--;
                    }
                }
            }
            
            for (int i1=0;i1<strs.size(); i1++) {
                output+=strs.get(i1)+" ";
            }
            output+="("+count+")\n";
        }
        PrintWriter x=null;
        try {
            x=new PrintWriter(new FileOutputStream(output_file));
        } catch (Exception e) {
        }
        x.print(output);
        x.close();
}   
    public void updateNgrams(String ngram_str, String output_file){
        Scanner x=null;
        try {
           x=new Scanner(new FileInputStream(output_file));
        } catch (Exception e) {
        }
        String rtn="";
        ngram_str=ngram_str.toLowerCase().trim();
        boolean isDone=false;
        while(x.hasNextLine()){
            String isEq=x.nextLine();
            if(isEq.substring(0, isEq.length()-4).equals(ngram_str)){
                rtn+=ngram_str+" ("+(char)(isEq.charAt(isEq.length()-2)+1)+")\n";
                isDone=true;
            }
            else{
                rtn+=isEq+"\n";
                if(!x.hasNextLine()&&!isDone)
                    rtn+=ngram_str+" (1)";
            }
        }
        PrintWriter k=null;
        try {
            k=new PrintWriter(new FileOutputStream(output_file));
        } catch (Exception e) {
        }
        k.print(rtn);
        k.close();
    }
}
