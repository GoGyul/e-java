package singleTon;

public class John {

    private static final John INSTANCE = new John();
    private John() {}
    public static John getInstance() {return INSTANCE;}

}
