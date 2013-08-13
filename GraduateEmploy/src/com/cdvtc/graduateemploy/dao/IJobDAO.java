package com.cdvtc.graduateemploy.dao;

import com.cdvtc.graduateemploy.model.Job;

public interface IJobDAO {
	boolean insert(Job job);
	boolean delete(Job job);
	boolean update(Job job);
	boolean deleteById(int id);
	Job findById(int id);
}
