/**
 * Defines the Matrix class.
 * A Matrix is a 2-Dimensional Array that holds special properties for manipulating it.
 * @author Matthew Yurkunas
 */
public class Matrix implements Comparable<Matrix>
{
    int nRow;
    int nCol;
    double[][] array;

    /**
     * Constructor
     * Creates this Matrix of size nRow by nCol and fills the values with 0.0
     * @param nRow number of Rows in this Matrix
     * @param nCol number of Columns in this Matrix
     */
    public Matrix(int nRow, int nCol)
    {
        this.nRow = nRow;
        this.nCol = nCol;
        this.array = new double[nRow][nCol];

        for (int row = 0; row < this.nRow; row++)
        {
            for (int col = 0; col < this.nCol; col++)
            {
                array[row][col] = 0;
            }
        }
    }

    /**
     * Explicit Constructor
     * Creates a deep copy of a two-dimensional array and turns it into a Matrix.
     * @param a two-dimensional array that will be converted into a Matrix
     */
    public Matrix(double[][] a)
    {
        this.nRow = a.length;
        this.nCol = a[1].length;
        this.array = new double[nRow][nCol];
        for(int i = 0; i < a.length; i++)
        {
            array[i] = a[i].clone();
        }
    }

    /**
     * Creates an order for sorting matrices.
     * @param m the object to be compared.
     * @return sorted matrices from smallest to largest.
     */
    public int compareTo(Matrix m)
    {
        double sumFirst = 0;
        double sumSecond = 0;
        for (int row = 0; row < this.nRow; row++)
        {
            for (int col = 0; col < this.nCol; col++)
                sumFirst += array[row][col];
        }

        for (int row = 0; row < m.nRow; row++)
        {
            for (int col = 0; col < m.nCol; col++)
                sumSecond += m.array[row][col];
        }

        if(Math.abs(sumFirst) > Math.abs(sumSecond)) return 1;
        if(Math.abs(sumFirst) < Math.abs(sumSecond)) return -1;
        return 0;
    }

    /**
     * Inserts a value into a specific row and column in this Matrix. Replaces existing value.
     * @param row row to insert value,
     * @param col column to insert value.
     * @param value value to be inserted at row x col.
     */
    public void setEntry(int row, int col, double value)
    {
        array[row][col] = value;
    }

    /**
     * Add this matrix to another matrix. Both matrices must have the same dimensions.
     * @param a matrix to be added to this matrix.
     * @return new matrix with summation of this matrix and another matrix.
     */
    public Matrix add(Matrix a)
    {
        Matrix b = new Matrix(nRow, nCol);
        for (int row = 0; row < nRow; row++)
        {
            for (int col = 0; col < nCol; col++)
            {
               b.setEntry(row, col, array[row][col] + a.array[row][col]);
            }
        }
        return b;
    }

    /**
     * Subtract this matrix and another matrix. Both matrices must have the same dimensions.
     * @param a matrix to be subtracted from this matrix.
     * @return new matrix with the difference of this matrix and another matrix.
     */
    public Matrix subtract(Matrix a)
    {
        Matrix b = new Matrix(nRow, nCol);
        for (int row = 0; row < nRow; row++)
        {
            for (int col = 0; col < nCol; col++)
            {
                b.setEntry(row, col, array[row][col] - a.array[row][col]);
            }
        }
        return b;
    }

    /**
     * Multiply this matrix and another matrix. An n-by-m matrix times an m-by-p matrix is an n-by-p matrix.
     * The number of columns in the first matrix must be equal to the number of rows in the second matrix.
     * @param a matrix to be multiplied by this matrix.
     * @return new matrix with the product of this matrix and another matrix.
     */
    public Matrix multiply(Matrix a)
    {
        double[][] b = new double[nRow][a.nCol];
        for (int i = 0; i < nCol; i++)
        {
            for (int j = 0; j < a.nCol; j++)
            {
                for (int k = 0; k < nRow; k++)
                {
                    b[j][k] +=  a.array[i][k]*this.array[j][i];
                }
            }
        }
        return new Matrix(b);
    }

    /**
     * Transposes this matrix. The transpose of a matrix converts an n-by-m matrix to an m-by-n
     * and changes all (i,j) values to (j,i) values.
     * @return new transposed version of this matrix.
     */
    public Matrix transpose()
    {
        Matrix b = new Matrix(nCol, nRow);
        for (int row = 0; row < nRow; row++)
        {
            for (int col = 0; col < nCol; col++)
            {
                b.setEntry(col, row, array[row][col]);
            }
        }
        return b;
    }

    /**
     * Overrides the equals method.
     * Matrices are equal if their dimensions and values are the same.
     * @param a matrix to be compared to this matrix.
     * @return true/false if matrices are equal.
     */
    public boolean equals(Matrix a)
    {
        boolean equal;
        if(nRow == a.nRow && nCol == a.nCol)
            equal = true;
        else
            return false;
        for (int row = 0; row < nRow; row++)
        {
            for (int col = 0; col < nCol; col++)
            {
                if (array[row][col] != a.array[row][col]) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    /**
     * Overrides the toString method.
     * Converts Matrix to a String.
     * @return this Matrix as a String.
     */
    public String toString() {
        String out = "";
        for (int row = 0; row < this.nRow; row++)
        {
            out += "(";
            for (int col = 0; col < this.nCol; col++)
            {
                if (col == nCol - 1)
                    out += array[row][col];
                else
                    out += array[row][col] + ", ";
            }
            out += ")\n";
        }
        return out;
    }

    /**
     * Overrides the clone method
     * @return a deep copy of the Matrix.
     */
    public Matrix clone()
    {
        return new Matrix(this.array);
    }
}
