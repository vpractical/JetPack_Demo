package com.y.jetpack_demo.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.y.jetpack_demo.util.L

class Worker2(context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {


    override fun doWork(): Result {
        L.e("worker22222")
        return Result.retry()
    }


}