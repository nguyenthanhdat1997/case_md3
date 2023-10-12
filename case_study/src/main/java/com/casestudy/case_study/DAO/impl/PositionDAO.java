package com.casestudy.case_study.DAO.impl;

import com.casestudy.case_study.DAO.IPositionDAO;
import com.casestudy.case_study.model.Position;
import com.casestudy.case_study.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements IPositionDAO {
    private final String SELECT_ALL_POSITION = "select * from positions where is_delete = 0";
    private final String INSERT = "insert into positions(name) values(?);";
    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                positions.add(new Position(id,name));
            }
        } catch (SQLException e) {
            System.out.printf(e.getMessage());
        }
        return positions;
    }

    @Override
    public Position findById(Long id) {
        return null;
    }

    @Override
    public boolean add(Position object) {return false;}

    @Override
    public boolean update(Position object) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
