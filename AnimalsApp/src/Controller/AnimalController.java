package Controller;

import Model.Animal;
import Model.AnimalSpecies;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnimalController {
    private final ArrayList<Animal> animalList = new ArrayList<>();
    private final AnimalCounter counter = new AnimalCounter();
    /**
     * Добавляет животное в реестр
     * @param species вид животного
     * @param animalName кличка животного
     * @param animalBirthdate дата рождения животного
     * @return True в случае успеха, False, если возникла ошибка
     */
    public boolean addAnimal (AnimalSpecies species, String animalName, LocalDate animalBirthdate) {
        AnimalFab animalFab = new AnimalFab();
        try {
            Animal animal = animalFab.getAnimalClass(species);
            animal.setAnimalName(animalName);
            animal.setAnimalBirthday(animalBirthdate);
            animalList.add(animal);
            counter.add();
        } catch (ClassNotFoundException e) {
            System.out.println("Отсутствует класс для данного вида животного.");
            return false;
        } catch (NoSuchMethodException e) {
            System.out.println("Ошибка конструктора класса животного.");
            return false;
        } catch (InvocationTargetException e) {
            System.out.println("Во время вызова метода или конструктора класса животного возникло исключение.");
            return false;
        } catch (InstantiationException e) {
            System.out.println("Невозможно создать экземпляр класса животного.");
            return false;
        } catch (IllegalAccessException e) {
            System.out.println("Ошибка изменения класса животного.");
            return false;
        }
        return true;
    }

    /**
     * Удаляет животное из реестра
     * @param animalNum порядковый номер животного в реестре
     * @return True в случае успеха, False, если возникла ошибка
     */
    public boolean removeAnimal (int animalNum) {
        try {
            animalList.remove(animalNum);
            counter.remove();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    /**
     * Меняет дату рождения животного
     * @param animalNum номер животного в реестре
     * @param animalBirthdate дата рождения животного
     */
    public void changeBirthDate (int animalNum, LocalDate animalBirthdate) {
        this.animalList.get(animalNum).setAnimalBirthday(animalBirthdate);
    }

    /**
     * Меняет кличку животного
     * @param animalNum номер животного в реестре
     * @param name кличка животнрого
     */
    public void changeName (int animalNum, String name) {
        this.animalList.get(animalNum).setAnimalName(name);
    }

    /**
     * Добавляет команду в список изученных животным команд
     * @param animalNum номер животного в реестре
     * @param order команда
     */
    public void addOrder (int animalNum, String order) {
        this.animalList.get(animalNum).addAnimalOrder(order);
    }

    /**
     * Возвращает строку с перечнем команд, знакомых животному
     * @param animalNum номер животного в реестре
     * @return список команд
     */
    public String getOrderList (int animalNum) {
        return this.animalList.get(animalNum).getOrdersListString();
    }

    /**
     * Возвращает описание животного
     * @param animalNum номер животного в реестре
     * @return описание животного
     */
    public String getAnimalAnnotation (int animalNum) {
        return this.animalList.get(animalNum).toString();
    }
    public int getAnimalCount () {
        return counter.get();
    }
}
