package Model;

import Model.PackAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends PackAnimal {
    /**
     * Класс лошадей
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Horse (String animalName, LocalDate animalBirthday,
                   ArrayList<String> animalOrders)  {
        super("Лошадь", animalName,
                animalBirthday, animalOrders);
    }
    public Horse () {
        super();
        super.setAnimalSpecies("Лошадь");
    }
    @Override
    public String makeSound() {
        return "И-го-го!";
    }
}
