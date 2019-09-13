package models

import play.api.libs.json.Json

case class StringResponse(continent:Seq[Continent],msg:String)

object StringResponse{
  implicit val responseReads =Json.reads[StringResponse]
  implicit val responseWrites =Json.writes[StringResponse]
}
