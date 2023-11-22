// read questions from our csv

package com.mygdx.quiz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizReader {

    public static List<Quiz> readQuizzesFromCSV(String filePath) throws IOException, CsvException {
        List<Quiz> quizzes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                String question = row[0];
                List<String> options = List.of(row[1], row[2], row[3], row[4], row[5]);
                int correctOptionIndex = Integer.parseInt(row[6]);

                Quiz quiz = new Quiz(question, options, correctOptionIndex);
                quizzes.add(quiz);
            }
        }

        return quizzes;
    }
}

// we can create a quiz list with:
// List<Quiz> quizzes = readQuizzesFromCSV("replace me with the actual file
// path");