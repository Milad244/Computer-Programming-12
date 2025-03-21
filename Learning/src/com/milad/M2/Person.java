package com.milad.M2;

public class Person implements Comparable<Person>{

    private int age;
    public int id;
    private String name;

    Person(int age, int id, String name){
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person other = (Person) obj;
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Age: " + age + "\tId: " + id;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        } else if (this.age < o.age){
            return -1;
        } else{
            return 0;
        }
    }
}
