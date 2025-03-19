import nomalClass.Car;
import test01.HelloFactory;
import test01.HelloService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("BMW", "Red"  );
        Car car2 = Car.of("Hyndai", "Blue");

        ArrayList<Car> list = new ArrayList<>();
        list.add(car);
        list.add(car2);

        // 리스트 출력 확인
        for (Car c : list) {
            System.out.println(c.getColor());
        }

        HelloService hello = HelloFactory.of("ko");
        System.out.println(hello.sayHello());

    }
}