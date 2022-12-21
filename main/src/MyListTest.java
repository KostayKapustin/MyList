import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class MyListTest {

    MyList<Double> myListDouble = new MyList<>();
    MyList<String> myListString = new MyList<>();
    Random r = new Random();

    @BeforeEach
    void preparationPreliminaryData() {
        int i = 20;
        String eng = "abcdefghijklmnopqrstuvwxyz";
        while (myListDouble.size() <= i) {
            double k = Math.random();
            myListDouble.add(k);
            String sum = eng + eng.toUpperCase();
            char c = sum.charAt(r.nextInt(sum.length()));
            myListString.add(c);
        }
    }

    @AfterEach
    void clearData() {
        myListString.create();
        myListDouble.create();
    }

    @Test
    void addMyList() {
        Assertions.assertEquals(myListDouble.size(), 21);
        Assertions.assertEquals(myListString.size(), 21);
    }

    @Test
    void createMyList() {
        myListString.create();
        myListDouble.create();
        Assertions.assertEquals(myListDouble.size(), 0);
        Assertions.assertEquals(myListString.size(), 0);
    }

    @Test
    void removeMyList() {
        myListDouble.remove(2);
        Assertions.assertEquals(myListDouble.size(), 20);
    }

    @Test
    void quickSort() {
        myListString.create();
        myListDouble.create();
        myListDouble.add(0.6);
        myListDouble.add(1.5);
        myListDouble.add(19.4);
        myListDouble.add(0.1);
        myListDouble.add(2.9);
        myListString.add("c");
        myListString.add("a");
        myListString.add("w");
        myListString.add("b");
        myListString.add("o");
        myListString.quickSort(myListString);
        myListDouble.quickSort(myListDouble);
        Assertions.assertEquals(myListDouble.toString(),"MyList{array=[0.1, 0.6, 1.5, 2.9, 19.4]}");
        Assertions.assertEquals(myListString.toString(),"MyList{array=[a, b, c, o, w]}");
    }
}