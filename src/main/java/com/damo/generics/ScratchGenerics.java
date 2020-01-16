package main.java.com.damo.generics;

class GenecicKlass<P> {
    P ob;

    public GenecicKlass(P ob) {
        this.ob = ob;
    }

    public P getOb() {
        return ob;
    }

    void getType(){
        System.out.println("Type is"+ob.getClass().getName());
    }
}

public class ScratchGenerics {
    public static void main(String[] args) {
        GenecicKlass<Double> dob=new GenecicKlass<>(3.14);
        dob.getType();
        System.out.println("value"+dob.getOb());

        GenecicKlass<Double> strob=new GenecicKlass<>(3.14);
        strob.getType();
        System.out.println("value"+strob.getOb());
    }
}
