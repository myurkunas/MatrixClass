import java.util.Arrays;

/**
 * Tests the Matrix class and all of its functions.
 * @author Matthew Yurkunas
 */
public class MatrixTest {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,4);
        a.setEntry(0, 0, 1);
        double[][] arr = new double[2][4];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;
        Matrix arrMatrix = new Matrix(arr);
        Matrix b = new Matrix(3, 4);
        b.setEntry(0,0,2);
        Matrix c = new Matrix(3,4);
        c.setEntry(0, 0, 3);
        a.setEntry(0, 1, 6);
        Matrix d = new Matrix(3,4);
        d.setEntry(0, 0, 1);
        d.setEntry(0, 1, 6);

        Matrix x = new Matrix(2, 3);
        x.setEntry(0, 0, 1);
        x.setEntry(0, 1, 2);
        x.setEntry(0, 2, 3);
        x.setEntry(1, 0, 3);
        x.setEntry(1, 1, 2);
        x.setEntry(1, 2, 1);
        Matrix y = new Matrix(3, 2);
        y.setEntry(0, 0, 2);
        y.setEntry(0, 1, 5);
        y.setEntry(1, 0, -3);
        y.setEntry(1, 1, 8);
        y.setEntry(2, 0, 7);
        y.setEntry(2, 1, 5);

        System.out.println("Matrix a: ");
        System.out.println(a);
        System.out.println("Matrix b: ");
        System.out.println(b);
        System.out.println("Matrix c: ");
        System.out.println(c);
        System.out.println("Matrix d:");
        System.out.println(d);

        System.out.println("Matrix x: ");
        System.out.println(x);
        System.out.println("Matrix y: ");
        System.out.println(y);

        System.out.println("ADD: Matrix a + b:");
        System.out.println(a.add(b));
        System.out.println("SUBTRACT: Matrix a - b:");
        System.out.println(a.subtract(b));
        System.out.println("MULTIPLY: Matrix x * y:");
        System.out.println(x.multiply(y));
        System.out.print("EQUALS: Matrix a = b: ");
        System.out.println(a.equals(b));
        System.out.print("EQUALS: Matrix a = c: ");
        System.out.println(a.equals(c));
        System.out.print("EQUALS: Matrix a = d: ");
        System.out.println(a.equals(d));
        System.out.println();
        System.out.println("TRANSPOSE: Matrix x transposed:");
        System.out.println(x.transpose());

        // CLONE OVERRIDE EXAMPLE (DEEP COPY)
        Matrix f = a.clone();
        System.out.println("CLONE METHOD OVERRIDE: Deep Copy of Matrix a: ");
        System.out.println(f);

        Matrix[] q = new Matrix[3];
        q[0] = a;
        q[1] = b;
        q[2] = c;
        System.out.println("Array q is an array containing Matrices a, b and c.");
        System.out.println("SORT (ASCENDING): Array q sorted ascending:");
        Arrays.sort(q);
        for (int i = 0; i < q.length; i++) {
            System.out.println((i+1) + ") \n" + q[i]);
        }

        System.out.println("SORT (DESCENDING): Array q sorted descending:");
        Arrays.sort(q, new NewOrdering());
        for (int i = 0; i < q.length; i++) {
            System.out.println((i+1) + ") \n" + q[i]);
        }






    }
}
