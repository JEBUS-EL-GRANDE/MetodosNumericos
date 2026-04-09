public class main {
    public static void main(String[] args) {
        cGaussSimple E = new cGaussSimple ();
        
        E.setDim(3, 4);
        E.eliminacionGauss();
        System.out.println("Las raices son: " + E.getRaices());
    }
}