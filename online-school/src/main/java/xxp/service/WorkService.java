package xxp.service;

import java.util.List;


import xxp.entity.Work;

public interface WorkService {
	
	
	List<Work> getAllWorks(String courseName);
	
	Work getWorkById(int workId);
	

	void addWork(Work work);

	void updateWork(Work work);
	
	void deleteWork(int workId);
}
