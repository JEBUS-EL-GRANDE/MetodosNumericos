public class cSecante {
    private double xiP1;//xi+1
    private double xiN1;//xi-1
    private double xi;
    private double Ea;
    
    public cSecante(){
        xiP1 = 0.0;
        xiN1 = 0.0;
        xi = 0.0;
        Ea = 100.0;
    }
    
    public void Intervalo(double xiN1, double xi){
        this.xiN1 = xiN1;
        this.xi = xi;    
    }
    
    public double funcion(double x){
        //return 8*Math.asin(x)*Math.pow(2.718281828,-x)-1;
        return (2*Math.pow(x,3))-(11.7*Math.pow(x,2))+(17.7*x)-(5);
    }   
    
    public void secante(int n){
        int i = 1;
        double xiP1Ant = 0.0;        
        System.out.println("itera\t xi+1 \t\t F(xi+1) \t xi-1 \t\t f(xi-1) \t xi \t\t f(xi) \t\t Ea(%)");
        System.out.println("----------------------------------------------------------------------------------------------------------------");        
        
        while(i <= n){            
            xiP1 = xi - (funcion(xi)*(xiN1 - xi)) / (funcion(xiN1)-funcion(xi));
            
            double fxiP1 = funcion(xiP1 );
            double fxiN1 = funcion(xiN1 );
            double fxi = funcion(xi);
            
            if(i > 1)
                Ea = Math.abs((xiP1-xiP1Ant)/xiP1)*100;
                System.out.print(i + "   ");
                System.out.printf("%12.8f\t", xiP1);
                System.out.printf("%12.8f\t", fxiP1);
                System.out.printf("%12.8f\t", xiN1);
                System.out.printf("%12.8f\t", fxiN1);
                System.out.printf("%12.8f\t", xi);
                System.out.printf("%12.8f\t", fxi);
                System.out.printf("%7.3f\n", Ea);
                        
            xiN1 = xi;
            xi = xiP1;
            
            xiP1Ant = xiP1;            
            i++;
        }                
    }
}
