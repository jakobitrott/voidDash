package com.Jakob;

import java.io.Serializable;

/**
 * Created by jakob on 09/08/2017.
 */
public class Score implements Serializable {
  private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
