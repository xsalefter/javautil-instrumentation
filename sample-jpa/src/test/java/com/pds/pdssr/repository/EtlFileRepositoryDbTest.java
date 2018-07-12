package com.pds.pdssr.repository;

import com.pds.pdssr.models.EtlFile;
import com.pds.pdssr.repositories.EtlFileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtlFileRepositoryDbTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EtlFileRepository etlFileRepository;

    @Test
    public void when_findWhereEtlSaleCaseGtInIsNull_withDefaultBehaviour_thenOk() {
        List<EtlFile> etlFiles = this.etlFileRepository.findWhereEtlSaleCaseGtInIsNull();
        Assert.assertNotNull(etlFiles);
        Assert.assertTrue(etlFiles.isEmpty());
    }
    
    @Test
    public void hasEtlFile() {
    	logger.info("checking hasEtlFiles");
    	List<EtlFile> etlFiles = etlFileRepository.findAll();
    	Assert.assertNotNull(etlFiles);
    	logger.info("etlFiles.size() " + etlFiles.size());
    	//Assert.assertTrue(etlFiles.size() > 0);
    }

}
