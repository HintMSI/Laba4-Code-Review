/* Продолжение задания №1.1-5.5 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point point1 = createPoint(scanner, 1);
        Point point2 = createPoint(scanner, 2);
        Point point3 = createPoint(scanner, 3);

        System.out.println("Точки на плоскости:");
        System.out.println("Первая точка: " + point1);
        System.out.println("Вторая точка: " + point2);
        System.out.println("Третья точка: " + point3);

        System.out.print("1.3 Введите ФИО первого человека: ");
        Name firstPerson = createNameFromInput(scanner);
        System.out.print("Введите ФИО второго: ");
        Name secondPerson = createNameFromInput(scanner);
        System.out.print("Введите ФИО третьего: ");
        Name thirdPerson = createNameFromInput(scanner);

        System.out.println("Созданные имена:");
        System.out.println(firstPerson);
        System.out.println(secondPerson);
        System.out.println(thirdPerson);

        Point point1Start = new Point(1, 3);
        Point point1End = new Point(23, 8);
        Line line1 = new Line(point1Start, point1End);

        Point point2Start = new Point(5, 10);
        Point point2End = new Point(25, 10);
        Line line2 = new Line(point2Start, point2End);

        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("2.1 " + line1);
        System.out.println(line2);
        System.out.println(line3);

        line1.setStart(new Point(2, 4));
        line1.setEnd(new Point(24, 9));
        line2.setStart(new Point(6, 10));
        line2.setEnd(new Point(26, 10));
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        System.out.println("После изменения первой и второй линии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        Point oldPoint1End = line1.getEnd();
        line1.setEnd(new Point(52, 9));

        System.out.println("После изменения первой линии без изменения третьей:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");

        cityA.addPath(cityB, 5);
        cityA.addPath(cityD, 6);
        cityB.addPath(cityA, 5);
        cityB.addPath(cityC, 3);
        cityB.addPath(cityF, 1);
        cityC.addPath(cityD, 4);
        cityC.addPath(cityB, 3);
        cityD.addPath(cityA, 6);
        cityD.addPath(cityC, 4);
        cityE.addPath(cityD, 2);
        cityE.addPath(cityF, 2);
        cityF.addPath(cityA, 1);
        cityF.addPath(cityE, 2);

        System.out.println("3.3 " + cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);

        System.out.println("5.5 Введите числитель первой дроби:");
        int numerator1 = getValidInt(scanner);
        System.out.println("Введите знаменатель первой дроби:");
        int denominator1 = getValidInt(scanner);
        Fraction fraction1 = new Fraction(numerator1, denominator1);

        System.out.println("Введите числитель второй дроби:");
        int numerator2 = getValidInt(scanner);
        System.out.println("Введите знаменатель второй дроби:");
        int denominator2 = getValidInt(scanner);
        Fraction fraction2 = new Fraction(numerator2, denominator2);

        System.out.println("Введены дроби: " + fraction1 + " и " + fraction2);
        System.out.println(fraction1 + " * " + fraction2 + " = " + fraction1.multiply(fraction2));
        System.out.println(fraction1 + " + " + fraction2 + " = " + fraction1.add(fraction2));
        System.out.println(fraction1 + " / " + fraction2 + " = " + fraction1.divide(fraction2));
        System.out.println(fraction1 + " - 5 = " + fraction1.subtract(5));

        Fraction result = fraction1.add(fraction2).divide(fraction2).subtract(5);
        System.out.println("Результат выражения : " + result);
    }

    /**
     * Создает точку на плоскости по введенным пользователем координатам
     * @param scanner Объект Scanner для ввода данных
     * @param pointNumber Номер создаваемой точки (для отображения в приглашении)
     * @return Созданный объект Point
     */
    private static Point createPoint(Scanner scanner, int pointNumber) {
        double x = 0;
        double y = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("1.1 Введите координаты для точки " + pointNumber + " (X Y): ");
            String input = scanner.nextLine();
            String[] coordinates = input.split(" ");

            if (coordinates.length == 2 && isNumeric(coordinates[0]) && isNumeric(coordinates[1])) {
                x = Double.parseDouble(coordinates[0]);
                y = Double.parseDouble(coordinates[1]);
                validInput = true;
            } else {
                System.out.println("Ошибка: необходимо ввести две числовые координаты через пробел.");
            }
        }
        return new Point(x, y);
    }

    /**
     * Проверяет, является ли строка числом (целым или дробным)
     * @param str Строка для проверки
     * @return true если строка представляет число, иначе false
     */
    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.' && c != '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * Создает объект Name из введенной пользователем строки
     * @param scanner Объект Scanner для ввода данных
     * @return Созданный объект Name
     */
    private static Name createNameFromInput(Scanner scanner) {
        String input = scanner.nextLine();
        String[] parts = input.trim().split("\\s+");
        String surname = parts.length > 0 ? parts[0] : null;
        String firstName = parts.length > 1 ? parts[1] : null;
        String patronymic = parts.length > 2 ? parts[2] : null;
        return new Name(surname, firstName, patronymic);
    }

    /**
     * Получает от пользователя целое число с валидацией ввода
     * @param scanner Объект Scanner для ввода данных
     * @return Введенное пользователем целое число
     */
    private static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число:");
            scanner.next();
        }
        return scanner.nextInt();
    }
}