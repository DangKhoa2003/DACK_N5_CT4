import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestYameStore {
    YameStore a = new YameStore();
    @Test
    public void TestPhoneNumber1()
    {

        assertEquals("Vui long nhap dung thong tin",a.PhoneNumber("0373365530"),true);
    }
    @Test
    public void TestPhoneNumber2()
    {

        assertEquals("Vui long nhap dung thong tin",a.trimNumber(""),false);
    }
    @Test
    public void TestPhoneNumber3()
    {

        assertEquals("Vui long nhap dung thong tin",a.specialPhoneNumber("@#/"),false);
    }
}
