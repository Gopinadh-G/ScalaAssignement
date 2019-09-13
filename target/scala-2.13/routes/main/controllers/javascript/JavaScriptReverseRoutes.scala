// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ggattamaneni/Downloads/untitled/conf/routes
// @DATE:Fri Sep 13 14:59:47 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:20
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseEarthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getContinents: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.getContinents",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getContinents"})
        }
      """
    )
  
    // @LINE:9
    def deleteContinent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.deleteContinent",
      """
        function(continent0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteContinent/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("continent", continent0))})
        }
      """
    )
  
    // @LINE:16
    def getCitiesOfContinent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.getCitiesOfContinent",
      """
        function(continent0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCitiesOfContinent/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("continent", continent0))})
        }
      """
    )
  
    // @LINE:14
    def checkIfTheContinentsAreSame: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.checkIfTheContinentsAreSame",
      """
        function(c10,c21) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "checkContinentsSame" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("c1", c10), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("c2", c21)])})
        }
      """
    )
  
    // @LINE:11
    def getCountries: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.getCountries",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCountries"})
        }
      """
    )
  
    // @LINE:15
    def addCities: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.addCities",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addCities"})
        }
      """
    )
  
    // @LINE:7
    def addContinent: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.addContinent",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addContinent"})
        }
      """
    )
  
    // @LINE:17
    def getCitiesByFirstLetter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.getCitiesByFirstLetter",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCitiesByFirstLetter"})
        }
      """
    )
  
    // @LINE:10
    def addCountry: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.addCountry",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addCountry"})
        }
      """
    )
  
    // @LINE:13
    def getContinentOfCountry: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.EarthController.getContinentOfCountry",
      """
        function(country0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getContinentOfCountry/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("country", country0))})
        }
      """
    )
  
  }


}
