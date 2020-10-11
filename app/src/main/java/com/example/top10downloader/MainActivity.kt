package com.example.top10downloader

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate called")
        val downloadData = DownloadData()
        downloadData.execute("URL goes here")
        Log.d(TAG, "onCreate: done")
        // mainactivity|downloaddata to filter for both tags
    }

    companion object { // Kotlin's equivalent to static
        private class DownloadData : AsyncTask<String, Void, String>() { // CTRL + O for all methods

            private val TAG = "DownloadData"

            override fun onPostExecute(result: String?) { // this is called on the main thread
                super.onPostExecute(result)
                Log.d(TAG, "onPostExecute: parameter is $result")
            }

            override fun doInBackground(vararg params: String?): String {
                Log.d(TAG, "doInBackground: starts with ${params[0]}")
                return "doInBackground completed"
            }
        }
    }
}