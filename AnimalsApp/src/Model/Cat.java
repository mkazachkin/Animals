package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends PetAnimal {
    /**
     * Класс котов и кошек
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Cat (String animalName, LocalDate animalBirthday,
                  ArrayList<String> animalOrders)  {
        super("Кот", animalName,
                animalBirthday, animalOrders);
    }
    public Cat () {
        super();
        super.setAnimalSpecies("Кот");
    }
    @Override
    public String makeSound() {
        return "Мяу!";
    }
}
