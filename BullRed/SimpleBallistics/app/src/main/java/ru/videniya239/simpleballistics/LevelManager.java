package ru.videniya239.simpleballistics;

import junit.framework.Assert;

import java.util.ArrayList;

public class LevelManager
{
    private int currentLevelNumber;
    private static LevelManager instance;

    public static LevelManager GetInstance() {
        if (instance == null)
            instance = new LevelManager();
        return instance;
    }

    private LevelManager() {
        Initialize();
    }

    private ArrayList<Level> levels;

    public int GetLevelCount() {
        return levels.size();
    }

    public Level GetCurrentLevel() {
        return levels.get(GetInternalCurrentLevelNumber());
    }

    public int GetCurrentLevelNumber() {
        return currentLevelNumber;
    }

    private int GetInternalCurrentLevelNumber() {
        return currentLevelNumber - 1;
    }

    private void SetInternalCurrentLevelNumber(int value) {
        currentLevelNumber = value;
    }

    public ArrayList<Level> GetLevels() {
        return levels;
    }

    public void AddLevels(ArrayList<Level> levels) {
        for (Level level : levels) {
            AddLevel(level);
        }
    }

    public void Initialize() {
        if (levels == null) {
            levels = new ArrayList<Level>();
        }

        CreateLevels();
    }

    private void CreateLevels()
    {
        Level level1 = new Level();
        level1.Init(MainActivity.level1, MainActivity.level1, 0);
        levels.add(level1);

        levels.add(level1);
    }

    public void Reset()
    {
        currentLevelNumber = 0;
    }

    public void SetLevel(int number) {
        if ((number < 1) || (number > GetLevelCount()))
            Assert.fail("Попытка обратиться к несуществующему уровню.");
        SetInternalCurrentLevelNumber(number);
        levels.get(GetInternalCurrentLevelNumber()).Start();
    }

    public void MoveNext() {
        SetLevel(currentLevelNumber + 1);
    }

    public void AddLevel(Level level)
    {
        levels.add(level);
    }
}
