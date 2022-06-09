package com.revature.taskmaster.daos;

import com.revature.taskmaster.entities.Task;
import com.revature.taskmaster.entities.User;
import com.revature.taskmaster.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public List<Task> getTasksByCreatorId(String creatorId) {

        List<Task> tasks = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM tasks WHERE creator_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, creatorId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getString("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setPointValue(rs.getInt("point_value"));
                task.setCreator(new User(rs.getString("creator_id")));
                task.setAssignee(new User(rs.getString("assignee_id")));
                task.setLabel(rs.getString("label"));
                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }
}
