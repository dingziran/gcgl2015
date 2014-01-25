package controllers

import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import reactivemongo.bson._
import reactivemongo.api.collections.default.BSONCollection

// Reactive Mongo imports
import reactivemongo.api._

// Reactive Mongo plugin, including the JSON-specialized collection
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection

object Application extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("activities")
  def collection2: BSONCollection = db.collection[BSONCollection]("activities")
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

  def delete=Action.async(parse.json){request =>
    val id:String=(request.body\("id")).as[String]

    System.out.println(id)
    val activityJson = BSONDocument(
      "_id" -> BSONObjectID(id)
    )
    collection2.remove(activityJson).map(lastError =>
      Ok("Mongo LastError: %s".format(lastError)))
  }

  def listActivities=Action.async{request =>
    val query=Json.obj()
    val activities=collection.find(query).cursor[JsObject].collect[List]()
    activities.map{ result =>
      Ok(Json.toJson(result))
    }
  }
}