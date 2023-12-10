package Model;

import Model.PetAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends PetAnimal {
    /**
     * Класс хомяков
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Hamster (String animalName, LocalDate animalBirthday,
                ArrayList<String> animalOrders)  {
        super("Хомяк", animalName,
                animalBirthday, animalOrders);
    }
    public Hamster () {
        super();
        super.setAnimalSpecies("Хомяк");
    }
}
