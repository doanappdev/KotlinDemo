package com.doanappdev.kotlindemo

import android.app.Activity
import android.content.Intent
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import com.doanappdev.kotlindemo.news.NewsActivity

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.name
    val REQUEST_VIDEO_APP_RESULT = 0

    @Inject lateinit var locationManager: LocationManager

    // example of injecting object from AppModule using the
    // value declared in the '@Name' annotation
    @field:[Inject Named("something")]
    lateinit var something: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DemoApplication.appComponent.inject(this)

        assert(videoView != null)
        assert(videoButton != null)

        Log.d(TAG, "$something")



        videoButton.setOnClickListener{callVideoApp()}
        newsButton.setOnClickListener{startNewsActivity()}

        videoView.setOnCompletionListener {
            videoView.visibility = View.GONE
            videoButton.visibility = View.VISIBLE
        }
    }

    fun startNewsActivity() {
        val newsIntent = Intent(this, NewsActivity::class.java)
        startActivity(newsIntent)
    }


    fun callVideoApp() {
        val videoIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if (videoIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(videoIntent, REQUEST_VIDEO_APP_RESULT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_VIDEO_APP_RESULT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    videoView.setVideoURI(data.data)
                    videoButton.visibility = View.GONE
                    videoView.visibility = View.VISIBLE
                    videoView.start()
                }
            } else -> {
                toast("Unrecognized request code $requestCode")
            }
        }
    }
}
