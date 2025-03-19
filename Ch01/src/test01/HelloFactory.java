package test01;

public class HelloFactory {
    public static HelloService of(String value) {
        if (value.equals("ko")) {
            return new KoreanHelloService();
        }else if (value.equals("en")) {
            return new EngHelloService();
        }else{
            throw  new IllegalArgumentException("지원하지 않는 언어");
        }
    }
}
