package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

public class EndLevelState implements IGameState
{
    @Override
    public void Update(float deltaT) {

    }

    @Override
    public void Draw(Canvas canvas) {

    }

    @Override
    public void InvokeState()
    {
        GameController.setGamePhase(GameState.PHASE_PLAY);
    }

    @Override
    public void EndState()
    {

    }
}
