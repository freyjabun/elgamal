
public class ElGamal {

    static int g = 666; 
    static int p = 6661; 
    static int bobPK = 2227; 
    static int m = 2000;     


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
        }

        int c = gxy * m;

 

        //Encrypted message
        System.out.printf("Encrypted Message: %d %d \n\n", gy, c);

        int decryptTest = c / gxy;
        System.out.printf("Decrypted message for testing purposes: %d\n\n", decryptTest);
        

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
        System.out.printf("Bob's private key is: %d\n\n", eveY);
        System.out.printf("The decrypted message is \"%d\"\n\n", decrypt);

        //Assignment 3
        System.out.println("Assignment 3\n");
        int mallory = c * 3;
        int decrypt2 = mallory / sexypow(gy, eveY);
        //above is for the purpose of showing that Bob would decrypt the message
        //to be 6000, mallory does not know the private key in this case.
        System.out.printf("Bob's decrypted message is: \"%d\"\n\n", decrypt2);
    }
}