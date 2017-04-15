package com.mumat.service.Core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mumat.dao.core.SequenceGeneratorDao;
import com.mumat.model.SeqId;
import com.mumat.service.Core.SequenceGeneratorService;

@Service("sequenceGeneratorService")
@Transactional
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {

	@Autowired
	private SequenceGeneratorDao dao;
	
	@Override
	public SeqId getSeqId(String sequenceName) { 
		return dao.getSeqId(sequenceName);
	}
}
