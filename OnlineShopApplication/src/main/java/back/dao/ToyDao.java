package dao;

import entity.ToyEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ToyDao implements Dao<ToyEntity>{
    @Override
    public void add(ToyEntity toyEntity) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();

            String sql = "INSERT INTO cart (name, toy_id, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, toyEntity.getName());
            statement.setInt(2, toyEntity.getToyId());
            statement.setInt(3, toyEntity.getPrice());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                toyEntity.setId(Integer.parseInt(generatedKeys.getString(1)));
            }
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public ToyEntity getById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<ToyEntity> getList(Filter filter) throws DaoException {
        ConnectionPool pool = null;
        Connection connection = null;
        try {
            pool = ConnectionPool.getConnectionPool();
            connection = pool.getConnection();

            PreparedStatement statement;
            if (filter.existTestId() && filter.existCustomerId()) {
                String sql = "SELECT * FROM toys t";
                statement = connection.prepareStatement(sql);
            } else {
                String sql = "SELECT * FROM  toys t";
                statement = connection.prepareStatement(sql);
            }

            ResultSet resultSet = statement.executeQuery();
            LinkedList<ToyEntity> toys = new LinkedList<ToyEntity>();
            while (resultSet.next()) {
                int id = resultSet.getInt("toy.id");
                String text = resultSet.getString("toy.name");
                int price = resultSet.getInt("toy.price");

                ToyEntity toy = new ToyEntity();
                toy.setToyId(id);
                toy.setName(text);
                toy.setPrice(price);

                toys.add(toy);
            }

            return toys;
        } catch (SQLException | ConnectionException e) {
            throw new DaoException(e);
        } finally {
            if (pool != null)
                pool.returnConnection(connection);
        }
    }

    @Override
    public void delete(ToyEntity toyEntity) throws DaoException {

    }
}
