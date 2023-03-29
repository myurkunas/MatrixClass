/**
 * Tests the DimensionMismatch Exception
 * @author Matthew Yurkunas
 */
public class MatrixExceptionTest
{
    public static void main(String[] args)
    {
        Matrix a = new Matrix(3, 4);
        a.setEntry(0, 0, 1);
        Matrix b = new Matrix(3, 3);
        b.setEntry(0, 0, 2);

        try
        {
            a.add(b);
        }
        catch (ArrayIndexOutOfBoundsException s)
        {
            throw new DimensionMismatch();
        }

        System.out.println("Matrix a: ");
        System.out.println(a);
        System.out.println("Matrix b: ");
        System.out.println(b);

    }
}
