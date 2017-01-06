package com.kind.common.task;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class TaskMainGroup<T> {


    private TaskGroup mainTaskGroup = new TaskGroup();
    private Task<T> getResult = null;
    private TaskContext context = null;

    public TaskMainGroup<T> putContext(TaskContext context) {
        this.context = context;
        return this;
    }

    public TaskMainGroup<T> addGroup(TaskGroup group) {
        mainTaskGroup.addGroup(group);
        return this;
    }

    public TaskMainGroup<T> addTask(Task<Boolean> task) {
        mainTaskGroup.addTask(task);
        return this;
    }

    public TaskMainGroup<T> putGetResult(Task<T> getResult) {
        this.getResult = getResult;
        return this;
    }

    public T getResult(Integer threadSize) {
        this.mainTaskGroup.execute(context, threadSize);
        if (null != this.getResult) {
            return getResult.execute(context);
        }
        return null;
    }

}
