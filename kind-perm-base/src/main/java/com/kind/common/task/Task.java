package com.kind.common.task;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public interface Task<T> {
    T execute(TaskContext context);
}
