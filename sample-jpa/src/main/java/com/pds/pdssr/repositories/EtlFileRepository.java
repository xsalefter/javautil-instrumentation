package com.pds.pdssr.repositories;

import com.pds.pdssr.models.EtlFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtlFileRepository extends JpaRepository<EtlFile, Integer> {

    @Query(value = "select * from etl_file where etl_file_id in (select etl_file_id from etl_sale where case_gtin is null)",
            nativeQuery = true)
    List<EtlFile> findWhereEtlSaleCaseGtInIsNull();
}
