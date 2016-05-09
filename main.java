/**
 * Created by Firdaus on 2/20/2016.
 */
public class main {
    public  int  findLast (int[] x, int y)
    {
// Effects: If x==null  throw  NullPointerException
//   else  return  the  index  of the  last  element
//   in x that  equals y.
//   If no such  element  exists , return  -1
        for (int i=x.length -1; i > 0; i--)   // need to change i>= 0; because it never check the 0th index;
        {
            if (x[i] == y)
            {
                return i; //returns the index instead of the actual number.
            }
        }
        return  -1;
    }
//test: x=[2 ,3 ,5];y=2  Expected = 0
}
