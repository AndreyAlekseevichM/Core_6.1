import java.util.Scanner;

class Main {

    public static int earnings = 0;    // доходы
    public static int spendings = 0;   // расходы

    public static int taxMinus6(int earnings) {
        int tax6 = earnings * 6 / 100;
        return tax6;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax15 = (earnings - spendings) * 15 / 100;
        if (tax15 >= 0) {
            return tax15;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            System.out.println("end <Выход>");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String money2Str = scanner.nextLine();
                    int money2 = Integer.parseInt(money2Str);
                    spendings += money2;
                    break;
                case 3:
                    systemSelection();
                default:
                    System.out.println("Такой операции нет");
                    break;
            }
        }
    }

    private static void systemSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите систему налогообложения:");
        System.out.println("Введите цифру 1 если УСН доходы - налог 6% от доходов");
        System.out.println("Введите цифру 2 если УСН доходы минус расходы-налог 15% от разницы доходов и расходов");
        String snStr = scanner.nextLine();
        int taxationSystem = Integer.parseInt(snStr);

        switch (taxationSystem) {
            case 1:
                if (taxMinus6(earnings) <= taxEarningsMinusSpendings(earnings, spendings)) {
                    System.out.println("Ваша система налогообложения УСН доходы подходит");
                    int youTax6_1 = taxMinus6(earnings);
                    System.out.println("Ваш налог составит:" + youTax6_1 + "рублей.");
                    int youTax15_1 = taxEarningsMinusSpendings(earnings, spendings);
                    System.out.println("Налог на другой системе:" + youTax15_1 + "рублей.");
                    System.out.println("Экономия:" + (youTax15_1 - youTax6_1) + "рублей.");
                    System.out.println();
                } else {
                    System.out.println("Вам необходимо сменить систему налогообложения это поможет сэкономить");
                    System.out.println();
                }
                break;
            case 2:
                if (taxEarningsMinusSpendings(earnings, spendings) <= taxMinus6(earnings)) {
                    System.out.println("Ваша система налогообложения УСН доходы минус расходы подходит");
                    int youTax15_2 = taxEarningsMinusSpendings(earnings, spendings);
                    System.out.println("Ваш налог составит:" + youTax15_2 + "рублей.");
                    int youTax6_2 = taxMinus6(earnings);
                    System.out.println("Налог на другой системе:" + youTax6_2 + "рублей.");
                    System.out.println("Экономия:" + (youTax6_2 - youTax15_2) + "рублей.");
                    System.out.println();
                } else {
                    System.out.println("Вам необходимо сменить систему налогообложения это поможет сэкономить");
                    System.out.println();
                }

                break;
            default:
                System.out.println("Такой операции нет");
                break;
        }
    }
}
