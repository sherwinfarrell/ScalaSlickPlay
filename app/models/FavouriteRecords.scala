package models
import io.circe.generic.semiauto._
import io.circe._
import io.circe.syntax._

case class FavouriteRecords(id: Int, recordName :String)


 object FavouriteRecords {

   def getData() = FavouriteRecords(23, "sherwin").asJson

   implicit val decodeUser: Decoder[FavouriteRecords] = deriveDecoder[FavouriteRecords]
   implicit val encoderUser: Encoder[FavouriteRecords] = deriveEncoder[FavouriteRecords]
 }


