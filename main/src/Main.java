import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyList<Double> myListDouble = new MyList<>();
        MyList<String> myListString = new MyList<>();
        Random r = new Random();
        int i = 20;

        while (myListDouble.size() <= i) {
            double k = Math.random();
            myListDouble.add(k);
        }
        String eng = "abcdefghijklmnopqrstuvwxyz";
        while (myListString.size() <= i) {
            String sum = eng + eng.toUpperCase();
            char c = sum.charAt(r.nextInt(sum.length()));
            myListString.add(c);
        }
        System.out.println(myListDouble.toString());
        myListDouble.create();
        System.out.println(myListDouble.size());
        System.out.println(myListString.toString());
        myListString.quickSort(myListString);
        System.out.println(myListString.toString());
    }
}
