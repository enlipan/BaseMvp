package com.example.lee.basemvp.basemvp;

import java.util.Collection;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by lee on 16/8/25.
 */

public class MvpBaseRepository implements MvpRepository {
    private final WeakHashMap<String,Call> callMap = new WeakHashMap<>();

    public void enqueueCall(String key, Call call, Callback callback){
        call.enqueue(callback);
        callMap.put(key,call);
    }

    @Override
    public void cancelWork() {
        Collection<Call> calls = callMap.values();
        for (Call call : calls) {
            call.cancel();
            calls.remove(call);
        }
    }

}
