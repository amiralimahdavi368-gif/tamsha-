override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

    when (keyCode) {

        KeyEvent.KEYCODE_DPAD_CENTER -> {
            if (player.isPlaying) player.pause()
            else player.play()
            return true
        }

        KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> {
            if (player.isPlaying) player.pause()
            else player.play()
            return true
        }

        KeyEvent.KEYCODE_BACK -> {
            finish()
            return true
        }
    }

    return super.onKeyDown(keyCode, event)
}
