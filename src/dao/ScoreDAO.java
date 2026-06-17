package dao;

import database.DBConnection;
import model.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {

    // ============================
    // Save Score
    // ============================

    public boolean save(Score score) {

        String sql =
                "INSERT INTO scores(user_id, maze_number, commands) VALUES(?,?,?)";

        try (

                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setInt(1, score.getUserId());

            statement.setInt(2, score.getMazeNumber());

            statement.setInt(3, score.getCommands());

            return statement.executeUpdate() > 0;

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    // ============================
    // Get All Scores
    // ============================

    public List<Score> getAllScores() {

        List<Score> scores =
                new ArrayList<>();

        String sql =
                "SELECT * FROM scores";

        try (

                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet resultSet =
                        statement.executeQuery()

        ) {

            while (resultSet.next()) {

                Score score =
                        new Score();

                score.setId(
                        resultSet.getInt("id"));

                score.setUserId(
                        resultSet.getInt("user_id"));

                score.setMazeNumber(
                        resultSet.getInt("maze_number"));

                score.setCommands(
                        resultSet.getInt("commands"));

                scores.add(score);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return scores;

    }

    // ============================
    // Get Scores By User
    // ============================

    public List<Score> getScoresByUser(int userId) {

        List<Score> scores =
                new ArrayList<>();

        String sql =
                "SELECT * FROM scores WHERE user_id=?";

        try (

                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setInt(1, userId);

            ResultSet resultSet =
                    statement.executeQuery();

            while (resultSet.next()) {

                Score score =
                        new Score();

                score.setId(
                        resultSet.getInt("id"));

                score.setUserId(
                        resultSet.getInt("user_id"));

                score.setMazeNumber(
                        resultSet.getInt("maze_number"));

                score.setCommands(
                        resultSet.getInt("commands"));

                scores.add(score);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return scores;

    }

}