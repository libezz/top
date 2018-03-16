package top.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.entity.BasePO;

public interface BaseRepository<T extends BasePO> extends JpaRepository<T, Long> {

}
