package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Модель класса животных
 */
public abstract class AAnimal {
    /**
     * Кличка животного, при наличии
     */
    private String animalName;
    /**
     * Вид животного
     */
    private String animalSpecies;
    /**
     * Тип животного (вьючное, домашнее, дикое и т. п.)
     */
    private String animalType;
    /**
     * Дата рождения или ориентировочная дата рождения
     */
    private LocalDate animalBirthday;
    /**
     * Список команд, изученных животным
     */
    private ArrayList<String> animalOrders;
    /**
     * Модель класса животных
     * @param animalType тип животного
     * @param animalSpecies вид животного
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public AAnimal (String animalType, String animalSpecies, String animalName,
                    LocalDate animalBirthday, ArrayList<String> animalOrders) {
        this.animalType = animalType;
        this.animalSpecies = animalSpecies;
        this.animalName = animalName;
        this.animalBirthday = animalBirthday;
        this.animalOrders = animalOrders;
    }
    public AAnimal() {
        this.animalType = null;
        this.animalSpecies = null;
        this.animalName = null;
        this.animalBirthday = null;
        this.animalOrders = new ArrayList<>();
    }

    /**
     * Возвращает кличку животного
     * @return кличка животного
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Задает кличку животного
     * @param animalName кличка животного
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * Возвращает вид животного
     * @return вид животного
     */
    public String getAnimalSpecies() {
        return animalSpecies;
    }

    /**
     * Задает вид животного
     * @param animalSpecies вид животного
     */
    public void setAnimalSpecies(String animalSpecies) {
        this.animalSpecies = animalSpecies;
    }

    /**
     * Возвращает тип животного
     * @return тип животного
     */
    public String getAnimalType() {
        return animalType;
    }

    /**
     * Задает тип животного
     * @param animalType тип животного
     */
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    /**
     * Возврщает дату рождения животного
     * @return дата рождения животного
     */
    public LocalDate getAnimalBirthday() {
        return animalBirthday;
    }

    /**
     * Задает дату рождения животного
     * @param animalBirthday дата рождения животного
     */
    public void setAnimalBirthday(LocalDate animalBirthday) {
        this.animalBirthday = animalBirthday;
    }

    /**
     * Возвращает перечень команд, которые знает животное
     * @return перечень команд
     */
    public ArrayList<String> getAnimalOrders() {
        return animalOrders;
    }

    /**
     * Добавляет команду в список изученных
     * @param animalOrder команда
     */
    public void addAnimalOrder (String animalOrder) {
        this.animalOrders.add(animalOrder);
    }
}
