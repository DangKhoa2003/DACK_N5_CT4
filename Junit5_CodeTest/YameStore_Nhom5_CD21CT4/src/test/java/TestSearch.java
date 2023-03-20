import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestSearch {
    Search a = new Search();

    @Test
    public void Testcasetim1() {
        assertEquals(1, a.search(2), "result must be: 1");
    }

    @Test
    public void Testcasetim2() {
        assertEquals(0, a.search(6), "result must be: 0");
    }

    @Test
    public void Testcasetim3() {
        assertEquals(1, a.search(3), "result must be: 1");
    }
}
