package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends PackAnimal {
    /**
     * Класс верблюдов
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Camel (String animalName, LocalDate animalBirthday,
                       ArrayList<String> animalOrders)  {
        super("Верблюд", animalName,
                animalBirthday, animalOrders);
    }
    public Camel () {
        super();
        super.setAnimalSpecies("Верблюд");
    }
    @Override
    public String makeSound() {
        return "Тьфу!";
    }
}
