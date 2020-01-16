package main.java.com.damo.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();

        for(int i=0;i<5;i++){
            list.add(i);
        }

        Iterator<Integer>iterator=list.iterator();
        while(iterator.hasNext()){
            int i=(int)iterator.next();
            System.out.println(i+" ");
        }
        System.out.println("\n"+list);

        Iterator<Integer>iterator1=list.iterator();
        while (iterator1.hasNext()){
            int x=(int) iterator1.next();
            if (x%2==0){
                iterator1.remove();
            }
        }
        System.out.println(list);

        iterator=list.iterator();
        while (iterator.hasNext()){
            int x=(int)iterator.next();
            System.out.println(x+" ");
        }
    }
}
