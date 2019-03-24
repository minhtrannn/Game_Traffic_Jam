import java.util.Random;
import java.util.Scanner;

public class Main {
    Random rd = new Random();
    public static void main(String[] args)
    {
        String s;
        int n = 17;
        String [] a = new String [n];
        Scanner in = new Scanner(System.in);
        for (int i = 1; i < n; i++) {
            a[i] ="-";
            a[6] = "P";
            a[11] = "B";
            a[15] = "S";
            System.out.print(a[i]+" ");
            if(i%4==0)
            {
                System.out.println();
            }
        }
        System.out.println("Your next move ?");
        s = in.nextLine();
        if(s == "A")
        {
            a[5] = "P";
            a[6] = "-";
//            for(int i=1 ; i<17 ;i++)
//            {
//                if(a[i] =="P"&& i-1> 1)
//                {
//                    a[i-1] = "P";
//                    a[i] ="-";
//                }
//            }
        }
//        else if(s == "W")
//        {
//            for(int i=1 ; i<17 ;i++)
//            {
//                if(a[i] =="P" && i+3 <=11)
//                {
//                    a[i+3] = "P";
//                    a[i] ="-";
//                }
//            }
//        }
//        else if(s== "D")
//        {
//            for(int i=1 ; i<17 ;i++)
//            {
//                if(a[i] =="P"&& i+1<17)
//                {
//                    a[i+1] = "P";
//                    a[i] ="-";
//                }
//            }
//        }
//        else if(s == "S")
//        {
//            for(int i=1 ; i<17 ;i++)
//            {
//                if(a[i] =="P"  && i-3>0)
//                {
//                    a[i-3] = "P";
//                    a[i] ="-";
//                }
//            }
//        }
        for(int i=1 ;i<n;i++)
        {
            System.out.print(a[i] + " ");
            if(i%4==0)
            {
                System.out.println();
            }
        }
    }
}
