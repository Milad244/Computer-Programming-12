import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();

        // Initial 28 pennies
        for (int i = 0; i < 28; i++){
            coins.add(1);
        }
        System.out.println(coins);

        // Replacing every second coin with a nickel
        int nickelInterval = 2;
        int lastNickel = -1;
        for (int i = 0; i < coins.size(); i++){
            if (i == (lastNickel + nickelInterval)){
                coins.set(i, 5);
                lastNickel = i;
            }
        }
        System.out.println(coins);

        // Replacing every third coin with a dime
        int dimeInterval = 3;
        int lastDime = -1;
        for (int i = 0; i < coins.size(); i++){
            if (i == (lastDime + dimeInterval)){
                coins.set(i, 10);
                lastDime = i;
            }
        }
        System.out.println(coins);

        // Replacing every fourth coin with a quarter
        int quarterInterval = 4;
        int lastQuarter = -1;
        for (int i = 0; i < coins.size(); i++){
            if (i == (lastQuarter + quarterInterval)){
                coins.set(i, 25);
                lastQuarter = i;
            }
        }
        System.out.println(coins);

        // Getting total value of coins
        int totalValue = 0;
        for (int v : coins){
            totalValue += v;
        }
        System.out.println("The total value is " + totalValue + " cents.");
    }
}
