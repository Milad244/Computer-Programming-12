package com.milad.M2;

import java.util.Comparator;

public class CustomComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.id > o2.id){
            return 1;
        } else if (o1.id < o2.id){
            return -1;
        } else{
            return 0;
        }
    }
}
