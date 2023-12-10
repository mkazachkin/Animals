package Model;

import Model.PackAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Donkey extends PackAnimal {
    /**
     * Класс ослов
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Donkey (String animalName, LocalDate animalBirthday,
                  ArrayList<String> animalOrders)  {
        super("Осел", animalName,
                animalBirthday, animalOrders);
    }
    public Donkey () {
        super();
        super.setAnimalSpecies("Осел");
    }
    @Override
    public String makeSound() {
        return "Иа!";
    }
}
