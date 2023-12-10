package Model;

import java.util.ArrayList;
import java.util.Date;

public interface IAnimal {
    /**
     * Получение возраста животного
     * @return возраст животного
     */
    Integer getAge();

    /**
     * Издает звук животного
     * @return звук, которое издает животное
     */
    String makeSound();

    /**
     * Выводит строку с перечнем знакомых животному команд
     * @return список команд
     */
    String getOrdersListString();
}
