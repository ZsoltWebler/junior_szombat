package java_basics;

public class NamingConventionConverter {


    public static String toSnakeCase(String sentence, boolean toUppercase) {

        String[] words = sentence.split(" ");

        StringBuilder snakeCase = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            snakeCase.append(toUppercase ? (words[i].toUpperCase()) : words[i]);
            snakeCase.append("_");
        }
        snakeCase.append(toUppercase ? (words[words.length - 1].toUpperCase()) : words[words.length - 1]);
        return snakeCase.toString();

    }

    public static String toCamelCase(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder camelCase = new StringBuilder();

        camelCase.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            String firstChar = words[i].substring(0, 1);
            String remainingChars = words[i].substring(1, words[i].length());
            camelCase.append(firstChar.toUpperCase() + remainingChars);
        }
        return camelCase.toString();
    }

    public static String toPascalCase(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder pascalCase = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String firstChar = words[i].substring(0, 1);
            String remainingChars = words[i].substring(1, words[i].length());
            pascalCase.append(firstChar.toUpperCase() + remainingChars);
        }
        return pascalCase.toString();
    }

    public static String toKebabCase(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder snakeCase = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            snakeCase.append(words[i]);
            snakeCase.append("-");
        }
        snakeCase.append(words[words.length - 1]);
        return snakeCase.toString();
    }


}
