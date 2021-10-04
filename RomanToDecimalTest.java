import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("XXX"), 30);
        assertEquals(RomanToDecimal.romanToDecimal("XC"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("M"), 1000);
        assertEquals(RomanToDecimal.romanToDecimal("DCCC"), 800);
        assertEquals(RomanToDecimal.romanToDecimal("CD"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("VIII"), 8);
        assertEquals(RomanToDecimal.romanToDecimal("LXX"), 70);
        assertEquals(RomanToDecimal.romanToDecimal("MDLV"), 1555);
        assertEquals(RomanToDecimal.romanToDecimal("MMCMX"), 2910);
        assertEquals(RomanToDecimal.romanToDecimal("CCVL"), 255);
        assertEquals(RomanToDecimal.romanToDecimal("MCIX"), 1109);
        assertEquals(RomanToDecimal.romanToDecimal("XIXIXI"), 31);
        assertEquals(RomanToDecimal.romanToDecimal("JOE"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("JOHN"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("LKYI"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("FUNNY>GUY"), -1);
        assertNotEquals(RomanToDecimal.romanToDecimal("XI"), 111);
        assertNotEquals(RomanToDecimal.romanToDecimal("JOE"), 97);
    }
}