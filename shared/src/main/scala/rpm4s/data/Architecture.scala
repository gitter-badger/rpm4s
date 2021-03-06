package rpm4s.data

sealed trait Architecture
object Architecture {
  case object x86_64 extends Architecture
  case object i386 extends Architecture
  case object i486 extends Architecture
  case object i586 extends Architecture
  case object i686 extends Architecture
  //TODO: find out what the relationship between those architectures is
  //TODO: find out if modeling compatability between architectures is sanely possible
  case object ppc extends Architecture
  case object ppc64 extends Architecture
  case object ppc64le extends Architecture
  case object s390x extends Architecture
  case object NoArch extends Architecture

  def toRpmString(architecture: Architecture): String = architecture match {
    case Architecture.x86_64 => "x86_64"
    case Architecture.i586 => "i586"
    case Architecture.i686 => "i686"
    case Architecture.NoArch => "noarch"
    case _ => ???
  }

  def fromString(value: String): Option[Architecture] = value match {
    case "x86_64" => Some(x86_64)
    case "i586" => Some(i586)
    case "i686" => Some(i686)
    case "noarch" => Some(NoArch)
    case _ => None
  }
}
