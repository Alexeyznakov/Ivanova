package Znakov.Practice5;

public class Practice2 {
    public static void main(String[] args) {
        System.out.println(toTitleCase("Hello, my name is Znakov, i'm learning java"));
    }
    /*Розбиваю рядок на масив слів по розділювачу пропуск(через метод split). Беру кожне слово
     * і роблю перший символ великим(через класс Character). Потім через StringBuilder додаю кожен
     * елемент масиву слів і після кожного слова додаю пропуск. */
    public static String toTitleCase(String givenString) {
        String[] arr = givenString.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
}
