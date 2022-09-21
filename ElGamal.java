
public class ElGamal {

    int g = 666; //shared base
    int p = 6661; //shared prime
    int bobPK = 2227;

    int y = (int) Math.random() + (p-1) + 1;

    int gy = (int) Math.pow(g,y);

    public static void main(String[] args) {
        System.out.println("skrrt");
    }
}