package Model;

import Model.PetAnimal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends PetAnimal {
    /**
     * Класс собак
     * @param animalName кличка животного, при наличии
     * @param animalBirthday дата рождения животного
     * @param animalOrders список приказов, которые знает животное
     */
    public Dog (String animalName, LocalDate animalBirthday,
                ArrayList<String> animalOrders)  {
        super("Собака", animalName,
                animalBirthday, animalOrders);
    }
    public Dog () {
        super();
        super.setAnimalSpecies("Собака");
    }
    @Override
    public String makeSound() {
        return "Гав!";
    }
}
