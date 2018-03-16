package top.repository;

import top.entity.VisitorPO;

public interface VisitorRepository extends BaseRepository<VisitorPO> {

	public VisitorPO findByVisitIp(String visitIp);
}
