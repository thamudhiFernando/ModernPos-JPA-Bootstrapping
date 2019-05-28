package lk.ijse.pos.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EntityManagerUtil {

    public static EntityManager getEntityManager() {
        Properties properties = null;
        try {
            File propFile = new File("resources/application.properties");
            properties = new Properties();
            FileReader fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }
}
