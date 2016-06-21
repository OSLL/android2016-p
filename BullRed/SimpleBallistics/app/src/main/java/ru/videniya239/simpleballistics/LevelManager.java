package ru.videniya239.simpleballistics;

import android.graphics.Rect;
import android.util.Log;

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
        //(int)


        Level level1 = new Level();
        level1.Init(MainActivity.level1Texture, MainActivity.level1Map, 50,
                new Rect((int)(GameController.screenWidth * 14f / 700f),
                         (int)(GameController.screenHeight * 253f / 349f),
                        (int)(GameController.screenWidth * 73f / 700f),
                        (int)(GameController.screenHeight * 289f / 349f)),
                new Rect((int)(GameController.screenWidth * 19f / 700f),
                        (int)(GameController.screenHeight * 239f / 349f),
                        (int)(GameController.screenWidth * 81f / 700f),
                        (int)(GameController.screenHeight * 272f / 349f)),
                new Vector2(GameController.screenWidth * 54f / 700f,
                        GameController.screenHeight * 256f / 349f),
                1);
        levels.add(level1);

        Level level2 = new Level();
        level2.Init(MainActivity.level2Texture, MainActivity.level2Map, 50,
                new Rect((int)(GameController.screenWidth * 19f / 1880f),
                        (int)(GameController.screenHeight * 716f / 951f),
                        (int)(GameController.screenWidth * 154f / 1880f),
                        (int)(GameController.screenHeight * 813f / 951f)),
                new Rect((int)(GameController.screenWidth * 26f / 1880f),
                        (int)(GameController.screenHeight * 675f / 951f),
                        (int)(GameController.screenWidth * 188f / 1880f),
                        (int)(GameController.screenHeight * 775f / 951f)),
                new Vector2(GameController.screenWidth * 115f / 1880f,
                        GameController.screenHeight * 728f / 951f),
                2);
        levels.add(level2);

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
        Log.d("levelManager", "Устанавливаем уровень " + currentLevelNumber);
        levels.get(GetInternalCurrentLevelNumber()).Start();
    }

    public void MoveNext()
    {
        Log.d("levelmanager", "было: " + currentLevelNumber);
        SetLevel(currentLevelNumber + 1);
        Log.d("levelmanager", "стало: " + currentLevelNumber);
    }

    public void AddLevel(Level level)
    {
        levels.add(level);
    }
}
