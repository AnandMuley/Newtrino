package newtrino.daos;

import newtrino.beans.User;
import newtrino.common.CommonDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest extends CommonDao<User>{

    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateUser(){
        // Given
        User user = testDataUtils.createUser();

        // When
        userDao.create(user);
        User actual = super.findByField("id",user.getId(),User.class);

        // Then
        Assert.assertNotNull(actual);
    }

    @Test
    public void testDeleteUser(){
        // Given
        final int delta = 0;
        final int expected = 1;
        User user = testDataUtils.createUser();
        userDao.create(user);
        User actualUser = super.findByField("id",user.getId(),User.class);
        Assert.assertNotNull(actualUser);

        // When
        int actual = userDao.delete(user.getId());

        // Then
        Assert.assertEquals(expected,actual,delta);
    }

    @Test
    public void testFindUser(){
        // Given
        User user = testDataUtils.createUser();
        userDao.create(user);
        User actualUser = super.findByField("id",user.getId(),User.class);
        Assert.assertNotNull(actualUser);

        // When
        User actual = userDao.find(actualUser.getUsername(),actualUser.getPassword());

        // Then
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFindUserById(){
        // Given
        User user = testDataUtils.createUser();
        userDao.create(user);
        User actualUser = super.findByField("id",user.getId(),User.class);
        Assert.assertNotNull(actualUser);

        // When
        User actual = userDao.findById(actualUser.getId());

        // Then
        Assert.assertNotNull(actual);
    }

}
