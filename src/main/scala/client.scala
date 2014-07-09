import com.twitter.finagle.Thrift
import com.twitter.finagle.thrift.ClientId
import com.twitter.util.{Await, Future}
import thrift._

object Client extends App {
    val client = Thrift.withClientId(ClientId("finagle-scrooge-template-client")).newIface[EchoService.FutureIface]("localhost:8080");
    val response = client.echo("hello") //.onSuccess { response => println(response)}
    println(Await.result(response))
}
