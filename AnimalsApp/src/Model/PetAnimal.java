package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PetAnimal extends Animal {
    /**
     * Класс домашних животных
     * @param animalSpecies вид животного
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public PetAnimal (String animalSpecies, String animalName,
                      LocalDate animalBirthday, ArrayList<String> animalOrders)  {
        super("Домашние животные", animalSpecies, animalName,
                animalBirthday, animalOrders);
    }
    public PetAnimal () {
        super();
        super.setAnimalType("Домашние животные");
    }
}
