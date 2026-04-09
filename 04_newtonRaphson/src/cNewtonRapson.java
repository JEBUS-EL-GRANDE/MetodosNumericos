public class cNewtonRapson {
    private double xi;
    private double Ea;
    public cNewtonRapson(){
        xi = 0.0;
        Ea = 100.0;
    }
    public void Intervalo(double xi){
        this.xi = xi;
    }
    
    public double funcion(double x){
        return (3*x)+(Math.asin(x))-(Math.exp(x));
    }   
    public double derivada(double x){
        return (3)+(Math.acos(x)) -(Math.exp(x));
    }
    
    public void newtonRaphson(int n){
        int i = 1;
        double xiAnt = 0.0;        
        System.out.println("itera\t xi \t\tf(xi) \t\t f'(xi) \t Ea(%)");
        System.out.println("-------------------------------------------------------------------");        
        
        while(i <= n){            
            xi = xi - (funcion(xi) / derivada(xi));
            double fxi = funcion(xi);
            double fxii = derivada(xi);
            
            if(i > 1)
                Ea = Math.abs((xi - xiAnt) / xi) * 100;
                System.out.print(i + "   ");
                System.out.printf("%12.8f\t", xi);
                System.out.printf("%12.8f\t", fxi);
                System.out.printf("%12.8f\t", fxii);
                System.out.printf("%7.3f\n", Ea);
            
                xiAnt = xi;            
                i++;
        }                
    }
}
