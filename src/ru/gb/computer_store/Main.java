package ru.gb.computer_store;

import ru.gb.computer_store.product.Notebook;
import ru.gb.computer_store.product.Product;
import ru.gb.computer_store.product.enums.Color;
import ru.gb.computer_store.product.enums.Os;
import ru.gb.computer_store.product.enums.ProcessorVendors;
import ru.gb.computer_store.showcase.ShowCase;

import java.util.*;

public class Main {
    private static ShowCase sc = new ShowCase();

    public static void main(String[] args) {
        autoFillSC();
        System.out.println("Добро пожаловать в магазин \"Компьютерная техника\"!");
        mainMenu();


    }

    private static void autoFillSC() {
        Notebook nb1 = new Notebook("Katana B12VFK-463XRU",
                "MSI", 110999, 17.3, 16, 512,
                "Intel Core i5-12450H", Os.Windows, Color.black);
        Notebook nb2 = new Notebook("TUF Gaming F15 FX507ZC4-HN009",
                "ASUS", 73999, 15.6, 16, 512,
                "Intel Core i5-12500H", Os.None, Color.grey);
        Notebook nb3 = new Notebook("M555", "MAIBENBEN", 50999,
                15.6, 8, 512, "AMD Ryzen 5 5500U",
                Os.Windows, Color.white);
        Notebook nb4 = new Notebook("InBook Y3 MAX YL613", "Infinix",
                45999, 16, 8, 512, "Intel Core i5-1235U",
                Os.Windows, Color.silver);
        Notebook nb5 = new Notebook("Modern 14 C12M-233XRU", "MSI", 35999,
                14, 8, 512,
                "Intel Core i3-1215U", Os.None, Color.black);
        Notebook nb6 = new Notebook("MagicBook X 14 2024 Pro Fermi-G5851A",
                "HONOR", 61999, 14, 8, 512,
                "Intel Core i5-13420H", Os.Linux, Color.grey);
        Notebook nb7 = new Notebook("Titan 18 HX A14VIG-096RU", "MSI", 553999,
                18, 32, 3000, "Intel Core i9-14900HX",
                Os.Windows, Color.black);
        Notebook nb8 = new Notebook("MacBook Pro", "Apple", 453999,
                16.2, 32, 1000, "Apple M2 Max",
                Os.MacOS, Color.silver);
        Notebook nb9 = new Notebook("Aquilon", "DEXP", 17899, 14.1,
                8, 256, "Intel Celeron N4020C", Os.Dos, Color.silver);
        Notebook nb10 = new Notebook("GemiBook PLUS", "Chuwi", 26999,
                15.6, 8, 256, "Intel Processor N100",
                Os.None, Color.blue);
        Notebook nb11 = new Notebook("IdeaPad 1 15IGL7", "Lenovo", 29799,
                15.6, 4, 128, "Intel Celeron N4020",
                Os.Dos, Color.pink);
        Notebook nb12 = new Notebook("Modern 14 C12M-233XRU", "MSI",
                35999, 14, 8, 256, "Intel Core i3-1215U",
                Os.Linux, Color.black);

        sc.addProducts(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10, nb11, nb12);
//        System.out.println(getAllStringParams());
    }

    private static void filterShowCase() {

    }

    private static void mainMenu() {
        Scanner inputScanner = new Scanner(System.in);
        boolean stopFlag = false;
        while (!stopFlag) {
            System.out.println("Введите номер пункта меню.");
            System.out.println("1. Показать всю технику");
            System.out.println("2. Подобрать по параметрам");
            System.out.println("0. Выход");
            String input = inputScanner.nextLine();
            switch (input.toLowerCase()) {
                case ("0"):
                    System.exit(0);
                    break;
                case ("1"):
                    stopFlag = true;
                    System.out.println(sc);
                    mainMenu();
                    break;
                case ("2"):
                    stopFlag = true;
                    filterMenu();
                    break;
            }
        }
    }

    private static void filterMenu() {
        Scanner input = new Scanner(System.in);
        String criterion = "";
        Map<String, Set<Object>> allStringParams = getAllStringParams();
        Map<String, List<Object>> filterParams = new LinkedHashMap<>();
        boolean exitFlag = false;
        boolean stopFlag = false;
        while (!exitFlag) {
            if (!filterParams.isEmpty()) {
                System.out.println("Выбранные параметры");
                System.out.println(filterParams.keySet());
            }
            System.out.println("Выберите критерий отбора: ");
            System.out.println("1. Производитель");
            System.out.println("2. Цена");
            System.out.println("3. Диагональ экрана");
            System.out.println("4. Оперативная память");
            System.out.println("5. Жесткий диск");
            System.out.println("6. Процессор");
            System.out.println("7. Операционная система");
            System.out.println("8. Цвет");
            System.out.println("9. Применить фильтр");
            System.out.println("0. Выход");
            String inputStr = input.nextLine();
            switch (inputStr.toLowerCase()) {
                case ("0"):
                    exitFlag = true;
                    mainMenu();
                    break;
                case ("1"):
                    criterion = "vendor";
                    Set<Object> setVens = allStringParams.get(criterion);
                    List<Object> vendors = new ArrayList<>(List.of(setVens.toArray()));
                    List<Object> selectedvendors = selectFilterCriterian(criterion, vendors);
                    filterParams.put(criterion, selectedvendors);
                    break;
                case ("2"):
                    criterion = "price";
                    List<Object> prices = inputMinMaxParameters("цена", "Руб.");
                    filterParams.put(criterion, prices);
                    break;
                case ("3"):
                    criterion = "screenDiagonal";
                    List<Object> diagonals = inputMinMaxParameters("диагональ", "дюймы");
                    filterParams.put(criterion, diagonals);
                    break;
                case ("4"):
                    criterion = "ram";
                    List<Object> ramDiap = inputIntMinMaxParameters("память", "Гб");
                    filterParams.put(criterion, ramDiap);
                    break;
                case ("5"):
                    criterion = "diskCapacity";
                    List<Object> romDiap = inputIntMinMaxParameters("жесткий диск", "Гб");
                    filterParams.put(criterion, romDiap);
                    break;
                case ("6"):
                    criterion = "processor";
                    List<Object> processor = new ArrayList<>();
                    stopFlag = false;
                    while (!stopFlag) {
                        System.out.println("1. Intel");
                        System.out.println("2. AMD");
                        System.out.println("3. Apple");
                        inputStr = input.nextLine();
                        if (isNum(inputStr)) {
                            int selected = Integer.parseInt(inputStr);
                            if (selected == 1) {
                                processor.add(ProcessorVendors.Intel);
                                stopFlag = true;
                            } else if (selected == 2) {
                                processor.add(ProcessorVendors.AMD);
                                stopFlag = true;
                            } else if (selected == 3) {
                                processor.add(ProcessorVendors.Apple);
                                stopFlag = true;
                            } else {
                                System.out.println("Такого пункта не существует!");
                            }
                        } else {
                            System.out.println("Введите число!");
                        }
                    }
                    filterParams.put(criterion, processor);
                    break;
                case ("7"):
                    criterion = "os";
                    Set<Object> setOS = allStringParams.get(criterion);
                    List<Object> OS = new ArrayList<>(List.of(setOS.toArray()));
                    List<Object> selectedOS = selectFilterCriterian(criterion, OS);
                    filterParams.put(criterion, selectedOS);
                    break;
                case ("8"):
                    criterion = "color";
                    Set<Object> setColors = allStringParams.get(criterion);
                    List<Object> Colors = new ArrayList<>(List.of(setColors.toArray()));
                    List<Object> selectedColors = selectFilterCriterian(criterion, Colors);
                    filterParams.put(criterion, selectedColors);
                    break;
                case ("9"):
//                    System.out.println(filterParams);
                    List<Product> filterResult = sc.filterShowCase(filterParams);
                    showFilterResult(filterResult);
                    exitFlag = true;
                    break;
            }
        }
        mainMenu();
    }

    private static void showFilterResult(List<Product> filterResult) {
        Scanner sc = new Scanner(System.in);
        if (filterResult.isEmpty()) {
            System.out.println("Не удалось найти подходящую технику...");
        } else {
            System.out.println(filterResult);
        }
        System.out.println("Нажмите 'Enter' для перехода в главное меню...");
        sc.nextLine();
        mainMenu();
    }


    private static List<Object> selectFilterCriterian(String criterion, List<Object> data) {
        boolean stopFlag;
        Set<Object> selectedData = new HashSet<>();
        stopFlag = false;
        Scanner input = new Scanner(System.in);
        while (!stopFlag) {
            if (!selectedData.isEmpty()) {
                System.out.println("Выбраны: ");
                System.out.println(selectedData);
            }
            for (int i = 0; i < data.size(); i++) {
                System.out.println((i + 1) + ". " + (data.get(i)));
            }
            System.out.println("0. Применить выбор");
            System.out.println("Введите выбранный номер: ");
            String inputNum = input.nextLine();
            if (isNum(inputNum)) {
                int idx = Integer.parseInt(inputNum) - 1;
                if (idx != -1) {
                    if (idx < data.size()) {
                        selectedData.add(data.get(Integer.parseInt(inputNum) - 1));
                    }
                } else {
                    stopFlag = true;
                }
            }
        }
        return List.of(selectedData.toArray());
    }

    private static List<Object> inputMinMaxParameters(String rusParam, String units) {
        List<Object> result = new ArrayList<>();
        boolean stopFlag = false;
        Scanner input = new Scanner(System.in);
        String inputStr = "";
        while (!stopFlag) {
            System.out.print("Минимальная " + rusParam + " (" + units + "): ");
            inputStr = input.nextLine();
            if (isDouble(inputStr)) {
                result.add(Double.parseDouble(inputStr));
                stopFlag = true;
            } else {
                System.out.println("Введите число!");
            }
        }
        stopFlag = false;
        while (!stopFlag) {
            System.out.print("Максимальная " + rusParam + " (" + units + "): ");
            inputStr = input.nextLine();
            if (isDouble(inputStr)) {
                result.add(Double.parseDouble(inputStr));
                stopFlag = true;
            } else {
                System.out.println("Введите число!");
            }
        }
        return result;
    }

    private static List<Object> inputIntMinMaxParameters(String rusParam, String units) {
        List<Object> result = new ArrayList<>();
        boolean stopFlag = false;
        Scanner input = new Scanner(System.in);
        String inputStr = "";
        while (!stopFlag) {
            System.out.print("Минимальная " + rusParam + " (" + units + "): ");
            inputStr = input.nextLine();
            if (isNum(inputStr)) {
                result.add(Integer.parseInt(inputStr));
                stopFlag = true;
            } else {
                System.out.println("Введите число!");
            }
        }
        stopFlag = false;
        while (!stopFlag) {
            System.out.print("Максимальная " + rusParam + " (" + units + "): ");
            inputStr = input.nextLine();
            if (isNum(inputStr)) {
                result.add(Integer.parseInt(inputStr));
                stopFlag = true;
            } else {
                System.out.println("Введите число!");
            }
        }
        return result;
    }

    private static boolean isNum(String str) {
        try {
            Integer.valueOf(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isDouble(String str) {
        try {
            Double.valueOf(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static Map<String, Set<Object>> getAllStringParams() {
        Map<String, Set<Object>> result = new LinkedHashMap<>();
        for (Object prod : sc) {
            Notebook notebook = (Notebook) prod;
            Map<String, Object> fields = notebook.getFieldsAsMap();
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                if (result.get(entry.getKey()) == null) {
                    Set<Object> values = new HashSet<>();
                    values.add(entry.getValue());
                    result.put((String) entry.getKey(), values);
                } else {
                    Set<Object> values = result.get(entry.getKey());
                    values.add(entry.getValue());
                    result.put(entry.getKey(), values);
                }
            }
        }
        return result;
    }


}