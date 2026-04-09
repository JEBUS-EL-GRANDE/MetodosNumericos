public class cGaussSimple {
    public static final int MAX=10;
    private double M[][]={   {3, -0.1,-0.2,7.85}
                            ,{0.1, 7, -0.3, -19.3}
                            ,{0.3, -0.2, 10, 71.4} };
    private double V[];
    private int filas;
    private int cols;
    public cGaussSimple () {
        V = new double[MAX+1];
        filas = -1;
        cols = -1;
    }
    public void setDim(int f, int c){
        filas = f;
        cols = c;
    }

    public void productoFactor(int fila, double factor,int fila2){
        for (int i = 0; i < cols; i++) {
            M[fila][i]=M[fila][i]-M[fila2][i]*factor;
        }
    }
    public void eliminacionGauss(){
        for(int i=0; i<=filas-2;i++){            
            for(int j=i+1;j<=filas-1;j++){
                double factor = M[j][i]/M[i][i];
                        productoFactor(j, factor,i);
            }                
        }
        V[filas-1]=M[filas-1][cols-1]/M[filas-1][cols-2];
        double ac;
        for (int i=filas-2;i>=0;i--){
            ac=0;
            for(int k=cols-2;k>=0;k--)
                ac+=M[i][k]*V[k];
            ac=-1*ac;
            ac = ac+M[i][cols-1];
            V[i]=ac/M[i][i];
        }
    }
    public String getRaices(){
        return "\nX1= "+V[0]+"\nX2= "+V[1]+"\nX3= "+V[2];
        

    }
}