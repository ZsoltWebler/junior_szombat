package java_collections;

import java.util.*;
import java.util.stream.Collectors;

public class QuizManager {

    private final List<Question> questionList;

    public QuizManager(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<String> getQuestionsByGenre(String genre) {

        return questionList.stream().filter(question -> question.getGenre().equals(genre)).map(Question::getQuestion).toList();

    }

    public Map<String, List<Question>> getQuestionGroupedByGenre() {
        return questionList.stream().collect(Collectors.groupingBy(Question::getGenre));
    }

    public List<String> randomQuestions(int amount) {

        Set<String> questions = new HashSet<>();
        Random rnd = new Random();

        while (questions.size() < amount) {

            questions.add(questionList.get(rnd.nextInt(questionList.size())).getQuestion());

        }

        return new ArrayList<>(questions);
    }

    public String genreWithMaxScore() {

        Map<String, List<Question>> questionGroupedByGenre = getQuestionGroupedByGenre();


        String candidate = null;
        int max = Integer.MIN_VALUE;
        for (String genre : questionGroupedByGenre.keySet()) {

            int sumByGenre = questionGroupedByGenre.get(genre).stream().mapToInt(Question::getScore).sum();

            if (sumByGenre > max) {
                candidate = genre;
                max = sumByGenre;
            }

        }

        return candidate;



    }


}
