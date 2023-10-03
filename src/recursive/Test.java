package recursive;

public class Test {
public static void main(String[] args) {
    int n = 10;
    System.out.println("Giai thừa của "+n+" là:" + giaiThua(n));

}
public static int giaiThua(int n){
    if(n==0){
        return 1;
    }
    else
        return n*giaiThua(n-1);
}

}
