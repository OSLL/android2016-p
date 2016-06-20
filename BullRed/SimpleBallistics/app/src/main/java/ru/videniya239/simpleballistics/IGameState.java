package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

public interface IGameState
{
    void Update(float deltaT);
    void Draw(Canvas canvas);
    void InvokeState();
    void EndState();
}
