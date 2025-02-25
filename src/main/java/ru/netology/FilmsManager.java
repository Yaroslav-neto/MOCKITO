package ru.netology;

public class FilmsManager {

    private FilmsItem[] items = new FilmsItem[0];
    private final int limit;

    public FilmsManager() {
        this.limit = 5;
    }

    public FilmsManager(int limit) {
        this.limit = Math.max(limit, 0);
    }


    //добавление нового фильма
    public void add(FilmsItem item) {

        FilmsItem[] tmp = new FilmsItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    //вывод всех фильмов
    public FilmsItem[] findAll() {
        return items;
    }

    //вывод всех фмльмов наоборот
    public FilmsItem[] findLast() {
        //вычисление лимита вывода
        int resultLength = Math.min(limit, items.length);
        //заполнение массива в обратном порядке
        FilmsItem[] tmp = new FilmsItem[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items[items.length - 1 - i];
        }
        return tmp;
    }
}
