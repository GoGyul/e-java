public class Test01 {
    public static void main(String[] args) {
        /*
        * 중요한건 인스턴스를 생성할때(Restaurant restaurant = new Restaurant(객체))
        * 생성자에 필요한 자원을 넘겨주는 방식이 의존성 주입인것이다.
        * */
     Restaurant hamRes = new Restaurant(new Hamburger());
     Restaurant chRes = new Restaurant(new Chicken());
     hamRes.menu();
     chRes.menu();
    }
}

class Restaurant {
    private final RestaurantInformation ri;

    public Restaurant(RestaurantInformation ri) {
        this.ri = ri;
    }

    public void menu() {
        ri.menu();
    }

}


class Hamburger implements RestaurantInformation{
    @Override
    public void menu(){
        System.out.println("햄버거집 메뉴");
    }
}

class Chicken implements RestaurantInformation{
    @Override
    public void menu(){
        System.out.println("치킨집 메뉴");
    }
}

interface RestaurantInformation{
    public void menu();
}
