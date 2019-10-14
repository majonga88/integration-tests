package test;

import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.time.Duration;

public class MyIT {

    private static DataSource dataSource;

    @BeforeClass
    public static void init() throws InterruptedException{
        // the maven-docker-plugin already waits. no need to do it here.
        String port = System.getProperty("oracle.port", "1521");
        String url = "jdbc:oracle:thin:@localhost:"+ port +":ORCLCDB";
        System.out.println("Oracle URL: " + url);
        dataSource = DataSourceBuilder.create()
                .url(url)
                .username("TESTIT")
                .password("mysecret")
                .driverClassName("oracle.jdbc.OracleDriver")
                .build();

    }

    @Test
    public void foo(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("SELECT * FROM DUAL");
    }
}
