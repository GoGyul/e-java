import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // keySet()을 두 번 호출하여 두 개의 Set 객체를 얻음
        Set<String> keySet1 = map.keySet();
        Set<String> keySet2 = map.keySet();

        // keySet1과 keySet2가 동일한 객체인지 확인
        System.out.println("keySet1 == keySet2: " + (keySet1 == keySet2)); // true

        // keySet1을 통해 요소 제거 (map과 keySet2에 영향을 줌)
        keySet1.remove("A");
        System.out.println("map after removing 'A' via keySet1: " + map);
        System.out.println("keySet2 after modifying keySet1: " + keySet2);
    }
}
