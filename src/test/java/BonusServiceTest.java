import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 26_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 19_000_00;
        boolean registered = false;
        long expected = 190;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1300;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateRegisteredAndBoundaryLimit() {
        BonusService service = new BonusService();

        long amount = 1300;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }
    @Test
    void shouldCalculateRegisteredAndAvgLimit() {
        BonusService service = new BonusService();

        long amount = 1300;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndBoundaryLimit() {
        BonusService service = new BonusService();

        long amount = 13000000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndMinBonus() {
        BonusService service = new BonusService();

        long amount = 13000;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }



}