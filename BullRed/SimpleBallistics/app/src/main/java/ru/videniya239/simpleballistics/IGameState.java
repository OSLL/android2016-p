package ru.videniya239.simpleballistics;

import android.graphics.Canvas;

/**
 * Created by user on 6/17/2016.
 */
public interface IGameState
{
    void Update(float deltaT);
    void Draw(Canvas canvas);
    void InvokeState();
}
