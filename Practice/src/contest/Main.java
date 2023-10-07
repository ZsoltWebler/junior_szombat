package contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Question> questions = new ArrayList<>();
    public static void main(String[] args) {
        try {
            File file = new File("C:\\_Projects\\School\\Java_Zsolttal\\clone_test\\junior_szombat\\Practice\\kerdesek.txt");
            Scanner sc = new Scanner(file);
            createQuestions(sc);
            System.out.println("\nTörténelem kérdések: ");
            questionsByTopic("tortenelem").forEach(System.out::println);
            System.out.println("\nFöldrajz kérdések: ");
            questionsByTopic("foldrajz").forEach(System.out::println);
            System.out.println("\nRandom kérdések (15): ");
            getRandomQuestions(15).forEach(System.out::println);
            System.out.println("\nRandom kérdések (200): ");
            getRandomQuestions(200).forEach(System.out::println);
            System.out.println("\nTéma alapján csoportosított kérdések:");
            groupQuestionsByTopics().forEach(System.out::println);

            System.out.println("\nA legtöbb pontot a " + mostWorthyTopic() + " téma kérdései érik.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Question> getRandomQuestions(int n) {
        /*int _n;
        List<Question> _questions = new ArrayList<>();
        List<Question> questionsToReturn = new ArrayList<>();
        Random random = new Random();
        _questions.addAll(questions);
        if(n > _questions.size()){
            _n = _questions.size();
        }else{
            _n = n;
        }
        for (int i = 0; i < _n; i++) {
            Question q = _questions.get(random.nextInt(_questions.size()));
            questionsToReturn.add(q);
            _questions.remove(q);
        }
        return questionsToReturn;*/
        if (n >= questions.size()) {
            return questions;
        }

        Random random = new Random();
        return random.ints(0, questions.size())
                .distinct()
                .limit(n)
                .mapToObj(questions::get)
                .collect(Collectors.toList());
    }

    private static List<String> questionsByTopic(String topic) {
        return questions.stream()
                .filter(question -> question.topic.equals(topic))
                .map(Question::getQuestion)
                .collect(Collectors.toList());
    }
    private static List<Map.Entry<String, List<Question>>> groupQuestionsByTopics(){
        return questions.stream()
                .collect(Collectors.groupingBy(Question::getTopic))
                .entrySet()
                .stream()
                .toList();
    }

    private static String mostWorthyTopic(){
        return questions.stream()
                .collect(Collectors.groupingBy(Question::getTopic, Collectors.summingInt(Question::getPoint)))
                .entrySet()
                .stream()
//                .peek(System.out::println)
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();


    }

    private static void createQuestions(Scanner sc) {
        while (sc.hasNextLine()){
            String q = sc.nextLine();
            String[] data = sc.nextLine().split(" ");
            String answ = data[0];
            int p = Integer.parseInt(data[1]);
            String t = data[2];
            questions.add(new Question(q,answ, p, t));
        }
    }



}
