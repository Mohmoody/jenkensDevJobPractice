import io.restassured.response.Response;

import java.io.OutputStream;

public class PolindromePrograme {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-222));
    }
    public static boolean isPalindrome(int num){


        if(num<0){
          num *= -1;
        }
        int stored=num;
        int reverse=0;
        int lastdigit;
        while (stored>0){
            lastdigit=stored%10;
            reverse=(reverse*10) + lastdigit;
            stored/=10;
        }
        if(reverse==num){
            return true;
        }else {
            return false;
        }
    }
}
