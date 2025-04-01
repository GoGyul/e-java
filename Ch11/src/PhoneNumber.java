public final class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode,999,"지역코드");
        this.prefix = rangeCheck(prefix,999,"프리픽스");
        this.lineNum = rangeCheck(lineNum,9999,"가입자 번호");
    }

    private static short rangeCheck(int val,int max,String msg) {

        if(val < 0 || val > max) {
            throw new IllegalArgumentException(msg);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    // 최악의 hashCode 구현 - 사용금지
    // @Override
    // public int hashCode() { return 42; }


    /*
    🔹 왜 hashCode()를 직접 정의해야 할까?
자바의 HashMap, HashSet 같은 컬렉션은 해시값을 사용하여 객체를 빠르게 찾기 위해 hashCode()를 사용합니다.

하지만 hashCode()를 구현하지 않으면, 기본적으로 Object의 hashCode()가 사용되는데, 이는 객체의 메모리 주소 기반으로 해시값을 계산합니다.
👉 즉, 같은 값이라도 새로운 객체를 만들면 다른 해시값을 가지게 되므로, 같은 키로 인식되지 않습니다.
그래서 equals()가 같은 두 객체는 반드시 같은 hashCode() 값을 가져야 합니다.

🔹 왜 31 * result + 값 같은 계산식을 쓰는가?
우리가 hashCode()를 정의할 때, 단순히 세 값을 더하는 방식(areaCode + prefix + lineNum)은 **충돌(collision)**이 많이 발생할 수 있습니다.
그래서 좋은 해시 함수를 만들기 위해 아래 원칙을 따릅니다.

✅ 1. 같은 값이면 같은 해시값을 가져야 한다.
예를 들어,

PhoneNumber p1 = new PhoneNumber(123, 456, 789);
PhoneNumber p2 = new PhoneNumber(123, 456, 789);
p1.equals(p2) == true일 때,
p1.hashCode() == p2.hashCode()가 되어야 합니다.

이를 보장하기 위해 hashCode()는 객체의 모든 중요한 필드 값을 반영해야 합니다.

✅ 2. 해시 충돌을 줄이기 위해 31을 사용한다.
@Override
public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
}
여기서 31 * result + 값 방식은 충돌을 줄이고 고유한 해시값을 생성하는 데 효과적입니다.

🔹 왜 31인가?
소수(Prime Number)이기 때문
소수를 사용하면 해시값의 분포가 고르게 퍼지고, 해시 충돌이 줄어듭니다.
2, 3, 5 같은 작은 소수도 가능하지만, 31이 성능과 충돌 방지 면에서 적절한 숫자로 연구되었습니다.
비트 연산에 최적화됨
31 * x는 x << 5 - x (즉, 2^5 - 1) 로 변환될 수 있어 빠르게 계산할 수 있습니다.

✅ 3. 모든 필드를 반영하여 해시값을 계산해야 한다.
PhoneNumber의 주요 필드는 areaCode, prefix, lineNum이므로, 이 값을 조합하여 해시값을 만듭니다.
만약 한두 개만 포함하면 충돌이 증가할 수 있습니다.

🔹 결론
✔ 같은 값을 가진 객체는 같은 해시값을 가져야 한다.
✔ 소수를 곱하는 방식(31 * result + 값)은 해시 충돌을 줄이는 데 효과적이다.
✔ 모든 주요 필드를 포함해야 한다.

    **/

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

}
