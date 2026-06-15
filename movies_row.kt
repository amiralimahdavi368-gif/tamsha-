holder.moviesRecycler.layoutManager =
    LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

holder.moviesRecycler.adapter = MovieAdapter(category.movies)

holder.moviesRecycler.isFocusable = false
