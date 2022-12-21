import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс реализует свой ArrayList
 * @author Капустин Константин Юрьевич
 * @param <T>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyList<T> {

    /** Поле array массив */
    Object[] array = new Object[0];
    /** Поле index */
    int index = 0;

    /**
     * @param t - производитель.
     * Сохраняет значение в массиве.
     */
    public void add(Object t) {
        if (array.length == index) {
            Object[] newArray = new Object[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[index++] = t;
    }

    /**
     * @return возвращает длину листа.
     */
    public int size() {
        return index;
    }

    /**
     * @param postIndex - число меньше на 1 от длины массива.
     * Удаляет значение из массива
     */
    public void remove(int postIndex) {
        int count = 0;
        Object[] newArray = new Object[array.length - 1];
        for (int i = 0; i < index; i++) {
            if (postIndex != i) {
                newArray[count] = array[i];
                count++;
            }
        }
        array = newArray;
        index--;
    }

    /**
     * @return возвращает массив
     */
    public T[] toArray() {
        return (T[]) array;
    }

    /**
     * Удаляет все значения из массива
     */
    public void create() {
        array = new Object[0];
        index = 0;
    }

    /**
     * @param myList - лист пользователя.
     * @param comparator - компаратор.
     * Вспомогательный метод quickSort, в котором получаем массив из листа и задаем начальные значения для сортировки
     */
    private static <E> void quickSort(MyList<E> myList, Comparator<? super E> comparator) {
        E[] myArray = myList.toArray();
        int low = 0;
        int high = myList.size() - 1;
        quickSort(myArray, low, high, comparator);
    }

    /**
     * @param myArray - массив пользователя.
     * @param comparator - компаратор.
     * @param low - начало проверки чисел.
     * @param high - длина - 1.
     * Основной метод, который производит сортировку любого объекта
     */
    private static <E> void quickSort(E[] myArray, int low, int high, Comparator<? super E> comparator) {
        int middle = low + (high - low) / 2;
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(myArray[i], myArray[middle]) < 0) {
                i++;
            }
            while (comparator.compare(myArray[j], myArray[middle]) > 0) {
                j--;
            }
            if (i <= j) {
                E temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(myArray, low, j, comparator);

        if (high > i)
            quickSort(myArray, i, high, comparator);
    }

    /**
     * @param myList - лист пользователя.
     * Вспомогательный метод quickSort, который передает лист и компаратор
     */
    public static <E extends Comparable<E>> void quickSort(MyList<E> myList) {
        quickSort(myList, Comparator.naturalOrder());
    }

    /**
     * @return возвращает описание класса
     */
    @Override
    public String toString() {
        return "MyList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}

