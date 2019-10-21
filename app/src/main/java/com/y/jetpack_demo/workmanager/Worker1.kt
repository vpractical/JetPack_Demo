package com.y.jetpack_demo.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.y.jetpack_demo.util.L

class Worker1(context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {


    override fun doWork(): Result {
        L.e("worker11111")
        return Result.retry()
    }


}