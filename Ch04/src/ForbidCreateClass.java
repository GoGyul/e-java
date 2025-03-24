public class ForbidCreateClass {
    //기본 생성자가 만들어지는 것을 막는다 (인스턴스 방지용)
    private ForbidCreateClass() {
        throw new AssertionError();
    }

}
