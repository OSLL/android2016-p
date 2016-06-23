package ru.videniya239.simpleballistics;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

public class LevelManager
{
    private int currentLevelNumber;

    public boolean lose;
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

    }

    private ArrayList<Level> levels;

    public int GetLevelCount() {
        return levels.size();
    }

    public Level GetCurrentLevel()
    {
        if (levels != null)
            if (GetCurrentLevelNumber() >= 1)
        return levels.get(GetInternalCurrentLevelNumber());
        else
            return null;
        else
            return null;
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

   private void CreateLevels()
   {
       lose = false;
       Random random = new Random();
       int windVelocity = random.nextInt(70) + 30;

       Level level1 = new Level();
       level1.Init(MainActivity.level1Texture, MainActivity.level1Map, windVelocity,
               new Vector2(GameController.screenWidth * 19f / 700f, GameController.screenHeight * 239f / 349f), 1);
       levels.add(level1);

       windVelocity = random.nextInt(70) + 30;
       Level level2 = new Level();
       level2.Init(MainActivity.level2Texture, MainActivity.level2Map, windVelocity,
               new Vector2(GameController.screenWidth * 26f/1880f, GameController.screenHeight * 685f / 951f), 2);
       levels.add(level2);

       windVelocity = random.nextInt(50) + 30;
       Level level3 = new Level();
       level3.Init(MainActivity.level3Texture, MainActivity.level3Map, windVelocity,
               new Vector2(GameController.screenWidth * 26f/1880f, GameController.screenHeight * 185f / 951f), 3);
       levels.add(level3);

       windVelocity = random.nextInt(70) + 30;
       Level level4 = new Level();
       level4.Init(MainActivity.level4Texture, MainActivity.level4Map, windVelocity,
               new Vector2(GameController.screenWidth * 26f/1880f, GameController.screenHeight * 655f / 951f), 4);
       levels.add(level4);

       windVelocity = random.nextInt(70) + 30;
       Level level5 = new Level();
       level5.Init(MainActivity.level5Texture, MainActivity.level5Map, windVelocity,
               new Vector2(GameController.screenWidth * 26f/1880f, GameController.screenHeight * 655f / 951f), 5);
       levels.add(level5);

   }

    public void Reset()
    {
        currentLevelNumber = 0;
        {
            levels = new ArrayList<Level>();
        }
        currentLevelNumber = 0;

        CreateLevels();
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
