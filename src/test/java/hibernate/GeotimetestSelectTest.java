package hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import wm.login.BaseTest;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

@Test
@Features("JDBC Connection")
public class GeotimetestSelectTest extends BaseTest {


    @Override
    @BeforeClass
    public void init(){

    }

    @Test
    @Stories("Hibernate test")
    @Severity(value = SeverityLevel.TRIVIAL)
    public void baseTest() throws IOException {

        Session session = SessionBuilderWrapper.getSession();

        session.beginTransaction();

        Criteria criteria = session.createCriteria(Geotimetest.class);
        criteria.add((Restrictions.eq("test", "loginTimeTest")));
        criteria.add((Restrictions.eq("geo", "RU")));

        List list = criteria.list();
        session.getTransaction().commit();

        for(Object test:list){
            System.out.println(test);
        }
        assertTrue(false);


    }


}