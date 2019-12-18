package com.clearavenue.fdadi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.clearavenue.fdadi.model.UserProfile;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserProfileRepositoryTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserProfileRepository repo;

	@Test
	void injectedComponentsAreNotNull() {
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(repo).isNotNull();
	}

	@Test
	public void saveTest() {
		final UserProfile preSave = UserProfile.builder().userId("DemoUser").password("DemoPwd").build();
		assertThat(preSave.getId()).isNull();

		final UserProfile postSave = repo.save(preSave);
		assertThat(postSave.getId()).isNotNull();
		assertThat(postSave.getUserId()).isEqualTo(preSave.getUserId());
		assertThat(postSave.getPassword()).isEqualTo(preSave.getPassword());
		assertThat(repo.count()).isEqualTo(1);
	}

	@Test
	public void saveTestNoPwd() {
		final UserProfile preSave = UserProfile.builder().userId("DemoUser").build();
		assertThat(preSave.getId()).isNull();
		assertThat(preSave.getPassword()).isNull();

		assertThrows(TransactionSystemException.class, () -> {
			repo.save(preSave);
		});

	}

	@Test
	public void saveTestNoUserId() {
		final UserProfile preSave = UserProfile.builder().password("DemoPwd").build();
		assertThat(preSave.getId()).isNull();
		assertThat(preSave.getUserId()).isNull();

		assertThrows(TransactionSystemException.class, () -> {
			repo.save(preSave);
		});
	}
}
