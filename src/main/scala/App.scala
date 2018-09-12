import akka.stream.ActorMaterializer
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}

import scala.concurrent.{ExecutionContextExecutor, Future}
import akka.NotUsed
import akka.actor.ActorSystem
import akka.kafka.scaladsl.{Consumer, Producer}
import akka.kafka.{ConsumerSettings, ProducerMessage, ProducerSettings, Subscriptions}
import akka.stream.scaladsl._
import org.apache.kafka.clients.producer.ProducerRecord

import scala.collection.immutable.Seq
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object App extends App {

  println("alpakka-kafka-ping")

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val contextExecutor: ExecutionContextExecutor = actorSystem.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val producerSettings = ProducerSettings(actorSystem, new StringSerializer, new StringSerializer)
  val consumerSettings = ConsumerSettings(actorSystem, new StringDeserializer, new StringDeserializer)

  val topic = actorSystem.settings.config.getString("app.topic")

  val producerFuture = Source.tick(1.seconds, 2.seconds, tick = "ping")
    .map(m => {println(s"Sending $m"); m })
    .map(m => ProducerMessage.Message(new ProducerRecord[String, String](topic, m), NotUsed))
    .via(Producer.flexiFlow[String, String, NotUsed](producerSettings))
    .runWith(Sink.ignore)

  val consumerFuture = Consumer.atMostOnceSource(consumerSettings, Subscriptions.topics(topic))
    .map(m => m.value())
    .map(m => {println(s"Received $m"); m })
    .runWith(Sink.ignore)

  Future.sequence(Seq(consumerFuture, producerFuture)).onComplete {
    case Success(_) => {
      println("SUCCESS")
    }
    case Failure(err) => {
      println(s"ERROR ${err.getMessage}")
    }
  }
}
