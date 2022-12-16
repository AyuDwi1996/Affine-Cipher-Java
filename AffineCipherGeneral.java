import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
class AffineCipherGeneral{

    public static void main(String args[])  throws IOException{
    
    //For reading the file having alphabets of any language
    FileReader fileInput = new FileReader("input.txt");
    BufferedReader bIn = new BufferedReader(fileInput);

    //For reading the file having plain text
    FileReader fileInput2 = new FileReader("plaintext.txt");
    BufferedReader bIn2 = new BufferedReader(fileInput2);

    //File for storing the output of encryption first and then decryption
    FileWriter fileOutput = new FileWriter("output.txt");
    BufferedWriter bOut = new BufferedWriter(fileOutput);

    //String variable for storing file content read for variable bIn
    String readInput = bIn.readLine();

    //String for storing all alphabets mentioned in the input file
    String alphabets = " ";
    alphabets = alphabets + readInput;
    while((readInput = bIn.readLine() )!= null){
        alphabets = alphabets + readInput;
    }

    
    alphabets = alphabets.trim();//to remove spaces
    alphabets = alphabets.toLowerCase();//since I will be dealing with lower case text

    int count = 0;
    count = alphabets.length();//to count total alphabets in input file

    Scanner S = new Scanner(System.in);
    //affine cipher C = (aP + b) mod count
    //input for a and b
    System.out.println("Please enter value for variable a in affine cipher: ");
    int a = S.nextInt();
    
    //0<=a<count and a should not have common factor with count
    int f = 1;
    while(f == 1){
        for(int y=2;y<=(count/2);y++){
            //y is common factor of count if below condition holds
            if( (count % y == 0 && a % y == 0) || (a<0 || a>=count) ){
                    System.out.println("a is invalid because it has either common factor with "+count + " or out of range");
                    System.out.println("Please re enter value for variable a in affine cipher: ");
                    a = S.nextInt();
                    f = 1;
                    break;
            }else{
                f = 0;
            }
        }
    }
    
    System.out.println("Please enter value for variable b in affine cipher: ");
    int b = S.nextInt();
    // b should be between 0 and (count-1)
    while((b<0 || b>=count)){
        System.out.println("b is invalid because it is out of range");
        System.out.println("Please re enter value for variable b in affine cipher: ");
        b = S.nextInt();
    }
    
    //String for storing plain text coming from input file for variable bIn2
    String readInput2 = bIn2.readLine();
    String Plaintext = " ";
    Plaintext = Plaintext + readInput2;
    while((readInput2 = bIn2.readLine() )!= null){
    Plaintext = Plaintext + readInput2;
    }

    //Hash Map for storing integer value for each alphabet in the language passed through input file
    LinkedHashMap<Character,Integer> intValueForText=new LinkedHashMap<Character,Integer>();
    for(int i=0;i<count;i++){
        intValueForText.put(Character.valueOf(alphabets.charAt(i)), Integer.valueOf(i));
    }
    
   
    //Hash Map for storing each character values to integer in the language passed through input file
    LinkedHashMap<Integer,Character> textValueForInt=new LinkedHashMap<Integer,Character>();
    for(int i=0;i<count;i++){
        textValueForInt.put(Integer.valueOf(i),Character.valueOf(alphabets.charAt(i)));
    }
   
    //Encryption using affine cipher
    String CipherText = "";
    Plaintext = Plaintext.toLowerCase();
    for(int j=0;j<Plaintext.length();j++){
        if(Plaintext.charAt(j) != ' '){
            char temp1 = Plaintext.charAt(j);
            int temp2 = (a*(intValueForText.get(Character.valueOf(temp1))) + b ) % count;
            CipherText = CipherText + textValueForInt.get(Integer.valueOf(temp2));

        }else{
            CipherText = CipherText + ' '; 
        }
    }
    
    bOut.write("Encryption of PlainText "+Plaintext+" is :"+CipherText);
    bOut.write("\n");

    //Decryption using affine cipher
    //P = a^-1(C-b) mod count, here a^-1 is a inverse with mod count
    String plain = " ";
    int a_inverse = 0;
    int remainder = 0;
    CipherText = CipherText.toLowerCase();
    //to find a inverse, check all integers from 0 to count-1 and you find a inverse where (integer*a) mod (count-1) =1
    for(int x=0;x<count;x++){
        remainder = (a*x) % count;
        if(remainder == 1){
            a_inverse = x;
            break;
        } 
    }
    //P = a^-1(C-b) mod count
    for(int k=0;k<CipherText.length();k++){
        if(CipherText.charAt(k) != ' '){
            char temp1 = CipherText.charAt(k);
            int temp2 = (a_inverse*(intValueForText.get(Character.valueOf(temp1)) + (count-b) )) % count;
            plain = plain + textValueForInt.get(Integer.valueOf(temp2));

        }else{
            plain = plain+' '; 
        }
    }

    bOut.write("Decryption of CipherText "+CipherText+" is :"+plain);
    System.out.println("Encryption and Decryption is done. Please check the ouput file in your system!");
    bOut.flush();
    bOut.close();

    }
}