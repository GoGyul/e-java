import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push (Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop () {
        /*
        * 메모리 누수가 발생하는 라인과 코드
        * */
//        if(size ==0) throw new EmptyStackException();
//        return elements[--size];

        /*
        * 참조 해제가 된 제대로 구현된 코드
        * */
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /*
    * 원소를 위한 공간을 적어도 하나이상 확보한다.
    * 배열 크기를 늘려야 할 때마다 대략 두배씩 확보한다
    * */
    public void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }

}
