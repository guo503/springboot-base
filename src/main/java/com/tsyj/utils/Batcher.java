package com.tsyj.utils;

import java.util.List;

public interface Batcher<R> {

    List<R> list(int lastId, Object cond);
}
