import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import thrift._

object Server extends App{
    val service = new EchoService.FutureIface{
        def echo(q: String): Future[String] = Future.value(q)
    }

    val server = Thrift.serveIface(":8080", service)
    Await.ready(server)
}
