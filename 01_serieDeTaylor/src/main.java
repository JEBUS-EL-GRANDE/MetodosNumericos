import java.util.Scanner;
public class main {
    public static double factorial(int n){
        double aux=1;
        for(int i=2;i<=n;i++){
            aux *=i;
        }
        return aux;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //metodo de taylor para la funcion f(x)= e
        // x^0/0! + x^1/1! + x^2/2! + x^n/n! + 
        
        System.out.print("Cuantos terminos desea:");
        int n=sc.nextInt();
        System.out.print("Ingrese el valor de x:");
        int x =sc.nextInt();
        
        double s=0,t;
        for(int i=0;i<n; i++){
            t=Math.pow(x,i)/ factorial(i);
            s +=t;
        }
        
        System.out.printf("f(%d)=%f\n",x,s);
    }   
}