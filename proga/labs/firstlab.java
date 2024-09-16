import java.text.DecimalFormat;

public class firstlab {
    public static double matrix(short a, float b){
        return switch(a){
            case 10 -> Math.pow(Math.log(Math.acos((b + 1.5) / 19)) / (Math.pow(Math.E, Math.pow(Math.E, b)) + 1), 3);
            case 6, 8, 12 -> (1 - Math.pow(1 - Math.tan(b), 3)) / 4;
            default -> 2 * Math.asin(Math.pow(Math.E, Math.cbrt(-Math.pow(Math.tan(b), 2))));
        };
    }
    public static void print_matrix(double[][] matrix){
        for(int i = 0;i < 6;i++){
            for(int j = 0; j < 11; j++){
                System.out.format("%8.2f", matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        //1
        short[] s = new short[6];
        short value = 16;
        for (int i = 0; i < 6; i++){
            s[i] = value;
            value -= 2;
        }
        //2
        float[] x = new float[11];
        for(int i = 0; i < 11; i++){
            x[i] = -8 + (float)Math.random() * 19;
        }
        //3
        double[][] f = new double[6][11];
        for(int i = 0;i < 6; i++){
            for(int j = 0;j < 11;j++){
                f[i][j] = matrix(s[i], x[j]);
            }
        }
            
        
        
        //4
        print_matrix(f);
    }
}
