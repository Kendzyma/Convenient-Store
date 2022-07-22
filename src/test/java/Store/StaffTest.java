package Store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void getStoreName() {
        Staff staff = new Staff();
      Assertions.assertEquals("KONGA",staff.getStoreName());
    }
}