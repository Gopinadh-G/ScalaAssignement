// @GENERATOR:play-routes-compiler
// @SOURCE:/home/ggattamaneni/Downloads/untitled/conf/routes
// @DATE:Fri Sep 13 14:59:47 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  EarthController_0: controllers.EarthController,
  // @LINE:20
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    EarthController_0: controllers.EarthController,
    // @LINE:20
    Assets_1: controllers.Assets
  ) = this(errorHandler, EarthController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, EarthController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addContinent""", """controllers.EarthController.addContinent"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getContinents""", """controllers.EarthController.getContinents"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteContinent/""" + "$" + """continent<[^/]+>""", """controllers.EarthController.deleteContinent(continent:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addCountry""", """controllers.EarthController.addCountry"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCountries""", """controllers.EarthController.getCountries"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getContinentOfCountry/""" + "$" + """country<[^/]+>""", """controllers.EarthController.getContinentOfCountry(country:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """checkContinentsSame""", """controllers.EarthController.checkIfTheContinentsAreSame(c1:String, c2:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addCities""", """controllers.EarthController.addCities"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCitiesOfContinent/""" + "$" + """continent<[^/]+>""", """controllers.EarthController.getCitiesOfContinent(continent:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCitiesByFirstLetter""", """controllers.EarthController.getCitiesByFirstLetter"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_EarthController_addContinent0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addContinent")))
  )
  private[this] lazy val controllers_EarthController_addContinent0_invoker = createInvoker(
    EarthController_0.addContinent,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "addContinent",
      Nil,
      "POST",
      this.prefix + """addContinent""",
      """ Home page
GET     /                           controllers.EarthController.index""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_EarthController_getContinents1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getContinents")))
  )
  private[this] lazy val controllers_EarthController_getContinents1_invoker = createInvoker(
    EarthController_0.getContinents,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "getContinents",
      Nil,
      "GET",
      this.prefix + """getContinents""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_EarthController_deleteContinent2_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteContinent/"), DynamicPart("continent", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EarthController_deleteContinent2_invoker = createInvoker(
    EarthController_0.deleteContinent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "deleteContinent",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """deleteContinent/""" + "$" + """continent<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_EarthController_addCountry3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addCountry")))
  )
  private[this] lazy val controllers_EarthController_addCountry3_invoker = createInvoker(
    EarthController_0.addCountry,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "addCountry",
      Nil,
      "POST",
      this.prefix + """addCountry""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_EarthController_getCountries4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCountries")))
  )
  private[this] lazy val controllers_EarthController_getCountries4_invoker = createInvoker(
    EarthController_0.getCountries,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "getCountries",
      Nil,
      "GET",
      this.prefix + """getCountries""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_EarthController_getContinentOfCountry5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getContinentOfCountry/"), DynamicPart("country", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EarthController_getContinentOfCountry5_invoker = createInvoker(
    EarthController_0.getContinentOfCountry(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "getContinentOfCountry",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getContinentOfCountry/""" + "$" + """country<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_EarthController_checkIfTheContinentsAreSame6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("checkContinentsSame")))
  )
  private[this] lazy val controllers_EarthController_checkIfTheContinentsAreSame6_invoker = createInvoker(
    EarthController_0.checkIfTheContinentsAreSame(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "checkIfTheContinentsAreSame",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """checkContinentsSame""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_EarthController_addCities7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addCities")))
  )
  private[this] lazy val controllers_EarthController_addCities7_invoker = createInvoker(
    EarthController_0.addCities,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "addCities",
      Nil,
      "POST",
      this.prefix + """addCities""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_EarthController_getCitiesOfContinent8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCitiesOfContinent/"), DynamicPart("continent", """[^/]+""",true)))
  )
  private[this] lazy val controllers_EarthController_getCitiesOfContinent8_invoker = createInvoker(
    EarthController_0.getCitiesOfContinent(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "getCitiesOfContinent",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getCitiesOfContinent/""" + "$" + """continent<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_EarthController_getCitiesByFirstLetter9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCitiesByFirstLetter")))
  )
  private[this] lazy val controllers_EarthController_getCitiesByFirstLetter9_invoker = createInvoker(
    EarthController_0.getCitiesByFirstLetter,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EarthController",
      "getCitiesByFirstLetter",
      Nil,
      "GET",
      this.prefix + """getCitiesByFirstLetter""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_EarthController_addContinent0_route(params@_) =>
      call { 
        controllers_EarthController_addContinent0_invoker.call(EarthController_0.addContinent)
      }
  
    // @LINE:8
    case controllers_EarthController_getContinents1_route(params@_) =>
      call { 
        controllers_EarthController_getContinents1_invoker.call(EarthController_0.getContinents)
      }
  
    // @LINE:9
    case controllers_EarthController_deleteContinent2_route(params@_) =>
      call(params.fromPath[String]("continent", None)) { (continent) =>
        controllers_EarthController_deleteContinent2_invoker.call(EarthController_0.deleteContinent(continent))
      }
  
    // @LINE:10
    case controllers_EarthController_addCountry3_route(params@_) =>
      call { 
        controllers_EarthController_addCountry3_invoker.call(EarthController_0.addCountry)
      }
  
    // @LINE:11
    case controllers_EarthController_getCountries4_route(params@_) =>
      call { 
        controllers_EarthController_getCountries4_invoker.call(EarthController_0.getCountries)
      }
  
    // @LINE:13
    case controllers_EarthController_getContinentOfCountry5_route(params@_) =>
      call(params.fromPath[String]("country", None)) { (country) =>
        controllers_EarthController_getContinentOfCountry5_invoker.call(EarthController_0.getContinentOfCountry(country))
      }
  
    // @LINE:14
    case controllers_EarthController_checkIfTheContinentsAreSame6_route(params@_) =>
      call(params.fromQuery[String]("c1", None), params.fromQuery[String]("c2", None)) { (c1, c2) =>
        controllers_EarthController_checkIfTheContinentsAreSame6_invoker.call(EarthController_0.checkIfTheContinentsAreSame(c1, c2))
      }
  
    // @LINE:15
    case controllers_EarthController_addCities7_route(params@_) =>
      call { 
        controllers_EarthController_addCities7_invoker.call(EarthController_0.addCities)
      }
  
    // @LINE:16
    case controllers_EarthController_getCitiesOfContinent8_route(params@_) =>
      call(params.fromPath[String]("continent", None)) { (continent) =>
        controllers_EarthController_getCitiesOfContinent8_invoker.call(EarthController_0.getCitiesOfContinent(continent))
      }
  
    // @LINE:17
    case controllers_EarthController_getCitiesByFirstLetter9_route(params@_) =>
      call { 
        controllers_EarthController_getCitiesByFirstLetter9_invoker.call(EarthController_0.getCitiesByFirstLetter)
      }
  
    // @LINE:20
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
