package ru.practicum.dinner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        // Подготовленный входной поток данных, который эмулирует ввод пользователя через консоль
        // Здесь мы заранее прописываем команды, которые будут введены в консоль, включая команды и значения.
        String input = """
                1
                Первое
                Суп
                1
                Первое
                Борщ
                1
                Второе
                Макароны
                1
                Второе
                Пюре
                1
                Напитки
                Чай
                1
                Напитки
                Кофе
                2
                6
                Напитки
                Второе
                Первое
                
                4
                3
                """;

        // Сохраняем оригинальный ввод, чтобы после теста восстановить его
        InputStream originalInput = System.in;

        // Создаем тестовый ввод данных, используя ByteArrayInputStream
        // Мы берем нашу строку 'input' и превращаем её в поток байтов для подмены стандартного ввода
        ByteArrayInputStream testInput = new ByteArrayInputStream(input.getBytes());

        // Подменяем стандартный поток ввода System.in на наш заранее подготовленный ввод 'testInput'
        System.setIn(testInput);

        // Запускаем метод main() из основного класса Main
        // Весь ввод будет поступать из ByteArrayInputStream вместо реальной консоли
        Main.main(args);

        // Восстанавливаем стандартный поток ввода System.in после выполнения теста
        System.setIn(originalInput);
    }
}

