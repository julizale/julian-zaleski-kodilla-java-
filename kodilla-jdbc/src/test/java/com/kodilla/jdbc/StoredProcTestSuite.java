package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=0";

        statement.executeUpdate(sqlUpdate);

        String sqlSelectExpectedBestsellers = "SELECT COUNT(*) AS HOW_MANY FROM (SELECT NULL FROM RENTS" +
                " GROUP BY BOOK_ID HAVING COUNT(*) > 2) T1";
        ResultSet expectedBestsellers = statement.executeQuery(sqlSelectExpectedBestsellers);
        int howManyExpected = -1;
        if (expectedBestsellers.next()) {
            howManyExpected = expectedBestsellers.getInt("HOW_MANY");
        }

        //When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);
        String sqlSelectActualBestsellers = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet actualBestsellers = statement.executeQuery(sqlSelectActualBestsellers);
        int howManyActual = -1;
        if (actualBestsellers.next()) {
            howManyActual = actualBestsellers.getInt("HOW_MANY");
        }

        //Then
        assertEquals(howManyExpected, howManyActual);
        expectedBestsellers.close();
        actualBestsellers.close();
        statement.close();
    }
}