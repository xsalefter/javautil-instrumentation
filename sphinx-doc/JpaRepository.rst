https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/

https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-eight-adding-functionality-to-a-repository/

https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito

Create a repository interface
=============================

:: code-block : java

    package com.pds.pdssr.repositories;

    import com.pds.pdssr.models.EtlFile;

    import java.util.List;

    import org.springframework.data.jpa.repository.JpaRepository;

    public interface EtlFileRepository extends JpaRepository<EtlFile, Integer> {
        public List<EtlFile> findWithUnposted();
     }

TODO explain