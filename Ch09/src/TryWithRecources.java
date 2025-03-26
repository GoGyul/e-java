import java.io.*;

public class TryWithRecources {

    // try - finall 로 쓰인 코드
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            return br.readLine();
        }finally {
            br.close();
        }
    }

    // try - finall 로 쓰인 코드
    static void copy(String src , String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try{
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }finally {
                out.close();
            }
        }finally {
            in.close();
        }
    }

    /*
     * 꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고 try-with-resources를 사용하자.
     * 예외는 없다. 코드는 더 짧고 분명해지고, 만들어지는 예외 정보도 훨씬 유용하다.
     * try-finally로 작성하면 실용적이지 못할만클 코드가 지저분해지는 경우라도 try-with-resources 로는 정확하고 쉽게 자원을 회수할수 있다.
     * */

    //try-with-resources로 재작성된 코드
    static String firstLineOfFileResources(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    //try-with-resources로 재작성된 코드
    static void copyResource(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)){
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
        }
    }

}
