// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ggattamaneni/Downloads/untitled/conf/routes
// @DATE:Fri Sep 13 14:59:47 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseEarthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getContinents(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getContinents")
    }
  
    // @LINE:9
    def deleteContinent(continent:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "deleteContinent/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("continent", continent)))
    }
  
    // @LINE:16
    def getCitiesOfContinent(continent:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCitiesOfContinent/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("continent", continent)))
    }
  
    // @LINE:14
    def checkIfTheContinentsAreSame(c1:String, c2:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "checkContinentsSame" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("c1", c1)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("c2", c2)))))
    }
  
    // @LINE:11
    def getCountries(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCountries")
    }
  
    // @LINE:15
    def addCities(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addCities")
    }
  
    // @LINE:7
    def addContinent(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addContinent")
    }
  
    // @LINE:17
    def getCitiesByFirstLetter(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCitiesByFirstLetter")
    }
  
    // @LINE:10
    def addCountry(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addCountry")
    }
  
    // @LINE:13
    def getContinentOfCountry(country:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getContinentOfCountry/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("country", country)))
    }
  
  }


}
