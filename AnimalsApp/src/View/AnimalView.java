/**
 * Интерфейс реестра животных
 */
package View;

import Controller.AnimalController;
import Model.AnimalSpecies;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AnimalView {
    private final AnimalController animalController;

    /**
     * Интерфейс реестра животных
     */
    public AnimalView () {
        this.animalController = new AnimalController();
    }
    /**
     * Запускает приложение реестра животных
     */
    public void run (){
        boolean flag = false;
        while (!flag) {
            String cmd = strInput("""
                    Введите:
                        1. Показать реестр животных
                        2. Добавить животное в реестр
                        0. Выйти
                    """);
            switch (cmd) {
                case ("1") -> this.show();
                case ("2") -> this.add();
                case ("0") -> flag = true;
            }
        }
    }

    /**
     * Выводит меню выбора животных из реестра
     */
    private void show() {
        boolean flag = false;
        while (!flag) {
            StringBuilder menuString = new StringBuilder("\nВыберите животное: \n");
            int animalNum;
            for (animalNum = 0; animalNum < animalController.getAnimalCount(); animalNum++) {
                menuString.append("    ").append(animalNum + 1).append(". ").
                        append(animalController.getAnimalAnnotation(animalNum)).append("\n");
            }
            menuString.append("    0. Выйти");
            String cmd = strInput(menuString.toString());
            if (cmd.equals("0")) {
                flag = true;
            } else {
                try {
                    animalNum = Integer.parseInt(cmd) - 1;
                    if ((animalNum >= 0) && (animalNum < animalController.getAnimalCount())) {
                        showAnimal (animalNum);
                    }
                } catch (Exception e) {
                    // Ничего не делаем
                }
            }
        }
    }

    /**
     * Выводит меню добавления животного в реестр
     */
    private void add() {
        boolean flag = false;
        AnimalSpecies species = null;
        String animalName;
        LocalDate animalBirthday;
        while (!flag) {
            String cmd = strInput("""
                    Введите вид животного:
                        1. Кот (кошка)
                        2. Собака
                        3. Хомяк
                        4. Лошадь
                        5. Осел
                        6. Верблюд
                        0. Выйти
                    """);
            switch (cmd) {
                case ("1") -> {species = AnimalSpecies.Cat; flag = true;}
                case ("2") -> {species = AnimalSpecies.Dog; flag = true;}
                case ("3") -> {species = AnimalSpecies.Hamster; flag = true;}
                case ("4") -> {species = AnimalSpecies.Horse; flag = true;}
                case ("5") -> {species = AnimalSpecies.Donkey; flag = true;}
                case ("6") -> {species = AnimalSpecies.Camel; flag = true;}
                case ("0") -> flag = true;
            }
        }
        animalName = strInput("Введите кличку животного: ");
        animalBirthday = dateInput ("Введите дату рождения животного: ");
        if (this.animalController.addAnimal(species, animalName, animalBirthday)) {
            System.out.println("Животное внесено в реестр.");
        } else {
            System.out.println("При внесении животного в реестр возникла ошибка.");
        }
    }

    /**
     * Выводит меню работы с животным
     * @param animalNum номер животного в реестре
     */
    private void showAnimal(int animalNum) {
        boolean flag = false;
        while (!flag) {
            StringBuilder menuString = new StringBuilder("\nВыбрано животное: \n    ");
            menuString.append(animalController.getAnimalAnnotation(animalNum));
            menuString.append("\n");
            menuString.append("    1. Дать новую кличку животному.\n");
            menuString.append("    2. Изменить дату рождения животного.\n");
            menuString.append("    3. Посмотреть список команд, освоенных животным.\n");
            menuString.append("    4. Внести новую команду, освоенную животным.\n");
            menuString.append("    X. Удалить животное из реестра.\n");
            menuString.append("    0. Выйти.\n");
            String cmd = strInput(menuString.toString());
            switch (cmd) {
                case ("1") -> animalController.changeName(animalNum,
                        strInput("Введите новое имя животного: "));
                case ("2") -> animalController.changeBirthDate(animalNum,
                        dateInput("Введите дату рождения животного: "));
                case ("3") -> System.out.println(animalController.getOrderList(animalNum));
                case ("4") -> animalController.addOrder(animalNum,
                        strInput("Введите освоенную животным команду: "));
                case ("X") -> {
                    animalController.removeAnimal(animalNum);
                    System.out.println("Запись удалена из реестра.");
                    flag = true;
                }
                case ("0") -> flag = true;
            }
        }
    }

    /**
     * Меню ввода строки
     * @param message приглашение на ввод
     * @return ввод пользователя
     */
    private String strInput (String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

    /**
     * Меню ввода даты
     * @param message приглашение на ввод
     * @return ввод пользователя
     */
    private LocalDate dateInput (String message) {
        while (true) {
            try {
                System.out.println("Формат ввода даты ГГГГ-ММ-ДД.");
                return LocalDate.parse(strInput(message));
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты. Попробуйте еще.");
            }
        }
    }
}
