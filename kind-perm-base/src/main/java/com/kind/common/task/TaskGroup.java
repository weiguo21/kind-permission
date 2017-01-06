package com.kind.common.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class TaskGroup {

    private List<TaskGroup> groups = new ArrayList<TaskGroup>();

    private List<Task<Boolean>> tasks = new ArrayList<Task<Boolean>>();

    public List<TaskGroup> getGroups() {
        return groups;
    }

    public List<Task<Boolean>> getTasks() {
        return tasks;
    }

    public TaskGroup addGroup(TaskGroup group) {
        this.groups.add(group);
        return this;
    }

    public TaskGroup addTask(Task<Boolean> task) {
        this.tasks.add(task);
        return this;
    }

    public TaskContext execute(final TaskContext context,final Integer threadSize){

        ExecutorService service = Executors.newFixedThreadPool(threadSize);
        CompletionService<Boolean> cs = new ExecutorCompletionService<Boolean>(service);

        for(final TaskGroup group:groups){
            cs.submit(new Callable<Boolean>(){
                @Override
                public Boolean call() throws Exception {
                    group.execute(context,threadSize);
                    return  true;
                }
            });
        }

        checkAllDone(cs,groups.size());

        for(final Task<Boolean> task:tasks){
            cs.submit(new Callable<Boolean>(){
                @Override
                public Boolean call() throws Exception {
                    task.execute(context);
                    return  true;
                }
            });
        }

        checkAllDone(cs,tasks.size());

        service.shutdown();
        return context;
    }

    private boolean checkAllDone(CompletionService<Boolean> cs,Integer size) {

        int count=0;

        while (count<size){
            try{
                cs.take();
            }catch(Exception ex){
            }
            count+=1;
        }
        return true;
    }

}
