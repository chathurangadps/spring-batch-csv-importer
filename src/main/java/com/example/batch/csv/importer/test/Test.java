package com.example.batch.csv.importer.test;

public class Test {

    public static void main(String[] args) {
        new A2().mm();
    }
}


class A1{

    /*public void mm(){
        System.out.println("A1 from mm()");
    }*/
}

class A2 extends A1 implements I1{

    /*public void mm(){
        super.mm();
        System.out.println("A2 from mm()");
    }*/
}

interface I1{
    default void mm(){
        System.out.println("I1 from mm()");
    }
}




