
public class ElGamal {

    public static void main(String[] args) {

        //Assignment 1
            
        int g = 666; //shared base
        int p = 6661; //shared prime
        int bobPK = 2227;

        int sk = (int) (Math.random() * (p-2) + 1); //Desired max and min values are -2

        int gy = g;
        int gxy = bobPK;

        for(int i = 0; i<sk; i++){
            gy = gy * g % p;  
            gxy = gxy * bobPK % p;
        } //Compute gy & gxy

        int c = gxy * 2000;

        //Encrypted message
        System.out.println("Encrypted Message: "+ c);

        //Assignment 2
        



    }
}