package controllers

import javax.inject._
import models._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import scala.concurrent.duration._

import scala.concurrent.{Await, ExecutionContext, Future}

class EarthController @Inject()(repo: EarthRepository,
                                cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  def getContinents: Action[AnyContent] =Action.async { implicit request =>
    for {
      res <- repo.continentList()

    } yield{
      if(res.isEmpty){Ok(Json.toJson(StringResponse(res,"No data found")))}
      else{Ok(Json.toJson(StringResponse(res,"Data published")))}
  }}
  /*  repo.continentList().map{ xs =>
      if(!xs.isEmpty)
        Ok(Json.toJson(xs))
      else
        Ok(Json.toJson(StringResponse("No Continent Data Found")))

    }*/




  def getCountries: Action[AnyContent] =Action.async { implicit request =>

    repo.countryList().map{ xs =>
      if(!xs.isEmpty)
        Ok(Json.toJson(xs))
      else
        Ok(Json.toJson(StringResponse("No Country Data Found")))

    }

  }

  def addContinent: Action[JsValue] =Action(parse.json){
    implicit request:Request[JsValue]=>
      val result=request.body.validate[StringResponse]
      result.fold(
        errors=>{
          Ok(Json.toJson(StringResponse("Bad Data")))
        },
        continent=>{
          Ok(Json.toJson(StringResponse(repo.createContinent(continent.msg))))
        }
      )
  }

  def addCountry: Action[JsValue] =Action(parse.json){
    implicit request:Request[JsValue]=>
      val result=request.body.validate[CountryRef]
      result.fold(
        errors=>{
          Ok(Json.toJson(StringResponse("Bad Data")))
        },
        country=>{
          Ok(Json.toJson(StringResponse(repo.createCountry(country))))
        }
      )
  }

  def deleteContinent(continent:String)= Action{

    Ok(repo.deleteContinent(continent))

  }

  def getContinentOfCountry(countryName:String): Action[AnyContent] =Action{
    Ok(Json.toJson(StringResponse(repo.getContinentOfACountry(countryName))))
  }

  def checkIfTheContinentsAreSame(country1:String,country2:String)= Action{
    Ok(Json.toJson(StringResponse(repo.checkIfTwoCountryLiesInSameContinent(country1,country2))))
  }

  def addCities:Action[JsValue]=Action(parse.json){
    implicit request:Request[JsValue]=>
      request.body.validate[Array[CityRef]].fold(
        errors=>{
          Ok(Json.toJson(StringResponse("Bad input")))
        },
        cities=>{
          Ok(Json.toJson(StringResponse(repo.addCitiesToTheCountry(cities))))
        }
      )

  }

  def getCitiesOfContinent(continent:String)=Action{
    val result=repo.getAllCitiesOfContinent(continent)
    result.isEmpty match {
      case true =>
        Ok(Json.toJson(StringResponse(s"No Data found for $continent")))
      case false=>
        Ok(Json.toJson(result))
    }
  }

  def getCitiesByFirstLetter=Action{
    val result=repo.groupCitiesByFirstLetter.map(value=>value._1->Json.toJson(value._2))
    Ok(Json.toJson(result.toMap))
  }


}



