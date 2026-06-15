class HomeFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var repository: Repository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recycler = view.findViewById(R.id.recycler)

        setupRetrofit()
        loadData()

        return view
    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/USER/tamasha/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        repository = Repository(retrofit.create(ApiService::class.java))
    }

    private fun loadData() {
        repository.getData { data ->
            if (data != null) {
                recycler.adapter = MovieRowAdapter(data.categories)
            }
        }
    }
}
