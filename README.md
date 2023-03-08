##PS:The endpoint /api/alias is currently return 404 for any value in the request body.

```/okhttp.OkHttpClient: --> POST https://url-shortener-nu.herokuapp.com/api/alias
I/okhttp.OkHttpClient: Content-Type: application/json
I/okhttp.OkHttpClient: Content-Length: 24
I/okhttp.OkHttpClient: {"url":"https://sou.nu"}
I/okhttp.OkHttpClient: --> END POST (24-byte body)
I/okhttp.OkHttpClient: <-- 404 Not Found https://url-shortener-nu.herokuapp.com/api/alias
```

## Shorter-link app


## Project architecture
<img src ="https://github.com/douglasalipio/weathercheck_interview/blob/master/clean-architecture-interaction.png" />&nbsp;&nbsp;
The App was developed based on clean architecture concept. It is separated by package layers such as
domain, presentation, and data.

Presentation - layer responsible for the view such as Activities, Fragments, ViewModel, and etc
Domain - layer responsible for handle business logic (UseCase)
data - layer responsible for handle remote/local data

## Testing
<img src ="https://github.com/douglasalipio/shortenUrlApp/blob/main/Screen%20Shot%202023-03-08%20at%2011.14.34.png" />&nbsp;&nbsp;

The app contains instrumentation and unit tests. 
The code covered roughly 63% without measuring the UI testing

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


