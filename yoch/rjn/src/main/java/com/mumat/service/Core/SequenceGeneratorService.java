package com.mumat.service.Core;

import com.mumat.model.SeqId;

public interface SequenceGeneratorService {
	SeqId getSeqId(String sequenceName);
}
