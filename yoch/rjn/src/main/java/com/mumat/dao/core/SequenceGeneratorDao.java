package com.mumat.dao.core;

import com.mumat.model.SeqId;

public interface SequenceGeneratorDao {
	public SeqId getSeqId(String sequenceName);
}
