package h1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import h1.entity.AppUser;
import h1.repository.IAppUserRepository;

@Service
public class AppUserService implements IAppUserService {

	private final IAppUserRepository userRepository;

	public AppUserService(IAppUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<AppUser> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<AppUser> search(String keyword) {
		if (!StringUtils.hasText(keyword)) {
			return findAll();
		}
		String k = keyword.trim();
		return userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(k,
				k, k);
	}

	@Override
	public Optional<AppUser> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public AppUser save(AppUser user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}
