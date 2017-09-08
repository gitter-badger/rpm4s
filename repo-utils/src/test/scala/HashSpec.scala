import java.security.MessageDigest

import cats.effect.IO
import fs2.{Pipe, Stream}
import org.scalatest._
import org.scalatest.prop.PropertyChecks
import rpm4s.data.Checksum.Sha256

class HashSpec
    extends FlatSpec
    with Matchers
    with PropertyChecks {

  "checksumsBeforeAndAfter" should "produce the same result as doing each step manually" in {
    forAll { value: String =>
      val in = Stream.emits(value.getBytes).covary[IO]
      val pipe: Pipe[IO, Byte, Byte] = _.map(b => (b * 2).toByte)
      val result = rpm4s.repo.utils.hash.checksumsBeforeAndAfter[IO](
        in,
        pipe,
        MessageDigest.getInstance("SHA-256"),
        Sha256.fromBytes,
        s => s.map(_ => ())
      ).unsafeRunSync

      val beforeHash = in.through(fs2.hash.sha256).runLog.map(x => Sha256.fromBytes(x.toArray).get).unsafeRunSync
      val beforeSize = in.runLog.map(_.size).unsafeRunSync
      val afterHash = in.through(pipe).through(fs2.hash.sha256).runLog.map(x => Sha256.fromBytes(x.toArray).get).unsafeRunSync
      val afterSize = in.through(pipe).runLog.map(_.size).unsafeRunSync


      result shouldEqual (beforeHash, beforeSize, afterHash, afterSize)
    }
  }

}
