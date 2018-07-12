package com.pds.pdssr;

import com.pds.pdssr.models.EtlFile;
import com.pds.pdssr.repositories.EtlFileRepository;
import com.pds.pdssr.service.EtlFileService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:h2.properties")
public class PdssrApplicationTests {

	@Autowired
	private EtlFileRepository etlFileRepository;

	@Autowired
    private EtlFileService etlFileService;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() {
		List<EtlFile> etlFiles = this.etlFileRepository.findAll();
		Assert.assertNotNull(etlFiles);
	}

	@Test
    @Transactional
    public void doSomethingWithSessionFactoryTest() {
	    this.etlFileService.doSomethingWithSessionFactory();
    }

    @Test
	public void dataSourceInjectionTest() throws SQLException {
		Assert.assertNotNull(this.dataSource);
		final Connection connection = this.dataSource.getConnection();
		Assert.assertNotNull(connection);
	}
}
