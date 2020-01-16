package main.java.com.damo.collections;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
public class ArrayToList {
    public static void main(String[] args) {
        String[]vowels={"a","e","i","o","u"};

        List<String>vowelsList= Arrays.asList(vowels);
        System.out.println(vowelsList);

        String[]vowelsArray=(String[])vowelsList.toArray();
        for (String vowel:vowelsArray){
            System.out.println(vowel+"");
        }
    }
}
