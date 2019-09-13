package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.collection.mutable.ListBuffer
import scala.concurrent.{Await, ExecutionContext, Future}

import scala.concurrent.duration._


@Singleton
class EarthRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {

  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class ContinentTable(tag: Tag) extends Table[Continent](tag, "continent") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def continentName = column[String]("continentName")
    def * = (id, continentName) <> ((Continent.apply _).tupled, Continent.unapply)
  }

  private class CountryTable(tag: Tag) extends Table[Country](tag, "country") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def countryName = column[String]("countryName")
    def continentName = column[String]("continentName")
    def * = (id,countryName, continentName) <> ((Country.apply _).tupled, Country.unapply)
  }

  private class CityTable(tag: Tag) extends Table[City](tag, "city") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def cityName = column[String]("cityName")
    def countryName = column[String]("countryName")
    def * = (id,cityName, countryName) <> ((City.apply _).tupled, City.unapply)
  }

  private val continent = TableQuery[ContinentTable]
  private val country = TableQuery[CountryTable]
  private val city = TableQuery[CityTable]

  def createContinent(name: String): String = {
    if(name.matches("[A-Za-z]+")) {
      if(!getAll.exists(p => p.continentName.equalsIgnoreCase(name))) {
        db.run {
          (continent.map(p => p.continentName)
            returning continent.map(_.id)
            into ((continentName, id) => Continent(id, continentName))
            ) += (name)
        }
        "Continent added successfully"
      }
      else "Continent is already existing"
    }
    else "Continent's name must be only alphabets/code can be only between 1-7"
  }

  def addCitiesToTheCountry(newCities:Array[CityRef])={

    val filtered =for{
      eachCity <- newCities
      if(!getAllCities.exists(_.cityName.equalsIgnoreCase(eachCity.cityName)))
      if(getAllCountries.exists(_.countryName.equalsIgnoreCase(eachCity.countryName)))
    } yield eachCity
    val errors=newCities.diff(filtered)
    if(errors.isEmpty){
      for (x <- filtered){
        db.run {

          (city.map(p => (p.cityName, p.countryName))
            returning city.map(_.id)
            into ((nameCount, id) => Country(id, nameCount._1, nameCount._2))
            ) += (x.cityName, x.countryName)
        }
      }
      "All cities added successfully"
    }
    else
      errors.map(_.cityName).mkString("The following cities",","," are either available or with wrong country code ")
  }

  def createCountry(countryVal: CountryRef): String = {

    if(countryVal.countryName.matches("[A-Za-z]+")) {
      if(getAll.exists(p => p.continentName.equalsIgnoreCase(countryVal.continentName))) {
        if(!getAllCountries.exists(p => p.countryName.equalsIgnoreCase(countryVal.countryName))) {
          db.run {
            (country.map(p => (p.countryName, p.continentName))
              returning country.map(_.id)
              into ((nameCont, id) => Country(id, nameCont._1, nameCont._2))
              ) += (countryVal.countryName, countryVal.continentName)
          }
          "Country added successfully"
        }
        else s"Country ${countryVal.countryName} already present in ${countryVal.continentName} continent."
      }
      else s"Continent ${countryVal.continentName} does not exist in the world."
    }
    else "Continent's name must be only alphabets/code can be only between 1-7"
  }

  def getContinentOfACountry(countryName:String):String={
    val filteredCountry=getAllCountries.find(_.countryName.equalsIgnoreCase(countryName))
    filteredCountry.isDefined match{
      case true =>
        filteredCountry.get.continentName
      case false=>
        "No Country Details found"
    }
  }

  def checkIfTwoCountryLiesInSameContinent(first:String,second:String): String ={

    val countryList = getAllCountries
    if(first.isEmpty || second.isEmpty){
      "Either of the given input is empty."
    }else{
      countryList.find(_.countryName.equalsIgnoreCase(first)).getOrElse(Country(0,"","A")).continentName.equalsIgnoreCase(countryList.find(_.countryName.equalsIgnoreCase(second)).getOrElse(Country(1,"","B")).continentName) match {
        case true => {
          val countryDetail = countryList.find(p=>p.countryName.equalsIgnoreCase(first)).get.continentName
          s"Both ${first} and ${second} are present in same continent ${countryDetail}"
        }
        case false => s"Both ${first} and ${second} are not present in same continent"
      }
    }

  }

  def getAllCitiesOfContinent(continent:String):Seq[City]={
    for{
      continent <- getAll.filter(_.continentName.equalsIgnoreCase(continent))
      country <- getAllCountries.filter(_.continentName.equalsIgnoreCase(continent.continentName))
      city <- getAllCities.filter(_.countryName.equalsIgnoreCase(country.countryName))
    } yield city

  }

  def groupCitiesByFirstLetter=getAllCities.groupBy(_.cityName.charAt(0).toString).toList

  def continentList(): Future[Seq[Continent]] = db.run {continent.result}
  def countryList(): Future[Seq[Country]] = db.run {country.result}
  def cityList(): Future[Seq[City]] = db.run {city.result}

  def getAll: Seq[Continent] = Await.result(continentList, 5.seconds)
  def getAllCountries: Seq[Country] = Await.result(countryList, 5.seconds)
  def getAllCities: Seq[City] = Await.result(cityList, 5.seconds)

  def deleteContinent(continentName : String) : String = {
    val resultList = getAll
    val contobject = resultList.find(_.continentName.equalsIgnoreCase(continentName)).getOrElse(Continent(0,""))
    if(resultList.exists(p => p.continentName.equalsIgnoreCase(continentName))){
      db.run{
        continent.filter(_.continentName.toUpperCase === contobject.continentName.toUpperCase).delete
      }

      s" ${continentName} continent Deleted Successfully."
    }else{
      s"There is no continent with name ${continentName}"
    }

  }
}