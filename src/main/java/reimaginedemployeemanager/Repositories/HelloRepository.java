package reimaginedemployeemanager.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import reimaginedemployeemanager.Objects.Hello;

public interface HelloRepository extends PagingAndSortingRepository<Hello, Integer> {
    
}