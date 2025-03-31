import java.util.Objects;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }


    /*
    *   대칭성을 위반한 equals
    */
//    @Override
//    public boolean equals(Object o) {
//        if( o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(
//                    ((CaseInsensitiveString) o).s
//            );
//        }
//        if(o instanceof String) { // 한 방향으로만 작동한다.
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
//    }

    // 대칭성을 위반하지 않는 equals
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o ).s.equalsIgnoreCase(s);
    }

}
