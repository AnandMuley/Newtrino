package newtrino.services;

import newtrino.dtos.UserDto;

public interface UserService {

    void create(UserDto userDto);

    int delete(String userId);

    UserDto find(String username,String password);

    UserDto findById(String userId);

}
