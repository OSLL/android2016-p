package ru.videniya239.simpleballistics;

import android.graphics.Rect;

import junit.framework.Assert;

import java.util.ArrayList;

public class LevelManager
{
    private int currentLevelNumber;
    private static LevelManager instance;

    public static LevelManager GetInstance()
    {
        if (instance == null)
        {
            instance = new LevelManager();
        }
        return instance;
    }

    private LevelManager()
    {
        //Initialize();
    }

    private ArrayList<Level> levels;

    public int GetLevelCount() {
        return levels.size();
    }

    public Level GetCurrentLevel()
    {
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

    public void AddLevels(ArrayList<Level> levels)
    {
        for (Level level : levels)
        {
            AddLevel(level);
        }
    }

   /* public void Initialize()
    {
        //if (levels == null)

    }*/

    private void CreateLevels()
    {
        Level level1 = new Level();
        level1.Init(MainActivity.level1Texture, MainActivity.level1Map, 50,
                new Rect((int)(GameController.screenWidth * 14f / 700f),
                         (int)(GameController.screenHeight * 253f / 349f),
                        (int)(GameController.screenWidth * 73f / 700f),
                        (int)(GameController.screenHeight * 289f / 349f)),
                new Rect((int)(GameController.screenWidth * 19f / 700f),
                        (int)(GameController.screenHeight * 239f / 349f),
                        (int)(GameController.screenWidth * 81f / 700f),
                        (int)(GameController.screenHeight * 272f / 349f)));
        levels.add(level1);

        /*Level level1 = new Level();
        level1.Init(MainActivity.level1Texture, MainActivity.level1Map, 50,
                new Rect((int)(GameController.screenWidth * 14f / 700f),
                        (int)(GameController.screenHeight * 253f / 349f),
                        (int)(GameController.screenWidth * 73f / 700f),
                        (int)(GameController.screenHeight * 289f / 349f)),
                new Rect((int)(GameController.screenWidth * 19f / 700f),
                        (int)(GameController.screenHeight * 239f / 349f),
                        (int)(GameController.screenWidth * 81f / 700f),
                        (int)(GameController.screenHeight * 272f / 349f)));
        levels.add(level1);*/

       /* Level level2 = new Level();
        level2.Init(MainActivity.level1Texture, MainActivity.level1Map, 0);
        levels.add(level2);*/
    }

    public void Reset()
    {
        currentLevelNumber = 0;
        {
            levels = new ArrayList<Level>();
        }
        currentLevelNumber = 0;

        //GameController.
        CreateLevels();
        //Initialize();
    }

    public void SetLevel(int number)
    {
        if ((number < 1) || (number > GetLevelCount()))
            Assert.fail("Попытка обратиться к несуществующему уровню.");
        SetInternalCurrentLevelNumber(number);
        levels.get(GetInternalCurrentLevelNumber()).Start();
    }

    public void MoveNext()
    {
        SetLevel(currentLevelNumber + 1);
    }

    public void AddLevel(Level level)
    {
        levels.add(level);
    }
}
