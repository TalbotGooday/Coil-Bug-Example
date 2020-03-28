package com.gapps.coilbugexample.coil

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.P
import androidx.appcompat.widget.AppCompatImageView
import coil.Coil
import coil.ImageLoader
import coil.api.load
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.request.LoadRequestBuilder
import coil.util.CoilLogger
import com.gapps.coilbugexample.R

fun initCoil(context: Context) {
	CoilLogger.setEnabled(true)

	Coil.setDefaultImageLoader(ImageLoader(context) {
		componentRegistry {
			add(SvgDecoder(context))

			if (SDK_INT >= P) {
				add(ImageDecoderDecoder())
			} else {
				add(GifDecoder())
			}
		}
	})
}

fun AppCompatImageView.loadImage(imageUrl: String?) {
	if (imageUrl.isNullOrBlank()) return

	this.loadPreview(imageUrl)
}

fun AppCompatImageView.loadPreview(imageUrl: String?) {
	imageUrl ?: return
	val drawable = ColorDrawable(Color.TRANSPARENT).apply {
		setBounds(0, 0, 1, 1)
	}

	val builder: LoadRequestBuilder.() -> Unit = {
		placeholder(drawable)
		error(R.drawable.ic_launcher_foreground)
		target(this@loadPreview)
	}

	Coil.load(this.context, imageUrl, builder)
}