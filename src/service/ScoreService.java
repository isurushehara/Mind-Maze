package service;

import dao.ScoreDAO;
import model.Score;

import java.util.List;

public class ScoreService {

    private final ScoreDAO scoreDAO;

    public ScoreService() {

        scoreDAO = new ScoreDAO();

    }

    public boolean saveScore(Score score) {

        return scoreDAO.save(score);

    }

    public List<Score> getAllScores() {

        return scoreDAO.getAllScores();

    }

    public List<Score> getScoresByUser(int userId) {

        return scoreDAO.getScoresByUser(userId);

    }

}