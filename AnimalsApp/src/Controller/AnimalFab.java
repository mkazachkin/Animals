/**
 * Фабрика классов животных
 */
package Controller;

import Model.Animal;
import Model.AnimalSpecies;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AnimalFab {
    /**
     * Выдает экземпляр класса животного
     * @param species вид животного
     * @return пустой экземпляр класса животного соответствующего вида
     * @throws ClassNotFoundException если не найден класс животного или была ошибка в его написании
     * @throws NoSuchMethodException нет конструктора в классе животного без аргументов
     * @throws InvocationTargetException во время вызова метода или конструктора класса животного возникло исключение
     * @throws InstantiationException невозможно создать экземпляр класса животного
     * @throws IllegalAccessException ошибка в классе животного
     */
    public static Animal getAnimalClass(AnimalSpecies species)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<?> fabAnimal = Class.forName("Model." + species);
        Constructor<?> constructor = fabAnimal.getConstructor();
        return (Animal) constructor.newInstance();
    }
}
