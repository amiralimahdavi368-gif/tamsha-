class MovieAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.poster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val movie = movies[position]

        Glide.with(holder.itemView)
            .load(movie.poster)
            .into(holder.img)

        // 🎯 Zoom روی فوکوس
        holder.itemView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.animate().scaleX(1.15f).scaleY(1.15f).setDuration(150).start()
                v.elevation = 10f
            } else {
                v.animate().scaleX(1f).scaleY(1f).setDuration(150).start()
                v.elevation = 1f
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlayerActivity::class.java)
            intent.putExtra("url", movie.url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = movies.size
}
