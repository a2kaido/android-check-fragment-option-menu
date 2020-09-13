package io.a2kaido.fragment.option.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // FragmentManager.enableNewStateManager(false)

        val info = InfoFragment()
        val more = MoreFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, info, "info")
            .add(R.id.fragment_container, more, "more")
            .hide(info)
            .hide(more)
            .commit()

        button_info.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .hide(more)
                .show(info)
                .commit()
        }

        button_more.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .hide(info)
                .show(more)
                .commit()
        }
    }
}
