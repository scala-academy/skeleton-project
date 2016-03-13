package placeholder

import com.twitter.finagle.http.{Method, Request, Response}
import com.twitter.util.Await
import placeholder.base.IntegrationTestBase

class DataEndpointTest extends IntegrationTestBase {

  feature("Server status endpoint") {
    scenario("returns server uptime") {
      Given("the server is running")

      val path = "/data"
      val responseFuture = performGathererRequest(Request(Method.Get, path))
      When(s"I do a HTTP GET to '$path'")

      val response: Response = Await.result(responseFuture)
      response.statusCode shouldBe 200
      Then("the response should have statuscode 200")
    }
  }
}