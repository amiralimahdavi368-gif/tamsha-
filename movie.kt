class MovieRowAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<MovieRowAdapter.RowViewHolder>() {

    inner class RowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.categoryTitle)
        val moviesRecycler: RecyclerView = view.findViewById(R.id.moviesRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return RowViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val category = categories[position]

        holder.title.text = category.name

        holder.moviesRecycler.adapter = MovieAdapter(category.movies)
    }

    override fun getItemCount() = categories.size
}
