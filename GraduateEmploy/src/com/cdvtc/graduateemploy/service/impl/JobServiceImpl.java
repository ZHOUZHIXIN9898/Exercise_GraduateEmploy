package com.cdvtc.graduateemploy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IJobDAO;
import com.cdvtc.graduateemploy.model.Job;
import com.cdvtc.graduateemploy.service.IJobService;

@Component("jobService")
public class JobServiceImpl implements IJobService {
	@Resource(name="jobDAO")
	public void setJobDAO(IJobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}

	public boolean delete(Job job) {
		return jobDAO.delete(job);
	}

	public boolean deleteById(int id) {
		return jobDAO.deleteById(id);
	}

	public Job findById(int id) {
		return jobDAO.findById(id);
	}

	public boolean insert(Job job) {
		return jobDAO.insert(job);
	}

	public boolean update(Job job) {
		return jobDAO.update(job);
	}
	private IJobDAO jobDAO;
}