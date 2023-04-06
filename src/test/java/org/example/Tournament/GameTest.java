package org.example.Tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    // первый игрок сильнее
    @Test
    public void FirstPlayerStronger() {
        Game game = new Game();                                             // создаем игру
        Player pugilist = new Player(1, "Сергей", 150);    // создаем новых играков
        Player hawk = new Player(2, "Владимир", 130);
        game.register(pugilist);                                              // добавляем играков в game
        game.register(hawk);

        int expected = 1;
        int actual = game.round("Сергей", "Владимир");

        Assertions.assertEquals(expected, actual);
    }

    // второй игрок сильнее
    @Test
    public void SecondPlayerStronger() {
        Game game = new Game();
        Player pugilist = new Player(1, "Сергей", 110);
        Player hawk = new Player(2, "Владимир", 130);
        game.register(pugilist);
        game.register(hawk);

        int expected = 2;
        int actual = game.round("Сергей", "Владимир");

        Assertions.assertEquals(expected, actual);
    }

    // ничья
    @Test
    public void drawGame() {
        Game game = new Game();
        Player pugilist = new Player(1, "Сергей", 120);
        Player hawk = new Player(2, "Владимир", 120);
        game.register(pugilist);
        game.register(hawk);

        int expected = 0;
        int actual = game.round("Сергей", "Владимир");

        Assertions.assertEquals(expected, actual);
    }


    // 1-ый игрок не найден
    @Test
    public void firstPlayerNotFound() {
        Game game = new Game();
        Player pugilist = new Player(1, "Сергей", 110);
        Player hawk = new Player(2, "Владимир", 100);
        game.register(pugilist);
        game.register(hawk);

        Assertions.assertThrows(NotRegisteredException.class, () -> {

            game.round("Антон", "Владимир");
        });
    }

    // 2-ой игрок не найден
    @Test
    public void secondPlayerNotFound() {
        Game game = new Game();
        Player pugilist = new Player(1, "Сергей", 120);
        Player hawk = new Player(2, "Владимир", 90);
        game.register(pugilist);
        game.register(hawk);

        Assertions.assertThrows(NotRegisteredException.class, () -> {

            game.round("Сергей", "Дмитрий");
        });
    }

    // ни один игрок не найден
    @Test
    public void noPlayerFound() {
        Game game = new Game();
        Player pugilist = new Player(1, "Сергей", 90);
        Player hawk = new Player(2, "Владимир", 100);
        game.register(pugilist);
        game.register(hawk);

        Assertions.assertThrows(NotRegisteredException.class, () -> {

            game.round("Владислав", "Геннадий");
        });
    }

}