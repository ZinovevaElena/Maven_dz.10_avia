import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket ticket1 = new Ticket("Moscow", "Kazan", 10_000, 2, 4);
    Ticket ticket2 = new Ticket("Kazan", "Moscow", 9_000, 5, 7);
    Ticket ticket3 = new Ticket("Moscow", "Sochi", 15_000, 15, 18);
    Ticket ticket4 = new Ticket("Moscow", "Sochi", 18_000, 12, 14);
    Ticket ticket5 = new Ticket("Moscow", "Sochi", 9_000, 21, 24);
    Ticket ticket6 = new Ticket("Kazan", "Moscow", 12_000, 11, 12);
    Ticket ticket7 = new Ticket("Moscow", "Sochi", 50_000, 10, 11);


    @Test
    public void compareToIfPriceLowerTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Assertions.assertEquals(-1, ticket2.compareTo(ticket1));
    }

    @Test
    public void compareToIfPriceMoreTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
    }

    @Test
    public void compareToIfPriceSameTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Assertions.assertEquals(0, ticket2.compareTo(ticket5));
    }

    @Test
    public void searchPriceTicketTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket5, ticket3, ticket4, ticket7};
        Ticket[] actual = manager.search("Moscow", "Sochi");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchPriceTicketIfOneTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.search("Moscow", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchPriceTicketIfNoneTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Sochi", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByTicketTest() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6, ticket2};
        Ticket[] actual = manager.searchAndSortBy("Kazan", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}