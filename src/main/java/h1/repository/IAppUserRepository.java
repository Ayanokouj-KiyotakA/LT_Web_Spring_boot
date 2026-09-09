package h1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import h1.entity.AppUser;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

	// Tim theo username/fullname/email chua tu khoa (khong phan biet hoa/thuong)
	List<AppUser> findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
			String userName, String fullName, String email);

}
