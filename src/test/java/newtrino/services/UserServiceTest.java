package newtrino.services;

import newtrino.beans.User;
import newtrino.common.DefaultConfiguration;
import newtrino.daos.UserDao;
import newtrino.dtos.UserDto;
import newtrino.utils.BeanCreatorUtilImpl;
import newtrino.utils.DateConverterUtilImpl;
import newtrino.utils.DtoCreatorUtilImpl;
import org.jmock.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends DefaultConfiguration {

    private UserServiceImpl userService;

    private UserDao mockUserDao;

    @Before
    public void setUp(){
        userService = new UserServiceImpl();
        mockUserDao = context.mock(UserDao.class);
        beanCreatorUtil = new BeanCreatorUtilImpl();
        dtoCreatorUtil = new DtoCreatorUtilImpl();
        dateConverterUtil = new DateConverterUtilImpl();

        ReflectionTestUtils.setField(userService,"userDao",mockUserDao);
        ReflectionTestUtils.setField(userService,"beanCreatorUtil",beanCreatorUtil);
        ReflectionTestUtils.setField(userService,"dtoCreatorUtil",dtoCreatorUtil);
        ReflectionTestUtils.setField(beanCreatorUtil,"dateConverterUtil",dateConverterUtil);
        ReflectionTestUtils.setField(dtoCreatorUtil,"dateConverterUtil",dateConverterUtil);
    }

    @Test
    public void testCreateUser(){
        // Given
        final String birthDate = "20-Jan-1988";
        final UserDto userDto = testDataUtils.createUserDto(birthDate);
        final int expectedAge = 27;

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockUserDao).create(with(any(User.class)));
            }
        });
        userService.create(userDto);

        // Then
        Assert.assertEquals(expectedAge,userDto.getAge());
    }

    @Test
    public void testDeleteUser(){
        // Given
        final String userId = "UID101";
        final int expected = 1;

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockUserDao).delete(with(userId));
                will(returnValue(expected));
            }
        });
        int actual = userService.delete(userId);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindUser(){
        // Given
        final String username = "username";
        final String password = "password";
        final User expected = testDataUtils.createUser();

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockUserDao).find(with(username), with(password));
                will(returnValue(expected));
            }
        });
        UserDto actual = userService.find(username, password);

        // Then
        Assert.assertNotNull(actual);
    }

    @Test
    public void testFindUserById(){
        // Given
        final String userId = "UID101";
        final User expected = testDataUtils.createUser();

        // When
        context.checking(new Expectations(){
            {
                oneOf(mockUserDao).findById(with(userId));
                will(returnValue(expected));
            }
        });
        UserDto actual = userService.findById(userId);

        // Then
        Assert.assertNotNull(actual);
    }


}
