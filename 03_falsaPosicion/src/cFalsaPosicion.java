public class cFalsaPosicion {
    private double xl;
    private double xu;
    private double xr;
    private double Ea;
    public cFalsaPosicion(){
        xl=0.0;
        xu=0.0;
        xr=0.0;
        Ea=100.0;
    }
    public void cFalsaPosicion(double xl, double xu){
        this.xl=xl;
        this.xu=xu;
    }
    public double funcion(double x){
    return (-0.6*Math.pow(x,2))+(2.4*x)+(5.5);
    }
    public void FalsaPosicion(double n){
    int i=1;
        double xrAnt=0.0;        
        System.out.println("itera \t xl \t\t f(xl)\t\t xu \t\t f(xu)\t\t xr \t\t f(xr) \t\t Ea(%)");
        System.out.println("----------------------------------------------------------------------------------------------------------");        
        while((i<=n)){            
            xr = xu- (funcion(xu)*(xl - xu)) / (funcion(xl)-funcion(xu));
            
            double fxl = funcion(xl);
            double fxu = funcion(xu);
            double fxr = funcion(xr);
            if(i>1)
                Ea = Math.abs((xr-xrAnt)/xr)*100;
                System.out.print(i+"   ");
                System.out.printf("%13.8f\t",xl);
                System.out.printf("%12.8f\t", fxl);
                System.out.printf("%10.8f\t",xu);
                System.out.printf("%12.8f\t", fxu);
                System.out.printf("%10.8f\t",xr);
                System.out.printf("%12.8f\t", fxr);
                System.out.printf("%7.2f\n",Ea);
                        
            if(funcion(xl)*funcion(xr)<0)
                xu = xr;
            else
                xl = xr;
            xrAnt = xr;            
            i++;
        }                
    }
}