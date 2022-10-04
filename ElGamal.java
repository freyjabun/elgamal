
public class ElGamal {

    static int g = 666; //shared base
    static int p = 6661; //shared prime
    static int bobPK = 2227; //gx
    static int m = 2000;     //m


    public static int sexypow(int x, int y){
        int res = 1;
        for(int i = 0; i<y; i++){
            res = res * x % p;
        }
        return res;
    }

    public static void main(String[] args) {

        //Assignment 1
        System.out.println("Assignment 1\n");
        int y = (int) (Math.random() * (p-2) + 1); 

        int gy = g;
        int gxy = bobPK;

        for(int i = 0; i<y; i++){
            gy = gy * g % p;  
            gxy = gxy * bobPK % p;
        } //Compute gy & gxy

        int c = gxy * m; //ciphertext hehe

 

        //Encrypted message
        System.out.println("Encrypted Message: "+ gy + " " + c + "\n");

        int decryptTest = c / gxy;
        System.out.println("Decrypted message for testing purposes: " + decryptTest + "\n");
        

        //Assignment 2
        System.out.println("Assignment 2\n");
        int eveY = 0;
        for(int i = 0; i<p; i++){
            if (sexypow(g, i) == bobPK){
                eveY = i;
                break;
            }
        }
        int decrypt = c / sexypow(gy, eveY);
        // if (sexypow(g, 66) == bobPK) System.out.println("stort\n");
        System.out.println("Bob's private key is: " + eveY + "\n");
        System.out.println("The decrypted message is " + "\"" + decrypt + "\"\n");

        //Assignment 3
        System.out.println("Assignment 3\n");
        int mallory = c * 3;
        int decrypt2 = mallory / sexypow(gy, eveY);
        //above is for the purpose of showing that Bob would decrypt the message
        //to be 6000, mallory does not know the private key in this case.
        System.out.println("Bob's decrypted message " + "\"" + decrypt2 + "\"" + "\n");
    }
}