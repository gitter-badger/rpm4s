package rpm4s

import org.scalatest._
import org.scalatest.prop.PropertyChecks
import rpm4s.data.{OS, RPMType}
import rpm4s.codecs._

class LeadSpec
    extends FlatSpec
    with Matchers
    with PropertyChecks
    with CustomMatchers {

  "Lead" should "roundtrip" in {
    val value =
      Lead(3, 0, RPMType.Binary, 1, "kernel-default-4.8.12-1.1", OS.Linux, 5)
    roundtrip(value)
  }

}
