class Repository(private val api: ApiService) {

    fun getData(callback: (Root?) -> Unit) {
        api.getData().enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                callback(null)
            }
        })
    }
}
