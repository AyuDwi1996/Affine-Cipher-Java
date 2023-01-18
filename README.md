# About Affine-Cipher
Affine cipher is a monoalphabetic substitution cipher.
- Encryption is done as, E ( x ) = ( a x + b ) mod m 
  modulus m: size of the alphabet
  a and b: key of the cipher.
  a and m need to be coprime
- Decryption is done as,
  D ( x ) = a^-1 ( x - b ) mod m
  a^-1 : modular multiplicative inverse of a modulo m

- This is a generalized code where you can give alphabets of any language using input file and it will perform encryption and decryption in that language

📢📢 You can see the output for Hindi Language,below 📢📢

<img align="center" alt="GIF" src="https://github.com/AyuDwi1996/Affine-Cipher-Java/blob/main/finaloutput.PNG" width="500" height="100" />

# Steps to execute the program for Affine Cipher General:
- Please save the alphabets of any language in file named as input.txt. This [file](https://github.com/AyuDwi1996/Affine-Cipher-Java/blob/main/input.txt) is input for this program
- Please save plain text in a file having alphabets from same language as input file. This [file](https://github.com/AyuDwi1996/Affine-Cipher-Java/blob/main/plaintext.txt) is also an input to this program and it's name should be plaintext.txt
- Enter the value of variable "a" and variable "b" from console
- You can see the output of encryption and decryption in output.txt [file](https://github.com/AyuDwi1996/Affine-Cipher-Java/blob/main/output.txt). This file will get generated in "C:\Program Files\Java\jdk-18.0.2.1\bin" location of your system

NOTE: Please execute the program from "C:\Program Files\Java\jdk-18.0.2.1\bin" location of your system. Also save the input.txt file and plaintext.txt file in the same location.
