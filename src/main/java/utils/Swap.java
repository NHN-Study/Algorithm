package utils;

/**
 * 설명작성란
 *
 * @author : 유호철
 * @since 1.0
 */
public class Swap {
    private Swap() {}

    public static <T> void swap(T[] a,int e1,int  e2){
        T temp = a[e1];
        a[e1] = a[e2];
        a[e2] = temp;
    }
}
