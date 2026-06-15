val pref = holder.itemView.context.getSharedPreferences("watch", Context.MODE_PRIVATE)
val percent = pref.getInt("${movie.url}_percent", 0)

holder.progress.progress = percent
