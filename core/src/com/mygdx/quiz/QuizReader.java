// read questions from our csv

package com.mygdx.quiz;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizReader {
    private static String filePath;

    public QuizReader(String filePath){
        QuizReader.filePath = filePath;
    }

    public static ArrayList<Quiz> readQuizzesFromCSV() throws IOException, CsvException {
        ArrayList<Quiz> quizzes = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(String.valueOf(Gdx.files.internal(filePath))))) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                String pathTexture = "img" + row[1] + ".png";
                String question = row[2];
                List<String> options = Arrays.asList(row[4], row[5], row[6], row[7], row[8]);
                int correctOptionIndex = Integer.parseInt(row[9]);
                Texture texture = new Texture(Gdx.files.internal(pathTexture));

                Quiz quiz = new Quiz(question, options, correctOptionIndex, texture);
                quizzes.add(quiz);
            }
        }

        return quizzes;
    }
}

// we can create a quiz list with:
// List<Quiz> quizzes = readQuizzesFromCSV("replace me with the actual file
// path");