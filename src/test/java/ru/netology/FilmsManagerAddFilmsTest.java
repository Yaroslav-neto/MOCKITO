package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmsManagerAddFilmsTest {

    FilmsItem item1 = new FilmsItem("Бладшот", "боевик");
    FilmsItem item2 = new FilmsItem("Вперед", "мультфильм");
    FilmsItem item3 = new FilmsItem("Отель <<Белград>>", "комедия");
    FilmsItem item4 = new FilmsItem("Человек-невидимка", "ужасы");
    FilmsItem item5 = new FilmsItem("Тролли. Мировой тур", "мультфильм");
    FilmsItem item6 = new FilmsItem("Номер один", "комедия");

    @Test
    void shouldFindAll() {
        FilmsManager repo = new FilmsManager();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);
        repo.add(item6);

        FilmsItem[] expected = {item1, item2, item3, item4, item5, item6};
        FilmsItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFiveAdd() {
        FilmsManager repo = new FilmsManager();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.add(item5);

        FilmsItem[] expected = {item1, item2, item3, item4, item5};
        FilmsItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneAdd() {
        FilmsManager repo = new FilmsManager();
        repo.add(item1);

        FilmsItem[] expected = {item1};
        FilmsItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindWithoutAdd() {
        FilmsManager repo = new FilmsManager();

        FilmsItem[] expected = {};
        FilmsItem[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}