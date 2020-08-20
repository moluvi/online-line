package xxp.service.serviceBean;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import xxp.entity.Work;
import xxp.service.WorkService;
import xxp.mapper.WorkMapper;

@Service
public class WorkServiceBean implements WorkService{
	
	@Autowired
	private WorkMapper workMapper;
		
	@Override
	public List<Work> getAllWorks(String courseName) {
		// TODO Auto-generated method stub
		return this.workMapper.getAllWorks(courseName);
	}

	@Override
	public Work getWorkById(int workId) {
		// TODO Auto-generated method stub
		return this.workMapper.getWorkById(workId);
	}

	@Override
	public void addWork(Work work) {
		// TODO Auto-generated method stub
		this.workMapper.addWork(work);
		
	}

	@Override
	public void updateWork(Work work) {
		// TODO Auto-generated method stub
		this.workMapper.updateWork(work);
		
	}

	@Override
	public void deleteWork(int workId) {
		// TODO Auto-generated method stub
		this.workMapper.deleteWork(workId);
		
	}
		
}
