package main.java.com.damo.generics;

public class Triple<T extends Number&Comparable<T>> {
    private T value1;
    private T value2;
    private T value3;

    public Triple(T value1, T value2, T value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    private T sum(){
        Number sum=value1.doubleValue()+value2.doubleValue()+value3.doubleValue();
        return (T)sum;
    }

    private T largest(){
        T result=value1;
        if (value2.compareTo(result)>0){
            result=value2;
        }
        if (value3.compareTo(result)>0){
            result=value3;
        }
        return result;
    }

    public static void main(String[] args) {
        Triple<Integer>t=new Triple<>(8,10,13);
        System.out.println("Sum is"+t.sum());
        System.out.println("Largest is"+t.largest());
    }
}
