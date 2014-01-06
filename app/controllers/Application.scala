package controllers

import play.api._
import play.api.mvc._
import play.api.data.{Forms, Form}
import play.api.data.Forms._
import play.api.libs.json.{JsValue, Json, JsString}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
// Reactive Mongo imports
import reactivemongo.api._

// Reactive Mongo plugin, including the JSON-specialized collection
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection

object Application extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("activities")

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def activities =Action{
      Ok(views.html.activities())
  }

  def createActivity=Action.async(parse.json){ request =>

    val activityJson:JsValue = request.body
    collection.insert(activityJson).map(lastError =>
      Ok("Mongo LastError: %s".format(lastError)))
  }
}