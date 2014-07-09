import com.twitter.conversions.time._
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.stats.OstrichStatsReceiver
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.twitter.finagle.Thrift
import com.twitter.util._
import com.twitter.ostrich._
import com.twitter.ostrich.stats._
import com.twitter.ostrich.admin._
import com.twitter.ostrich.admin.config._
import thrift._

import java.net.InetSocketAddress
import java.util.concurrent.TimeUnit

import org.apache.thrift.protocol._

object Server extends App{

    val service = new EchoService.FutureIface{
        def echo(q: String): Future[String] = {Stats.incr("#echo called");Future.value(q)}
    }

    val respond = new EchoService.FinagledService(service, new TBinaryProtocol.Factory)

    val admin = new AdminHttpService(54321, 54322, RuntimeEnvironment(this, Array()))
    admin.start()

    //val server = Thrift.serveIface(":8080", service)
    //Await.ready(server)
    
    val server = ServerBuilder().bindTo(new InetSocketAddress(8080))
        .codec(ThriftServerFramedCodec())
        .name("finagle-scrooge-template-server")
        .reportTo(new OstrichStatsReceiver)
        .readTimeout(1.minutes)
        .build(respond)
}
