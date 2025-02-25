Hello guys, I'm Phann Pha. I have created this project for testing on separate module 3 layer (Data layer, Domain layer, and Presenter layer)

1- Data layer : in this layer used for interaction with data source like local, and remote source.
helper/
     use_case : folder for contained observable data streams using RxJava3
     util    : folder for contained util file like (performance request data streams)
network/     : folder for container api client (HttpClient, AreaUrl, RetrofitBuilder, and Interceptor)
     area    : folder for generate base_url base on selected variance type
     interceptor : folder used to intercept and modify HTTP requests or responses, so we can use it to modify our network request before it gets executed.
     retrofit : folder contained (retrofit builder, httpClient provider)
     service  : folder used for mapping api service
