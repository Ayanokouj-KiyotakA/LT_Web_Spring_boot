package h1.service;

import java.util.List;
import java.util.Optional;

import h1.entity.AppUser;

public interface IAppUserService {

	List<AppUser> findAll();

	List<AppUser> search(String keyword);

	Optional<AppUser> findById(Integer id);

	AppUser save(AppUser user);

	void deleteById(Integer id);

}
