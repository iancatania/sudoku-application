package project3exceptions;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class PuzzlePool {

    private File[] files = new File[100];

    private int count = 0;
    private int invalidCount = 0;

    private ArrayList<SudokuPuzzle> workingFiles = new ArrayList();
    private SudokuPuzzle sp = new SudokuPuzzle();

    /**
     *
      * @param path
     */
    public void loadFiles(Path path) {

        for (int i = 0; i < count; i++)
            files[i].getPath();

        File[] tempFiles;
        File aFile;

        aFile = new File(path.toString());
        tempFiles = aFile.listFiles();

        for (File file : tempFiles) {
            if (file.isFile()) {
                if (sp.initializePuzzle(file) == true) {
                    workingFiles.add(sp);
                    sp = new SudokuPuzzle();
                }
                else
                    invalidCount++;
            }
            else if (file.isDirectory())
                loadFiles(Paths.get(file.toString()));
        }
    }

    /**
     *
     * @return
     */
    public SudokuPuzzle selectPuzzle() {
        Random r = new Random();
        return workingFiles.get(r.nextInt(workingFiles.size()));
    }

    /**
     *
     * @return
     */
    public String invalidCount() {
        return "There are " + invalidCount + " invalid files.";
    }

    /**
     *
     * @return
     */
    public String totalFileCount() {
        count = workingFiles.size() + invalidCount;
        return "There are " + count + " total files.";
    }
}

