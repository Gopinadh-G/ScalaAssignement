// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ggattamaneni/Downloads/untitled/conf/routes
// @DATE:Fri Sep 13 14:59:47 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
