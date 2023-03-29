import java.util.Comparator;

/**
 * Implements Comparator and provides a new sorting method for the Matrix class.
 * This allows the sorting of largest to smallest.
 * @author Matthew Yurkunas
 */
public class NewOrdering implements Comparator<Matrix>
{
    public int compare(Matrix m1, Matrix m2)
    {
        double sumFirst = 0;
        double sumSecond = 0;
        for (int row = 0; row < m1.nRow; row++)
        {
            for (int col = 0; col < m1.nCol; col++)
                sumFirst += m1.array[row][col];
        }

        for (int row = 0; row < m2.nRow; row++)
        {
            for (int col = 0; col < m2.nCol; col++)
                sumSecond += m2.array[row][col];
        }

        if(Math.abs(sumFirst) > Math.abs(sumSecond)) return -1;
        if(Math.abs(sumFirst) < Math.abs(sumSecond)) return 1;
        return 0;
    }
}
