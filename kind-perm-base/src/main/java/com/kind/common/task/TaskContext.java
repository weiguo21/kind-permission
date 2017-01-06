package com.kind.common.task;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by weiguo.liu on 2017/1/6.
 */
public class TaskContext {
    private ConcurrentMap<String, Object> context = new ConcurrentHashMap<String, Object>();


    public Object replace(String key, Object value) {
        return context.replace(key, value);
    }

    public int size() {
        return context.size();
    }

    public Object get(Object key) {
        return context.get(key);
    }

    public Object put(String key, Object value) {
        return context.put(key, value);
    }

    public Set<String> keySet() {
        return context.keySet();
    }

    public Collection<Object> values() {
        return context.values();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return context.entrySet();
    }
}
