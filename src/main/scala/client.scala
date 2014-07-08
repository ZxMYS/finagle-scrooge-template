import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import thrift._

object Client extends App {
    val client = Thrift.newIface[EchoService.FutureIface]("localhost:8080");
    val response = client.echo("hello") //.onSuccess { response => println(response)}
    println(response.get)
}
