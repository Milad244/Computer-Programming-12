import java.util.List;
import java.nio.charset.Charset;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            personList.add(new Person((int) (Math.random() * 16 + 1), i, "paul"));
        }


        Iterator<Person> iterator = personList.iterator();

        System.out.println("Looping through PersonList using iterator");
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }


        LinkedList<Person> personList2 = new LinkedList<>(personList);

        System.out.println("Showing link list functionality");
        System.out.println(personList2.peekFirst());
        System.out.println(personList2.peekLast());
        Person p = personList2.pollFirst(); // not only gets value but also remove it from list
        System.out.println(p);
        System.out.println(personList2.peekFirst());
        System.out.println(personList2.peekLast());


        System.out.println("Sorting using comparable");
        Collections.sort(personList);
        for (Person p : personList){
            System.out.println(p);
        }

        System.out.println("Sorting using custom comparator");
        CustomComparator c = new CustomComparator();
        Collections.sort(personList, c);
        for (Person p : personList){
            System.out.println(p);
        }


        System.out.println("HashSet does not preserve order");
        HashSet<Car> cars = new HashSet<>();
        for (int i = 0; i < 10; i++){
            cars.add(new Car("id-" + i, (int)(Math.random() * 30 + 1)));
        }

        for (Car c : cars){
            System.out.println(c);
        }

        System.out.println(cars.add(new Car("id-5", 100)));
        System.out.println(cars.add(new Car("id-11", 100)));

        System.out.println("LinkedHashSet preserves order");
        LinkedHashSet<Car> cars2 = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++){
            cars2.add(new Car("id-" + i, (int)(Math.random() * 300 + 1)));
        }

        for (Car c : cars2){
            System.out.println(c);
        }

        System.out.println("TreeSet gives custom order");
        TreeSet<Car> cars3 = new TreeSet<>(new CompareByPrice());
        for (int i = 0; i < 10; i++){
            cars3.add(new Car("id-" + i, (int)(Math.random() * 300 + 1)));
        }

        for (Car c : cars3){
            System.out.println(c);
        }

        Car minPriceCar = new Car("id", 100);
        Car maxPriceCar = new Car("id", 150);

        System.out.println("Headset");
        Iterator<Car> expensiveCars = cars3.headSet(minPriceCar).iterator();

        while(expensiveCars.hasNext()){
            System.out.println(expensiveCars.next());
        }

        System.out.println("Headset and tailset");
        Iterator<Car> normalCars = cars3.headSet(minPriceCar).tailSet(maxPriceCar).iterator();

        while(normalCars.hasNext()){
            System.out.println(normalCars.next());
        }


        System.out.println("HashMap");
        HashMap<Car, Owner> carMap = new HashMap<>();

        for (int i = 0; i < 10; i++){
            byte[] array = new byte[4];
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            carMap.put(new Car("id-" + i, (int) (Math.random() * 1000 + 1)), new Owner(generatedString));
        }
        Iterator<Car> carIterator = carMap.keySet().iterator();

        while(carIterator.hasNext()){
            Car c = carIterator.next();
            System.out.println("Car " + c + "\tOwner " + carMap.get(c));
        }


        System.out.println("TreeMap");
        TreeMap<Car, Owner> carMap = new TreeMap<>();

        for (int i = 0; i < 10; i++){
            byte[] array = new byte[4];
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            carMap.put(new Car("id-" + i, (int) (Math.random() * 1000 + 1)), new Owner(generatedString));
        }
        Iterator<Car> carIterator = carMap.keySet().iterator();

        while(carIterator.hasNext()){
            Car c = carIterator.next();
            System.out.println("Car " + c + "\tOwner " + carMap.get(c));
        }

        System.out.println("Headset map");
        Car maxPriceCar = new Car("id", 500);
        Iterator<Car> cheapCars = carMap.headMap(maxPriceCar).keySet().iterator();
        while(cheapCars.hasNext()){
            Car c = cheapCars.next();
            System.out.println("Car " + c + "\tOwner " + carMap.get(c));
        }
        */
    }
}