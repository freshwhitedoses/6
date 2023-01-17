import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] mas = new String[]{"Daa","Neet","Yes","No","Daa"};
        guavaSort(mas);
    }
    public static void guavaSort(String[] mas){
        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(Arrays.asList(mas));
        List<String>[] buckets=new List[multiset.size()/3];
        for (int i =0;i<multiset.size()/3;i++){
            buckets[i]=new LinkedList<>();
        }
        for(String entry: multiset.elementSet()){
            buckets[entry.hashCode()%(multiset.size()/3)].add(entry);
        }
        int i=0;
        for(List<String> bucket:buckets){
            Collections.sort(bucket);
            for(String str: bucket){
                for(int j=0;j<multiset.count(str);j++){
                    mas[i] = str;
                    System.out.println(str);
                    i++;
                }
            }
        }
    }
}