package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimal extends Animal {
    /**
     * Класс домашних животных
     * @param animalSpecies вид животного
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public PackAnimal (String animalSpecies, String animalName,
                       LocalDate animalBirthday, ArrayList<String> animalOrders)  {
        super("Вьючные животные", animalSpecies, animalName,
                animalBirthday, animalOrders);
    }
    public PackAnimal () {
        super();
        super.setAnimalType("Вьючные животные");
    }
}
