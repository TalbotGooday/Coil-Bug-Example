package com.gapps.coilbugexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gapps.coilbugexample.adapters.ImagesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
	private val images = listOf(
			"https://www.gstatic.com/allo/stickers/pack-880198/v1/xxhdpi/1.gif",
			"https://www.gstatic.com/allo/stickers/pack-880200/v2/xxhdpi/1.gif",
			"https://i.ytimg.com/vi/lMgmHMrovhw/maxresdefault.jpg",
			"https://www.gstatic.com/allo/stickers/pack-880200/v2/xxhdpi/1.gif",
			"https://media1.tenor.com/images/203ee66b44de45f6119a9984de37b4e1/tenor.gif"
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		initViews()
	}

	private fun initViews() {
		list.apply {
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = ImagesAdapter(object : ImagesAdapter.Listener {
				override fun onItemClick(item: String) {
				}
			}).apply {
				swapData(images)
			}
		}
	}
}