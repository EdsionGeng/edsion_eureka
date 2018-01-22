package com.wsd.job;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.TimerTask;

public class TimeTask extends TimerTask {

    public void run() {
        try {
            String DriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String URL = "jdbc:sqlserver://10.26.92.152;DatabaseName=ws_db2";
            String username = "ws_db";
            String pwd = "akc8mxu37dcA1";
            Class.forName(DriverName);
            Connection connection = DriverManager.getConnection(URL, username, pwd);
            Statement st = connection.createStatement();
            String sql = "update usertime set time=10,share=0;";
            st.executeUpdate(sql);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
