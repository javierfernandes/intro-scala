package implicits

package object inpackage {
  implicit class StringExtensions(base: String) {
    def splitIntoLines = base.replaceAll("\\.", ".\n").replaceAll("\n ", "\n")
  }
}