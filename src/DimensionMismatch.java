/**
 * Exception class for when two matrices of different dimensions are mutated.
 * @author Matthew Yurkunas
 */
public class DimensionMismatch extends ArrayIndexOutOfBoundsException
{
    public DimensionMismatch()
    {
        super("Cannot mutate two matrices of different dimensions.");
    }
}
