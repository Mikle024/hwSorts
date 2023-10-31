import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    AviaSouls service = new AviaSouls();

    Ticket ticket1 = new Ticket(
            "Moscow",
            "Istanbul",
            5_000,
            12,
            18
    );
    Ticket ticket2 = new Ticket(
            "Belgrade",
            "Berlin",
            2_000,
            8,
            23
    );
    Ticket ticket3 = new Ticket(
            "Moscow",
            "Istanbul",
            1_000,
            10,
            19
    );
    Ticket ticket4 = new Ticket(
            "Moscow",
            "Istanbul",
            100_000,
            17,
            18
    );
    Ticket ticket5 = new Ticket(
            "Rome",
            "Prague",
            3_000,
            12,
            17
    );

    @Test
    public void compareToTicketMoreTest() {

        Assertions.assertEquals(-1, ticket1.compareTo(ticket4));
    }

    @Test
    public void compareToTicketLessTest() {

        Assertions.assertEquals(1, ticket4.compareTo(ticket1));
    }

    @Test
    public void compareToTicketsEqualsTest() {

        Ticket ticket6 = new Ticket(
                "Moscow",
                "Istanbul",
                5_000,
                13,
                17
        );

        Assertions.assertEquals(0, ticket1.compareTo(ticket6));
    }

    @Test
    public void shouldSearchOneTicketTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = service.search("Rome", "Prague");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchZeroTicketTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = service.search("Antalya", "Sidney");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeTicketsAndSortPriceTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket3, ticket1, ticket4};
        Ticket[] actual = service.search("Moscow", "Istanbul");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTimeToTicketMoreTest() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Assertions.assertEquals(-1, comparator.compare(ticket4, ticket5));
    }

    @Test
    public void compareTimeToTicketLessTest() {

        TicketTimeComparator comparator = new TicketTimeComparator();

        Assertions.assertEquals(1, comparator.compare(ticket5, ticket4));
    }

    @Test
    public void compareTimeToTicketsEqualsTest() {
        Ticket ticket6 = new Ticket(
                "Moscow",
                "Istanbul",
                100_000,
                12,
                18
        );

        TicketTimeComparator comparator = new TicketTimeComparator();

        Assertions.assertEquals(0, comparator.compare(ticket1, ticket6));
    }

    @Test
    public void shouldSearchAndSortByOneTicketTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = service.searchAndSortBy("Rome", "Prague");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByZeroTicketTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = service.searchAndSortBy("Antalya", "Sidney");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeTicketsAndSortByTest() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);

        Ticket[] expected = {ticket4, ticket1, ticket3};
        Ticket[] actual = service.searchAndSortBy("Moscow", "Istanbul");
        Assertions.assertArrayEquals(expected, actual);
    }
}
