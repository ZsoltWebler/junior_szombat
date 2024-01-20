package java_collections.tests;

import java_collections.Question;
import java_collections.QuizManager;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuizManagerTest {


    List<Question> questionList = List.of(
            new Question("Question_1", "Answer_1", 10, "History"),
            new Question("Question_2", "Answer_2", 10, "History"),
            new Question("Question_3", "Answer_3", 10, "Math"),
            new Question("Question_4", "Answer_4", 10, "Geography")
    );

    QuizManager manager = new QuizManager(questionList);


    @Test
    public void testGetQuestionsByGenre() {

        List<String> expected = List.of("Question_1", "Question_2");
        List<String> actual = manager.getQuestionsByGenre("History");

        assertEquals(expected, actual);

    }

    @Test
    public void testGetQuestionGroupedByGenre() {

        Map<String, List<Question>> expected =
                Map.of("Geography", List.of(new Question("Question_4", "Answer_4", 10, "Geography")),
                        "Math", List.of(new Question("Question_3", "Answer_3", 10, "Math")),
                        "History", List.of(new Question("Question_1", "Answer_1", 10, "History"),
                                new Question("Question_2", "Answer_2", 10, "History")));
        Map<String, List<Question>> actual = manager.getQuestionGroupedByGenre();

        assertEquals(expected, actual);

    }

    @Test
    public void testRandomQuestions() {

        int expectedSize = 2;
        List<String> actual = manager.randomQuestions(expectedSize);

        assertEquals(expectedSize, actual.stream().distinct().toList().size());

        List<String> allQuestion = questionList.stream().map(Question::getQuestion).toList();

        for(String randomQuestion:actual){
            assertTrue(allQuestion.contains(randomQuestion));
        }
    }

    @Test
    public void testGenreWithMaxScore() {

        String expected = "History";
        String actual = manager.genreWithMaxScore();

        assertEquals(expected, actual);
    }

}
