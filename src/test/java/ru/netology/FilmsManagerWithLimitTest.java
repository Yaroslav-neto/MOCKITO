package ru.netology;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class FilmsManagerWithLimitTest {

    FilmsItem item1 = new FilmsItem("Бладшот", "боевик");
    FilmsItem item2 = new FilmsItem("Вперед", "мультфильм");
    FilmsItem item3 = new FilmsItem("Отель <<Белград>>", "комедия");
    FilmsItem item4 = new FilmsItem("Человек-невидимка", "ужасы");
    FilmsItem item5 = new FilmsItem("Тролли. Мировой тур", "мультфильм");
    FilmsItem item6 = new FilmsItem("Номер один", "комедия");

    @Test
    void shouldFindLastLimit() {
        FilmsManager repo = new FilmsManager();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {item6, item5, item4, item3, item2};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimit1() {
        FilmsManager repo = new FilmsManager(1);
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {item6};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimit6() {
        FilmsManager repo = new FilmsManager(6);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {item6, item5, item4, item3, item2, item1};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimit7() {
        FilmsManager repo = new FilmsManager(7);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {item6, item5, item4, item3, item2, item1};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimit0() {
        FilmsManager repo = new FilmsManager(0);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimitMinus1() {
        FilmsManager repo = new FilmsManager(-1);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimitAdd1() {
        FilmsManager repo = new FilmsManager();

        repo.add(item1);

        FilmsItem[] expected = {item1};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimitAdd2() {
        FilmsManager repo = new FilmsManager();

        repo.add(item1);
        repo.add(item2);

        FilmsItem[] expected = {item2, item1};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastLimitNoAddLimit7() {
        FilmsManager repo = new FilmsManager(7);

        FilmsItem[] expected = {};
        FilmsItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}