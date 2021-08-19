package com.tcs.fitness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FitnessTracker {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/fitness-tracker";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			// createUser(statement);
			createTrainer(statement);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void createUser(Statement statement) throws SQLException {
		statement.execute("INSERT INTO User VALUES(9988776655, 'Manoj', 'manoj@gmail.com','M', 0000-00-00, 'Nasik')");
	}

	private static void createTrainer(Statement statement) throws SQLException {
		statement.execute("INSERT INTO Trainers Values(001, 'Male', 'Santosh kumar', 7766112233, 500)");
	}

}
