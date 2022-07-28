package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	
	public static final Logger LOGGER = LogManager.getLogger();
	


	@Override
	public List<Order> readAll() {
	      try (Connection connection = DBUtils.getInstance().getConnection();
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
	            List<Order> order = new ArrayList<>();
	            while (resultSet.next()) {
	                order.add(modelFromResultSet(resultSet));
	            }
	            return order;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	    }
	
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	

	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	@Override
	public Order create(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id) VALUES(?)");) {
			statement.setLong(1, t.getCustomer_id());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				 PreparedStatement statement = connection
			                .prepareStatement("UPDATE orders SET id = ?, customer_id = ? WHERE id = ?");) {
			            statement.setLong(1, t.getId());
			            statement.setLong(2, t.getCustomer_id());
			            statement.setLong(3, t.getId());
			            statement.executeUpdate();
			            return read(t.getId());
			        } catch (Exception e) {
			            LOGGER.debug(e);
			            LOGGER.error(e.getMessage());
			        }
			        return null;
	}

	@Override
	public int delete(long id) {
    	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
        return 0;
	}

    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
    	long id = resultSet.getLong("id");
		Long customer_id = resultSet.getLong("customer_id");
		return new Order(id, customer_id);
    }

}
