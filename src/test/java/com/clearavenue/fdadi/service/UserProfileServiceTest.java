package com.clearavenue.fdadi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.clearavenue.fdadi.model.Medication;
import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.repository.UserProfileRepository;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserProfileServiceTest {

	@Mock
	private UserProfileRepository repo;

	@InjectMocks
	private UserProfileService service;

	@Test
	void deleteAll() {
		service.deleteAll();
		assertDoesNotThrow(() -> {
		});
	}

	@Test
	void saveUser() {
		final UserProfile expected = UserProfile.builder().userId("demo").password("pwd").build();
		given(repo.save(expected)).willReturn(expected);

		final UserProfile actual = service.saveUser(expected);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void saveExistingUser() {
		final Medication med1 = Medication.builder().id(1L).medicationName("one").build();
		final UserProfile existing = UserProfile.builder().userId("demo").password("pwd").medications(List.of(med1)).build();
		given(repo.findByUserId(existing.getUserId())).willReturn(Optional.of(existing));

		final UserProfile expected = UserProfile.builder().userId("demo").password("pwd").medications(List.of(med1)).build();
		given(repo.save(expected)).willReturn(expected);

		final UserProfile actual = service.saveUser(expected);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void saveUserNoUserId() {
		final UserProfile expected = UserProfile.builder().password("pwd").build();
		given(repo.save(expected)).willReturn(expected);

		final UserProfile actual = service.saveUser(expected);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void saveUserNoPwd() {
		final UserProfile expected = UserProfile.builder().userId("demo").build();
		given(repo.save(expected)).willReturn(expected);

		final UserProfile actual = service.saveUser(expected);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getUser() {
		service.getUser("demo");
	}

	@Test
	void getAllUsers() {
		final UserProfile one = UserProfile.builder().userId("one").password("pwd").build();
		final UserProfile two = UserProfile.builder().userId("two").password("pwd").build();
		final UserProfile three = UserProfile.builder().userId("three").password("pwd").build();
		given(repo.findAll()).willReturn(List.of(one, two, three));
		final var list = service.getAllUsers();
		assertThat(list.size()).isEqualTo(3);
	}

}
