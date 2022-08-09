package Encoding;

public class Test
{
    @org.junit.Test
    public void test()
    {
        RunLengthEncoding rle = new RunLengthEncoding();

        assert ( "a2b2c3".equals(rle.encode("aabbccc".toCharArray())));
        assert ( "a2b2c".equals(rle.encode("aabbc".toCharArray())));
        assert ( "a".equals(rle.encode("a".toCharArray())));

        //assert ( "a2b2c2".equals(rle.encode_MT("aabbcc".toCharArray(), 3)));
        assert ( "a2b2c2c".equals(rle.encode_MT("aabbccc".toCharArray(), 3)));
    }
}
