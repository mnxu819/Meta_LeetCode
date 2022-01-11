Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.
Method read4:
The API read4 reads four consecutive characters from file, then writes those characters into the buffer array buf4.
The return value is the number of actual characters read.
Note that read4() has its own file pointer, much like FILE *fp in C.
Definition of read4:
    Parameter:  char[] buf4
    Returns:    int
buf4[] is a destination, not a source. The results from read4 will be copied to buf4[].
      
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int copiedChars = 0, readChars = 4;
        char[] buf4 = new char[4];
        
        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);
            for (int i = 0; i < readChars; i++) {
                if (copiedChars == n) {
                    return copiedChars;
                }
                buf[copiedChars] = buf4[i];
                ++copiedChars;  
            }
        }
        return copiedChars;
    }
}
