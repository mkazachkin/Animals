package Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Animal extends AAnimal implements IAnimal {
    /**
     * Класс животных
     * @param animalType тип животного
     * @param animalSpecies вид животного
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Animal (String animalType, String animalSpecies, String animalName,
                   LocalDate animalBirthday, ArrayList<String> animalOrders) {
        super(animalType, animalSpecies, animalName, animalBirthday, animalOrders);
    }
    public Animal () {
        super();
    }
    public Integer getAge() {
        LocalDate birthDate = super.getAnimalBirthday();
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
    public String makeSound() {
        return null;
    }
    public String getOrdersListString() {
        if (this.getAnimalOrders().size() > 0) {
            return "Список изученных команд: " + String.join(", ", this.getAnimalOrders());
        }
        return "Команды животным не изучены.";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Вид животного: ").append(super.getAnimalSpecies()).append(". ");
        result.append("Тип животного: ").append(super.getAnimalType()).append(". ");
        result.append("Кличка животного: ").append(super.getAnimalName()).append(". ");
        result.append("Возраст животного: ").append(getAge()).append(". ");
        if (makeSound() != null) {
            result.append("Издает звуки: ").append(makeSound());
        } else {
            result.append("Звуков не издает.");
        }
        return result.toString();
    }
}
