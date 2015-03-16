package newtrino.services;

import newtrino.beans.User;
import newtrino.daos.UserDao;
import newtrino.dtos.UserDto;
import newtrino.utils.BeanCreatorUtil;
import newtrino.utils.DtoCreatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BeanCreatorUtil beanCreatorUtil;

    @Autowired
    private DtoCreatorUtil dtoCreatorUtil;

    @Override
    public void create(UserDto userDto) {
        User user = beanCreatorUtil.createUserBean(userDto);
        calculateAge(user);
        userDao.create(user);
        userDto.setId(user.getId());
        userDto.setAge(user.getAge());
    }

    private void calculateAge(User user){
        Calendar calendar = Calendar.getInstance();
        int currYear = calendar.get(Calendar.YEAR);
        calendar.setTime(user.getBirthDate());
        int birthYear = calendar.get(Calendar.YEAR);
        int age = currYear - birthYear;
        user.setAge(age);
    }

    @Override
    public int delete(String userId) {
        return userDao.delete(userId);
    }

    @Override
    public UserDto find(String username, String password) {
        return dtoCreatorUtil.createUserDto(userDao.find(username,password));
    }

    @Override
    public UserDto findById(String userId) {
        return dtoCreatorUtil.createUserDto(userDao.findById(userId));
    }
}
