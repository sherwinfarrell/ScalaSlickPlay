package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import javax.inject.Inject
import play.api.mvc.{AbstractController, Action, BaseController, ControllerComponents}
import io.circe._
import io.circe.generic.semiauto._
import play.api.libs.json.{Json, Writes}
import io.circe.syntax._
import models.FavouriteRecords._
import play.api.http
import play.api.http.{HttpErrorHandler, Writeable}
import play.api.libs.circe
import play.api.libs.circe.Circe

import cats.Semigroup._




class Application  @Inject()(val errorHandler: HttpErrorHandler, cc: ControllerComponents) extends AbstractController(cc) with Circe {
  //override def circeErrorHandler = errorHandler
  def function = Action{

    Ok("hello world")
  }

  def parserJson = Action{
      Ok(getData())
  }



}
