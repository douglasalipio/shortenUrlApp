##PS:The endpoint /api/alias is currently return 404 for any value in the request body.

```/okhttp.OkHttpClient: --> POST https://url-shortener-nu.herokuapp.com/api/alias
I/okhttp.OkHttpClient: Content-Type: application/json
I/okhttp.OkHttpClient: Content-Length: 24
I/okhttp.OkHttpClient: {"url":"https://sou.nu"}
I/okhttp.OkHttpClient: --> END POST (24-byte body)
I/okhttp.OkHttpClient: <-- 404 Not Found https://url-shortener-nu.herokuapp.com/api/alias
```

## Project architecture

The App was developed based on clean architecture concept. It is separated by package layers such as
domain, presentation, and data.

Presentation - layer responsible for the view such as Activities, Fragments, ViewModel, and etc
Domain - layer responsible for handle business logic (UseCase)
data - layer responsible for handle remote/local data

## Testing
The app contains instrumentation and unit tests.

data layer tests:

* MapperTest
* DataSourceTest
* RepositoryTest

domain layer tests:

* UseCaseTest

presentation layer tests

* MapperTest
* ViewmodelTest
* FragmentTest


